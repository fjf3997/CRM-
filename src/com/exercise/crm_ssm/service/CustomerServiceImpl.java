package com.exercise.crm_ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.crm_ssm.mapper.CustomerMapper;
import com.exercise.crm_ssm.pojo.Customer;
import com.exercise.crm_ssm.pojo.QueryVo;
import com.exercise.crm_ssm.utils.Page;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
		queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());
		List<Customer> list = this.customerMapper.queryCustomerByQueryVo(queryVo);
		int total = this.customerMapper.queryCountByQueryVo(queryVo);
		Page<Customer> page = new Page<Customer>(total, queryVo.getPage(), queryVo.getRows(), list);
				
		return page;
	}
	public Customer queryCustomerById(Integer id) {
		
		return this.customerMapper.queryCustomerById(id);
	}
	public void updatCustomerById(Customer customer) {
		this.customerMapper.updatCustomerById(customer);
	}
	public void deleteCustomerByid(Integer id) {
		this.customerMapper.deleteCustomerByid(id);
	}

}
