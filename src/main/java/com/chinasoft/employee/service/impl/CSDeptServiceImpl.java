package com.chinasoft.employee.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;

import com.chinasoft.employee.controller.vo.request.UserRoleRequestVO;
import com.chinasoft.employee.controller.vo.response.CSDeptResponseVO;
import com.chinasoft.employee.controller.vo.response.DictionaryResponseVO;
import com.chinasoft.employee.controller.vo.response.HsbcCSDeptResponseVO;
import com.chinasoft.employee.dao.entity.CSDeptDO;
import com.chinasoft.employee.dao.entity.CSDeptDOExample;
import com.chinasoft.employee.dao.entity.CSDeptDOExample.Criteria;
import com.chinasoft.employee.dao.entity.DictionaryDO;
import com.chinasoft.employee.dao.entity.DictionaryDOExample;
import com.chinasoft.employee.dao.mapper.CSDeptDOMapper;
import com.chinasoft.employee.dao.mapper.DictionaryDOMapper;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.exception.EmBusinessError;
import com.chinasoft.employee.service.CSDeptService;
import com.chinasoft.employee.service.DictionarySevice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CSDeptServiceImpl implements CSDeptService {
	
	@Autowired
	private CSDeptDOMapper cSDeptDOMapper;
	@Autowired
	private DictionaryDOMapper dictionaryDOMapper;
	@Autowired
	private DictionarySevice dictionarySevice;
	@Autowired
	private CSDeptDOMapper csDeptDOMapper;
	
	private static final String BUSINESSHSBCUNIT ="businessHSBCUnit";
	private static final String BUSINESSHSBCLINE ="businessHSBCLine";
	private static final String CSHSBCDEPT ="csHSBCDept";
	@Override
	public List<CSDeptResponseVO> getAllCSDept(UserRoleRequestVO userRoleRequestVO) throws BusinessException {
		
		List<CSDeptResponseVO> cSDeptResult = null;
		CSDeptDOExample example = new CSDeptDOExample();
		try {
		    List<CSDeptDO> CSDeptlist = cSDeptDOMapper.selectByExample(example);
			log.info("List<CSDeptDO> DataBase Info[{}]", new ObjectMapper().writeValueAsString(CSDeptlist.size()));
			cSDeptResult = this.mapperToCSDeptVO(CSDeptlist,userRoleRequestVO);
		} catch (JsonProcessingException e) {
			log.error("数据库查询异常:[{}]", e.getMessage());
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, e.getMessage());
		}
		return cSDeptResult;
	}
	
	/**
	 * 根据登录用户所在的部门id,查看该部门下面级联所有部门
	 */
	@Override
	public List<CSDeptResponseVO> getAllDeptByLoginUser(UserRoleRequestVO userRoleRequestVO) throws BusinessException {

		String userType = userRoleRequestVO.getUserType();
		List<Integer> csDepts = stringToList(userRoleRequestVO.getCsdeptId());
		List<Integer> results = new ArrayList<>();
		for(Integer csInt : csDepts) {
			Integer csdp = 16;
			if("9".equals(userType)||"13".equals(userType)||"14".equals(userType)) {
				CSDeptDO csdo = csDeptDOMapper.selectByPrimaryKey(csInt);
				if(null!=csdo && null!=csdo.getParentId()) {
					csdp = csdo.getParentId();
				}
			}else if("19".equals(userType)||"11".equals(userType)||"12".equals(userType)||"8".equals(userType)) {
			    	csdp = 10001;
			}else {
				csdp = csInt;
			}
			results.add(csdp);
		}
		return this.mapperToCSDeptVOByLoginUser(results);
	}
	
	private List<CSDeptResponseVO> mapperToCSDeptVOByLoginUser(List<Integer> csDept) {
		List<CSDeptResponseVO> relustList = new ArrayList<>();
		for (Integer dept : csDept) {
			boolean flag = false;
			CSDeptResponseVO cSDeptVO = new CSDeptResponseVO();
			CSDeptDOExample csDeptexample = new CSDeptDOExample();
			Criteria csDeptCriteria = csDeptexample.createCriteria();
			csDeptCriteria.andPkIdEqualTo(dept);
			List<CSDeptDO> csDeptList = cSDeptDOMapper.selectByExample(csDeptexample);
			cSDeptVO.setValue(csDeptList.get(0).getPkId());
			cSDeptVO.setLabel(csDeptList.get(0).getCsDeptName());
			Integer parentId = csDeptList.get(0).getParentId();
			for (Integer deptCheck : csDept) {
				if (parentId == deptCheck) {
					flag = true;
				}
			}
			if (flag) {
				continue;
			}
			CSDeptDOExample example = new CSDeptDOExample();
			Criteria csDeptChildren = example.createCriteria();
			csDeptChildren.andParentIdEqualTo(dept);
			List<CSDeptDO> cSDeptChildrenlist = cSDeptDOMapper.selectByExample(example);
			List<CSDeptResponseVO> childrenRelust = new ArrayList<>();

			for (CSDeptDO cSDeptChildren : cSDeptChildrenlist) {
				this.getChildrenCSDeptByLoginUser(cSDeptChildren, childrenRelust, cSDeptVO);
			}
			cSDeptVO.setChildren(childrenRelust);
			relustList.add(cSDeptVO);

		}
		return relustList.stream().filter(distinctByKey(CSDeptResponseVO::getValue)).collect(Collectors.toList());
	}
    /**
     * 函数式接口 T -> bollean
     * @param keyExtractor
     * @param <T>
     * @return
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        ConcurrentHashMap<Object, Boolean> map = new ConcurrentHashMap<>(16);
        return t -> map.putIfAbsent(keyExtractor.apply(t),Boolean.TRUE) == null;
    }
	
	private void getChildrenCSDeptByLoginUser(CSDeptDO cSDeptChildren,List<CSDeptResponseVO> childrenRelust,CSDeptResponseVO cSDeptVO) {
		if(null != cSDeptChildren.getParentId()) {
			CSDeptResponseVO vo = new CSDeptResponseVO();
			vo.setValue(cSDeptChildren.getPkId());
			vo.setLabel(cSDeptChildren.getCsDeptName());
			childrenRelust.add(vo);
			cSDeptVO.setChildren(childrenRelust);
			
			CSDeptDOExample example = new CSDeptDOExample();
			Criteria ehr = example.createCriteria();
			ehr.andParentIdEqualTo(cSDeptChildren.getPkId());
			List<CSDeptDO> cSDeptChildrenlist = cSDeptDOMapper.selectByExample(example);
			List<CSDeptResponseVO> subRelust = new ArrayList<>();
			for(CSDeptDO cSDeptSub:cSDeptChildrenlist) {
				this.getChildrenCSDeptByLoginUser(cSDeptSub, subRelust,vo);
			}
		}
	}
	
	/**
	 * Do转HSBCCSDeptVO
	 * @param CSDeptlist
	 * @return
	 */
	private List<HsbcCSDeptResponseVO> mapperToCSDeptVO(List<DictionaryDO> hsbcCSDeptlist){
		List<HsbcCSDeptResponseVO> relustList = new ArrayList<>();
		if(null != hsbcCSDeptlist) {
			for(DictionaryDO csDept:hsbcCSDeptlist) {
				HsbcCSDeptResponseVO cSDeptVO = new HsbcCSDeptResponseVO();
				if(null == csDept.getParentId() && csDept.getParamCode() != 0) {
					cSDeptVO.setValue(csDept.getParamCode());
					cSDeptVO.setLabel(csDept.getParamName());
					DictionaryDOExample example = new DictionaryDOExample();
					com.chinasoft.employee.dao.entity.DictionaryDOExample.Criteria ehr = example.createCriteria();

					ehr.andParentIdEqualTo(csDept.getPkId());
					List<DictionaryDO> cSDeptChildrenlist = dictionaryDOMapper.selectByExample(example);
					List<HsbcCSDeptResponseVO> childrenRelust = new ArrayList<>();
					for(DictionaryDO cSDeptChildren:cSDeptChildrenlist) {
						this.getChildrenCSDept(cSDeptChildren, childrenRelust, cSDeptVO);
					}
					cSDeptVO.setChildren(childrenRelust);
					relustList.add(cSDeptVO);
				}
			}
		}
		return relustList;
	}
	
	/**
	 * Do转HSBCCSDeptVO
	 * @param CSDeptlist
	 * @return
	 */
	private Map<String,Object> mapperToCSDeptVODiff(List<DictionaryDO> hsbcCSDeptlist) {
		Map<String, Object> map = new HashMap<>();
		
		List<DictionaryDO> businessUnitList = new ArrayList<>();
		List<DictionaryDO> businessLineList = new ArrayList<>();
		List<DictionaryDO> csDeptList = new ArrayList<>();

		List<HsbcCSDeptResponseVO> list = mapperToCSDeptVO(hsbcCSDeptlist);
		if (null != list && list.size() > 0) {
			for (HsbcCSDeptResponseVO vo : list) {
				DictionaryDO utilVO = new DictionaryDO();
				utilVO.setTypeCode(16);
				utilVO.setTypeName(BUSINESSHSBCUNIT);
				utilVO.setParamCode(vo.getValue());
				utilVO.setParamName(vo.getLabel());
				utilVO.setRelatedCode(vo.getValue());
				utilVO.setRelatedName(vo.getLabel());
				utilVO.setStatus(0);
				businessUnitList.add(utilVO);
				List<HsbcCSDeptResponseVO> childrenLine = vo.getChildren();
				if (null != childrenLine && childrenLine.size() > 0)
					for (HsbcCSDeptResponseVO children : childrenLine) {
						DictionaryDO lineVO = new DictionaryDO();
						lineVO.setTypeCode(16);
						lineVO.setTypeName(BUSINESSHSBCLINE);
						lineVO.setParamCode(children.getValue());
						lineVO.setParamName(children.getLabel());
						lineVO.setRelatedCode(children.getValue());
						lineVO.setRelatedName(children.getLabel());
						lineVO.setStatus(0);
						businessLineList.add(lineVO);
						List<HsbcCSDeptResponseVO> childrenDept = children.getChildren();
						if(null != childrenDept && childrenDept.size() > 0) {
							for (HsbcCSDeptResponseVO response : childrenDept) {
								DictionaryDO deptVO = new DictionaryDO();
								deptVO.setTypeCode(16);
								deptVO.setTypeName(CSHSBCDEPT);
								deptVO.setParamCode(response.getValue());
								deptVO.setParamName(response.getLabel());
								deptVO.setRelatedCode(response.getValue());
								deptVO.setRelatedName(response.getLabel());
								deptVO.setStatus(0);
								csDeptList.add(deptVO);
							}
						}
					}
			}
		}
		map.put(BUSINESSHSBCUNIT, businessUnitList);
		map.put(BUSINESSHSBCLINE, businessLineList);
		map.put(CSHSBCDEPT, csDeptList);
		return map;
	}
	
	/**
	 * Do转CSDeptVO
	 * @param CSDeptlist
	 * @return
	 */
	private List<CSDeptResponseVO> mapperToCSDeptVO(List<CSDeptDO> CSDeptlist,UserRoleRequestVO userRoleRequestVO){
		List<CSDeptResponseVO> relustList = new ArrayList<>();
		if(null != CSDeptlist) {
			Integer userType = null ;
			Integer userBlId = null;
			Integer userBuId = null;
			if(userRoleRequestVO!=null){
				userType = Integer.valueOf(userRoleRequestVO.getUserType());
				userBlId = userRoleRequestVO.getBlId();
				userBuId = userRoleRequestVO.getBuId();
			}
			for(CSDeptDO csDept:CSDeptlist) {
				CSDeptResponseVO cSDeptVO = new CSDeptResponseVO();
				if(null == csDept.getParentId()) {
					/*cSDeptVO.setPkId(csDept.getPkId());
					cSDeptVO.setCSDeptName(csDept.getCsDeptName());*/
					if(userRoleRequestVO!=null){
						if(userType !=0 && !csDept.getPkId().equals(userBlId)){
							continue;
						}
					}
					cSDeptVO.setValue(csDept.getPkId());
					cSDeptVO.setLabel(csDept.getCsDeptName());
					CSDeptDOExample example = new CSDeptDOExample();
					Criteria ehr = example.createCriteria();
					ehr.andParentIdEqualTo(csDept.getPkId());
					List<CSDeptDO> cSDeptChildrenlist = cSDeptDOMapper.selectByExample(example);
					List<CSDeptResponseVO> childrenRelust = new ArrayList<>();
					for(CSDeptDO cSDeptChildren:cSDeptChildrenlist) {
						if(userRoleRequestVO!=null){
							if(userType !=0 && userType!=15 && !cSDeptChildren.getPkId().equals(userBuId)){
								continue;
							}
						}
						this.getChildrenCSDept(cSDeptChildren, childrenRelust, cSDeptVO ,userRoleRequestVO);
					}
					cSDeptVO.setChildren(childrenRelust);
					relustList.add(cSDeptVO);
				}
			}
		}
		return relustList;
	}
	
	private void getChildrenCSDept(CSDeptDO cSDeptChildren,List<CSDeptResponseVO> childrenRelust,CSDeptResponseVO cSDeptVO ,UserRoleRequestVO userRoleRequestVO) {
		if(null != cSDeptChildren.getParentId()) {
			Integer userType = null;
			Integer csdeptId = null;
			if(userRoleRequestVO!=null){
				userType = Integer.valueOf(userRoleRequestVO.getUserType());
				csdeptId = Integer.valueOf(userRoleRequestVO.getCsdeptId());
			}
			CSDeptResponseVO vo = new CSDeptResponseVO();
		/*vo.setPkId(cSDeptChildren.getPkId());
			vo.setCSDeptName(cSDeptChildren.getCsDeptName());*/
			vo.setValue(cSDeptChildren.getPkId());
			vo.setLabel(cSDeptChildren.getCsDeptName());
			childrenRelust.add(vo);
			cSDeptVO.setChildren(childrenRelust);
			
			CSDeptDOExample example = new CSDeptDOExample();
			Criteria ehr = example.createCriteria();
			ehr.andParentIdEqualTo(cSDeptChildren.getPkId());
			List<CSDeptDO> cSDeptChildrenlist = cSDeptDOMapper.selectByExample(example);
			List<CSDeptResponseVO> subRelust = new ArrayList<>();
			for(CSDeptDO cSDeptSub:cSDeptChildrenlist) {
				if(userRoleRequestVO!=null){
					if(userType !=0 && userType!=15 && userType !=1 && !cSDeptSub.getPkId().equals(csdeptId)){
						continue;
					}
				}
				this.getChildrenCSDept(cSDeptSub, subRelust,vo,userRoleRequestVO);
			}
		}
	}
	private void getChildrenCSDept(DictionaryDO cSDeptChildren,List<HsbcCSDeptResponseVO> childrenRelust,HsbcCSDeptResponseVO cSDeptVO) {
		if(null != cSDeptChildren.getParentId()) {
			HsbcCSDeptResponseVO vo = new HsbcCSDeptResponseVO();
			vo.setValue(cSDeptChildren.getParamCode());
			vo.setLabel(cSDeptChildren.getParamName());
			childrenRelust.add(vo);
			cSDeptVO.setChildren(childrenRelust);
			
			DictionaryDOExample example = new DictionaryDOExample();
			com.chinasoft.employee.dao.entity.DictionaryDOExample.Criteria ehr = example.createCriteria();

			ehr.andParentIdEqualTo(cSDeptChildren.getPkId());
			List<DictionaryDO> cSDeptChildrenlist = dictionaryDOMapper.selectByExample(example);
			
			List<HsbcCSDeptResponseVO> subRelust = new ArrayList<>();
			for(DictionaryDO cSDeptSub:cSDeptChildrenlist) {
				this.getChildrenCSDept(cSDeptSub, subRelust,vo);
			}
		}
	}

	public List<CSDeptDO> getAllCSDeptByCSBGId(Integer csbgId) throws BusinessException {
		CSDeptDOExample example = new CSDeptDOExample();
		return cSDeptDOMapper.selectByExample(example);
	}
	
	public List<CSDeptDO> getAllCSDeptById(Integer csbgId) throws BusinessException {
		CSDeptDOExample example = new CSDeptDOExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPkIdEqualTo(csbgId);
		List<CSDeptDO> total = cSDeptDOMapper.selectByExample(example);
		if (csbgId < 1000 & csbgId > 100) {
			//事业部
			CSDeptDOExample example1 = new CSDeptDOExample();
			Criteria createCriteria1 = example1.createCriteria();
			createCriteria1.andParentIdEqualTo(csbgId);
			List<CSDeptDO> selectByExample1 = cSDeptDOMapper.selectByExample(example1);
			total.addAll(selectByExample1);
		} else if (csbgId > 1000 && csbgId < 10000) {
			CSDeptDOExample example1 = new CSDeptDOExample();
			Criteria createCriteria1 = example1.createCriteria();
			createCriteria1.andParentIdEqualTo(csbgId);
			List<CSDeptDO> selectByExample1 = cSDeptDOMapper.selectByExample(example1);
			total.addAll(selectByExample1);
			for (CSDeptDO csDeptDO : selectByExample1) {
				CSDeptDOExample example2 = new CSDeptDOExample();
				Criteria createCriteria2 = example2.createCriteria();
				createCriteria2.andParentIdEqualTo(csDeptDO.getPkId());
				List<CSDeptDO> selectByExample2 = cSDeptDOMapper.selectByExample(example2);
				total.addAll(selectByExample2);
			}
		} else if(csbgId > 10000){
			CSDeptDOExample example1 = new CSDeptDOExample();
			return cSDeptDOMapper.selectByExample(example1);
		}
		return total;
	}
	
	public List<CSDeptDO> getAllCSDeptById(Integer csftId, Integer csLgId) throws BusinessException {

		List<CSDeptDO> allLGDepts = getAllCSDeptById(csLgId);
		List<CSDeptDO> allFTDepts = getAllCSDeptById(csftId);
		List<CSDeptDO> listD = new ArrayList<>();
		for (CSDeptDO csDeptDOF : allFTDepts) {
			for (CSDeptDO csDeptDOL : allLGDepts) {
				if (csDeptDOF.getPkId().equals(csDeptDOL.getPkId())) {
					listD.add(csDeptDOF);
				}
			}
		}

		return listD;
	}
	public List<CSDeptDO> getAllCSDeptByCSbuId(Integer csbuId) throws BusinessException{
		CSDeptDOExample example = new CSDeptDOExample();
		Criteria ehr = example.createCriteria();
		ehr.andParentIdEqualTo(csbuId);
		List<CSDeptDO> csDeptlist = cSDeptDOMapper.selectByExample(example);
		csDeptlist.add(cSDeptDOMapper.selectByPrimaryKey(csbuId));
        return csDeptlist;
	}
	public List<CSDeptDO> getAllCSDeptByCSblId(Integer csblId) throws BusinessException{
		List<CSDeptDO> csbulist = this.getAllCSDeptByCSbuId(csblId);
		Iterator<CSDeptDO> itcsbu = csbulist.iterator();
		List<CSDeptDO> csDeptlist = new ArrayList<CSDeptDO>();
		while (itcsbu.hasNext()){
			csDeptlist.addAll(getAllCSDeptByCSbuId(itcsbu.next().getPkId()));
		}
		return csDeptlist;
	}
	public Integer getCSbuIdByCSDeptId(Integer csDeptId) throws BusinessException{
		CSDeptDO csDeptDO = cSDeptDOMapper.selectByPrimaryKey(csDeptId);
		Integer csbuId = csDeptDO.getParentId();
		return csbuId;
	}
	public Integer getCSblIdByCSDeptId(Integer csDeptId) throws BusinessException{
		Integer csbuId = getCSbuIdByCSDeptId(csDeptId);
		Integer csblId;
		if(csbuId!=null) {
			csblId = getCSbuIdByCSDeptId(csbuId);
		}
		else csblId = csDeptId;//当前登录用户的部门只有业务线，不存在事业部和交付部
		return csblId;
	}

	@Override
	public List<HsbcCSDeptResponseVO> getHsbcDept() throws BusinessException {
		List<HsbcCSDeptResponseVO> hsbcDeptResult = null;
		try {
			Map<String, Object> hsbcDeptMap = dictionarySevice.getDictionary(1,"hsbcDept");
			List<DictionaryDO> listD = (List<DictionaryDO>) hsbcDeptMap.get("hsbcDept");
			hsbcDeptResult = this.mapperToCSDeptVO(listD);
		} catch (Exception e) {
			log.error("数据库查询异常:[{}]", e.getMessage());
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, e.getMessage());
		}
		return hsbcDeptResult;
	}
	
	@Override
	public Map<String, Object> getHsbcDeptDiff() throws BusinessException {
		Map<String, Object> responseList = new HashMap<>();
		try {
			Map<String, Object> hsbcDeptMap = dictionarySevice.getDictionary(1, "hsbcDept");
			List<DictionaryDO> listD = (List<DictionaryDO>) hsbcDeptMap.get("hsbcDept");
			responseList = this.mapperToCSDeptVODiff(listD);
		} catch (Exception e) {
			log.error("数据库查询异常:[{}]", e.getMessage());
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, e.getMessage());
		}
		return responseList;
	}
	
	private List<Integer> stringToList(String str) {
		List<Integer> listS = new ArrayList<>();
		if (null != str && str.length() > 0) {
			String[] split = str.split(",");
			if (null != split && split.length > 0) {
				for (int i = 0; i < split.length; i++) {
					listS.add(Integer.valueOf(split[i]));
				}
			}
		}
		return listS;
	}
}
