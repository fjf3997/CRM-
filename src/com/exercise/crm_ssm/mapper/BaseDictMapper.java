package com.exercise.crm_ssm.mapper;

import java.util.List;

import com.exercise.crm_ssm.pojo.BaseDict;

public interface BaseDictMapper {
	List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}
