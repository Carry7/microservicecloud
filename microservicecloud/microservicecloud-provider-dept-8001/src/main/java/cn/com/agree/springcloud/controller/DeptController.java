package cn.com.agree.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	
	@Autowired
	private DiscoveryClient discoveryClient;  
	
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
	
	@GetMapping("/dept/discover")
	public Object Discover() {
		List<String> listServices = discoveryClient.getServices();
		System.out.println("**********"+listServices);
		List<ServiceInstance> listInstance = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
		for(ServiceInstance serviceInstance : listInstance) {
			System.out.println("ServiceId="+serviceInstance.getServiceId());
			System.out.println("Host="+serviceInstance.getHost());
			System.out.println("Port="+serviceInstance.getPort());
			System.out.println("URI="+serviceInstance.getUri());
			System.out.println("metadata="+serviceInstance.getMetadata());
		}
		return this.discoveryClient;
	}
	
}
