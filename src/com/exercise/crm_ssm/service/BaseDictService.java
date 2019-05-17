package com.exercise.crm_ssm.service;

import java.util.List;

import com.exercise.crm_ssm.pojo.BaseDict;

public interface BaseDictService {
	List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}
