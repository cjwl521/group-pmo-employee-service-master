package com.chinasoft.employee.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.employee.controller.vo.response.DictionaryResponseVO;
import com.chinasoft.employee.dao.entity.DictionaryDO;
import com.chinasoft.employee.dao.entity.DictionaryDOExample;
import com.chinasoft.employee.dao.entity.DictionaryDOExample.Criteria;
import com.chinasoft.employee.dao.mapper.DictionaryDOMapper;
import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.exception.EmBusinessError;
import com.chinasoft.employee.service.DictionarySevice;
import com.chinasoft.employee.service.model.DictionaryModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DictionarySeviceImpl implements DictionarySevice {

	@Autowired
	private DictionaryDOMapper dictionaryDOMapper;
	
	private static final Integer STATUS = 0;
	private static final String OPTIONS = "options";
	private static final String DICTIONARY_ORDER = "TYPE_CODE ASC,PARAM_CODE ASC";
	@Override
	public Map<String, Object> getDictionary(int flag,String typeName) throws BusinessException {
		Map<String, Object> optionMap = new HashMap<String ,Object>(16);
		if(flag == 0) {
        	DictionaryDOExample example = new DictionaryDOExample();
    		Criteria ehr = example.createCriteria();
    		example.setOrderByClause(DICTIONARY_ORDER);
    		// 添加过滤条件STATUS，默认为"0"
    		ehr.andStatusEqualTo(STATUS);
    		try {
    			// 通过selectByExample查询dictionary信息
    			List<DictionaryDO> listD = dictionaryDOMapper.selectByExample(example);

    			log.info("List<DictionaryDO> DataBase Info[{}]", new ObjectMapper().writeValueAsString(listD));
    			// mapper转MenuVO
    			optionMap = mapperToMenuVO(listD);
    		} catch (Exception e) {
    			log.error("数据库查询异常:[{}]", e.getMessage());
    			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, e.getMessage());
    		}
    	
        }else if(flag == 1) {
        	DictionaryDOExample example = new DictionaryDOExample();
    		Criteria ehr = example.createCriteria();
    		ehr.andTypeNameEqualTo(typeName);
    		example.setOrderByClause(DICTIONARY_ORDER);
    		// 添加过滤条件STATUS，默认为"0"
    		ehr.andStatusEqualTo(STATUS);
    		try {
    			// 通过selectByExample查询dictionary信息
    			List<DictionaryDO> listD = dictionaryDOMapper.selectByExample(example);

    			log.info("List<DictionaryDO> DataBase Info[{}]", new ObjectMapper().writeValueAsString(listD));
    			// mapper转MenuVO
    			
    			optionMap.put("hsbcDept", listD);
    			//optionMap = mapperToMenuVO(listD);
    		} catch (Exception e) {
    			log.error("数据库查询异常:[{}]", e.getMessage());
    			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, e.getMessage());
    		}
        }
		return optionMap;
		
	}

	@Override
	public List<DictionaryModel> getDictionary(Integer typeCode) throws BusinessException {

		DictionaryDOExample example = new DictionaryDOExample();
		List<DictionaryModel> optionDict = new ArrayList<>();
		Criteria ehr = example.createCriteria();
		example.setOrderByClause(DICTIONARY_ORDER);
		// 添加过滤条件STATUS，默认为"0"
		ehr.andStatusEqualTo(STATUS);
		ehr.andTypeCodeEqualTo(typeCode);
		try {
			// 通过selectByExample查询dictionary信息
			List<DictionaryDO> listD = dictionaryDOMapper.selectByExample(example);

			log.info("List<DictionaryDO> DataBase Info[{}]", new ObjectMapper().writeValueAsString(listD));
			// mapper转MenuVO
			for (DictionaryDO dictionaryDO : listD) {
				DictionaryModel dictModel = new DictionaryModel();
				BeanUtils.copyProperties(dictionaryDO, dictModel);
				optionDict.add(dictModel);
			}
		} catch (Exception e) {
			log.error("数据库查询异常:[{}]", e.getMessage());
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, e.getMessage());
		}
		return optionDict;
	}
	
	@Override
	public Map<String, List<DictionaryModel>> getDictionaryMap() throws BusinessException {

		Map<String, List<DictionaryModel>> tMap = null;
		DictionaryDOExample example = new DictionaryDOExample();
		Criteria ehr = example.createCriteria();
		example.setOrderByClause(DICTIONARY_ORDER);
		// 添加过滤条件STATUS，默认为"0"
		ehr.andStatusEqualTo(STATUS);
		try {
			// 通过selectByExample查询dictionary信息
			List<DictionaryDO> listD = dictionaryDOMapper.selectByExample(example);

			log.info("List<DictionaryDO> DataBase Info[{}]", new ObjectMapper().writeValueAsString(listD));
			// mapper转Map
			tMap = mapperDOToMap(listD);
		} catch (Exception e) {
			log.error("数据库查询异常:[{}]", e.getMessage());
			throw new BusinessException(EmBusinessError.UNKNOW_ERROR, e.getMessage());
		}
		return tMap;
	}
	/**
	 * 方法：mapper转MenuVO 参数：List<DictionaryDO> listD 返回：Map<String, Object>
	 */
	private Map<String, Object> mapperToMenuVO(List<DictionaryDO> listD) {

		// 最外层option对象
		Map<String, Object> optionMap = new HashMap<String, Object>();
		// 初始化typeCode为null
		if (null != listD) {
			Map<String, Object> tMap = new LinkedHashMap<String, Object>();
			List<DictionaryResponseVO> listVO = null;
			// 遍历查询结果
			String typeName = null;
			for (DictionaryDO dictionaryDO : listD) {
				// 初始化DictionaryResponseVO，并装载数据

				DictionaryResponseVO responseVO = new DictionaryResponseVO();
				responseVO.setTypeName(dictionaryDO.getTypeName());
				responseVO.setTypeCode(dictionaryDO.getTypeCode());
				responseVO.setRelatedName(dictionaryDO.getRelatedName());
				responseVO.setRelatedCode(dictionaryDO.getRelatedCode());
				responseVO.setParamName(dictionaryDO.getParamName());
				responseVO.setParamCode(dictionaryDO.getParamCode());
				typeName = dictionaryDO.getTypeName();
				if (!(tMap.keySet().contains(typeName))) {
					listVO = new ArrayList<>();
					tMap.put(typeName, listVO);
				}
				listVO.add(responseVO);

			}
			optionMap.put(OPTIONS, tMap);
		}
		return optionMap;
	}
	/**
	 * 方法：mapper转Map
	 * 参数：List<DictionaryDO> listD 
	 * 返回：Map<String, List<DictionaryModel>>
	 */
	private Map<String, List<DictionaryModel>> mapperDOToMap(List<DictionaryDO> listD) {

		Map<String, List<DictionaryModel>> tMap = new LinkedHashMap<>();
		// 初始化typeCode为null
		if (null != listD) {
			List<DictionaryModel> listVO = null;
			// 遍历查询结果
			String typeName = null;
			for (DictionaryDO dictionaryDO : listD) {
				// 初始化DictionaryResponseVO，并装载数据

				DictionaryModel responseVO = new DictionaryModel();
				responseVO.setTypeName(dictionaryDO.getTypeName());
				responseVO.setTypeCode(dictionaryDO.getTypeCode());
				responseVO.setRelatedName(dictionaryDO.getRelatedName());
				responseVO.setRelatedCode(dictionaryDO.getRelatedCode());
				responseVO.setParamName(dictionaryDO.getParamName());
				responseVO.setParamCode(dictionaryDO.getParamCode());
				typeName = dictionaryDO.getTypeName();
				if (!(tMap.keySet().contains(typeName))) {
					listVO = new ArrayList<>();
					tMap.put(typeName, listVO);
				}
				listVO.add(responseVO);

			}
		}
		return tMap;
	}
	
	@Override
    public Map<String, Map<Integer,DictionaryModel>> getDictionaryMapMap() throws BusinessException {

	    Map<String, Map<Integer,DictionaryModel>> tMap = null;
        DictionaryDOExample example = new DictionaryDOExample();
        Criteria ehr = example.createCriteria();
        example.setOrderByClause(DICTIONARY_ORDER);
        // 添加过滤条件STATUS，默认为"0"
        ehr.andStatusEqualTo(STATUS);
        try {
            // 通过selectByExample查询dictionary信息
            List<DictionaryDO> listD = dictionaryDOMapper.selectByExample(example);

            log.info("List<DictionaryDO> DataBase Info[{}]", new ObjectMapper().writeValueAsString(listD));
            // mapper转Map
            tMap = mapperDOToMapUseCode(listD);
        } catch (Exception e) {
            log.error("数据库查询异常:[{}]", e.getMessage());
            throw new BusinessException(EmBusinessError.UNKNOW_ERROR, e.getMessage());
        }
        return tMap;
    }
	
	@Override
	public Map<Integer, Map<Integer, DictionaryModel>> getDictionaryMapMapInteger() throws BusinessException {
		Map<Integer, Map<Integer,DictionaryModel>> tMap = null;
        DictionaryDOExample example = new DictionaryDOExample();
        Criteria ehr = example.createCriteria();
        example.setOrderByClause(DICTIONARY_ORDER);
        // 添加过滤条件STATUS，默认为"0"
        ehr.andStatusEqualTo(STATUS);
        try {
            // 通过selectByExample查询dictionary信息
            List<DictionaryDO> listD = dictionaryDOMapper.selectByExample(example);

            log.info("List<DictionaryDO> DataBase Info[{}]", new ObjectMapper().writeValueAsString(listD));
            // mapper转Map
            tMap = mapperDOToMapUseCodeInteger(listD);
        } catch (Exception e) {
            log.error("数据库查询异常:[{}]", e.getMessage());
            throw new BusinessException(EmBusinessError.UNKNOW_ERROR, e.getMessage());
        }
        return tMap;
	}
	
	/**
     * 方法：mapper转Map
     * 参数：List<DictionaryDO> listD 
     * 返回：Map<String, List<DictionaryModel>>
     */
    private Map<String, Map<Integer,DictionaryModel>> mapperDOToMapUseCode(List<DictionaryDO> listD) {

        Map<String, Map<Integer,DictionaryModel>> tMap = new LinkedHashMap<>();
        // 初始化typeCode为null
        if (null != listD) {
            Map<Integer,DictionaryModel> mapVo = null;
            // 遍历查询结果
            String typeName = null;
            for (DictionaryDO dictionaryDO : listD) {
                // 初始化DictionaryResponseVO，并装载数据

                DictionaryModel responseVO = new DictionaryModel();
                responseVO.setTypeName(dictionaryDO.getTypeName());
                responseVO.setTypeCode(dictionaryDO.getTypeCode());
                responseVO.setRelatedName(dictionaryDO.getRelatedName());
                responseVO.setRelatedCode(dictionaryDO.getRelatedCode());
                responseVO.setParamName(dictionaryDO.getParamName());
                responseVO.setParamCode(dictionaryDO.getParamCode());
                typeName = dictionaryDO.getTypeName();
                if (!(tMap.keySet().contains(typeName))) {
                    mapVo = new LinkedHashMap<>();
                    tMap.put(typeName, mapVo);
                }
                mapVo.put(dictionaryDO.getRelatedCode(), responseVO);

            }
        }
        return tMap;
    }
    
	/**
     * 方法：mapper转Map 
     * 参数：List<DictionaryDO> listD 
     * 返回：Map<String, List<DictionaryModel>>
     */
    private Map<Integer, Map<Integer,DictionaryModel>> mapperDOToMapUseCodeInteger(List<DictionaryDO> listD) {

        Map<Integer, Map<Integer,DictionaryModel>> tMap = new LinkedHashMap<>();
        // 初始化typeCode为null
        if (null != listD) {
            Map<Integer,DictionaryModel> mapVo = null;
            // 遍历查询结果
            Integer typeCode = null;
            for (DictionaryDO dictionaryDO : listD) {
                // 初始化DictionaryResponseVO，并装载数据
                DictionaryModel responseVO = new DictionaryModel();
                
                responseVO.setTypeName(dictionaryDO.getTypeName());
                responseVO.setTypeCode(dictionaryDO.getTypeCode());
                responseVO.setRelatedName(dictionaryDO.getRelatedName());
                responseVO.setRelatedCode(dictionaryDO.getRelatedCode());
                responseVO.setParamName(dictionaryDO.getParamName());
                responseVO.setParamCode(dictionaryDO.getParamCode());
                
                typeCode = dictionaryDO.getTypeCode();
                
                if (!(tMap.keySet().contains(typeCode))) {
                    mapVo = new LinkedHashMap<>();
                    tMap.put(typeCode, mapVo);
                }
                mapVo.put(dictionaryDO.getParamCode(), responseVO);

            }
        }
        return tMap;
    }
}
