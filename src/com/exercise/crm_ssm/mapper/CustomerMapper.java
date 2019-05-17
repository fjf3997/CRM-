package com.exercise.crm_ssm.mapper;

import java.util.List;

import com.exercise.crm_ssm.pojo.Customer;
import com.exercise.crm_ssm.pojo.QueryVo;

public interface CustomerMapper {
	List<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	int queryCountByQueryVo(QueryVo queryVo);
	Customer queryCustomerById(Integer id);
	void updatCustomerById(Customer customer);
	void deleteCustomerByid(Integer id);
}
