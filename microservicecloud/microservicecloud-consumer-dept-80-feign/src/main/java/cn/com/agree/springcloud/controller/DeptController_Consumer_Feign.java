package cn.com.agree.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.agree.springcloud.entities.Dept;
import cn.com.agree.springcloud.service.DeptClientService;

@RestController
public class DeptController_Consumer_Feign {

	@Autowired
	private DeptClientService deptClientService;
	
	
	@PostMapping("/consumer/dept/add")
	public boolean addDept(Dept dept) {
		return deptClientService.add(dept);
	}
	
	@GetMapping("/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") String id) {
		return deptClientService.get(Long.valueOf(id));
	}
	
	@GetMapping("/consumer/dept/list")
	public List<Dept> list() {
		return deptClientService.list();
	}
	
}
