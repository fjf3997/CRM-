package com.exercise.crm_ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.crm_ssm.mapper.BaseDictMapper;
import com.exercise.crm_ssm.pojo.BaseDict;
@Service
public class BaseDictServiceImpl implements BaseDictService{
	@Autowired
	private BaseDictMapper baseDictMapper;
	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
		
		return this.baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
	}

}
