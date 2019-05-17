package com.exercise.crm_ssm.service;

import com.exercise.crm_ssm.pojo.Customer;
import com.exercise.crm_ssm.pojo.QueryVo;
import com.exercise.crm_ssm.utils.Page;

public interface CustomerService {
	Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	Customer queryCustomerById(Integer id);
	void updatCustomerById(Customer customer);
	void deleteCustomerByid(Integer id);
}
