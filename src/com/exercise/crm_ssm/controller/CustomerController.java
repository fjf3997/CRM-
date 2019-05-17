package com.exercise.crm_ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exercise.crm_ssm.pojo.BaseDict;
import com.exercise.crm_ssm.pojo.Customer;
import com.exercise.crm_ssm.pojo.QueryVo;
import com.exercise.crm_ssm.service.BaseDictService;
import com.exercise.crm_ssm.service.CustomerService;
import com.exercise.crm_ssm.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Value("${customer_from_type}")
	private String customer_from_type;
	@Value("${customer_industry_type}")
	private String customer_industry_type;
	@Value("${customer_level_type}")
	private String customer_level_type;
	@Autowired
	private BaseDictService baseDictService;
	@RequestMapping("list")
	public String queryCustomerList(Model model,QueryVo vo) {
		List<BaseDict> fromType = this.baseDictService.queryBaseDictByDictTypeCode(customer_from_type);
		List<BaseDict> industryType = this.baseDictService.queryBaseDictByDictTypeCode(customer_industry_type);
		List<BaseDict> levelType = this.baseDictService.queryBaseDictByDictTypeCode(customer_level_type);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType",industryType );
		model.addAttribute("levelType", levelType);
		Page<Customer> page = this.customerService.queryCustomerByQueryVo(vo);
		model.addAttribute("page", page);
		return "customer";
	}
	@RequestMapping("edit")
	@ResponseBody
	public Customer edit(Integer id) {
		Customer customer = this.customerService.queryCustomerById(id);
		return customer;
	}
	@RequestMapping("update")
	@ResponseBody
	public String  updatCustomerById(Customer customer) {
		String msg = "1";
		try {
			customerService.updatCustomerById(customer);
			msg="0";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return msg;
	}
	@RequestMapping("delete")
	@ResponseBody
	public String  deleteCustomerByid(Integer id) {
		String msg = "1";
		try {
			customerService.deleteCustomerByid(id);
			msg="0";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return msg;
	}
}
