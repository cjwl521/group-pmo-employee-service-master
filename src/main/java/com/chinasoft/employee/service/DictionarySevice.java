package com.chinasoft.employee.service;

import java.util.List;
import java.util.Map;

import com.chinasoft.employee.exception.BusinessException;
import com.chinasoft.employee.service.model.DictionaryModel;

public interface DictionarySevice {
	/**
	 * description: 通过不同条件获取字典信息
	 * method: getDictionary
	 * @return Map<String, Object>
	 * @throws BusinessException 
	 */
	Map<String, Object> getDictionary(int flag,String typeName) throws BusinessException;
	/**
	 * description: 通过不同条件获取字典信息
	 * method: getDictionary
	 * @return Map<String, Object>
	 * @throws BusinessException 
	 */
	List<DictionaryModel> getDictionary(Integer typeCode) throws BusinessException;
	/**
	 * description: 通过不同条件获取字典信息
	 * method: getDictionaryMap
	 * @return Map<String, List<DictionaryModel>>
	 * @throws BusinessException 
	 */
	Map<String, List<DictionaryModel>> getDictionaryMap() throws BusinessException;
	
    Map<String, Map<Integer, DictionaryModel>> getDictionaryMapMap() throws BusinessException;
    
    public Map<Integer, Map<Integer, DictionaryModel>> getDictionaryMapMapInteger() throws BusinessException;
}
