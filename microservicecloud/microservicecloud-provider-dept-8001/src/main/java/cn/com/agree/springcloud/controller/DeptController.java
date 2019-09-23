package cn.com.agree.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.com.agree.springcloud.entities.Dept;
import cn.com.agree.springcloud.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	private DeptService service;
	
	@PostMapping("/dept/add")
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}
	
	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return service.get(id);
	}
	
	@GetMapping("/dept/list")
	public List<Dept> list() {
		return service.list();
	}
}
