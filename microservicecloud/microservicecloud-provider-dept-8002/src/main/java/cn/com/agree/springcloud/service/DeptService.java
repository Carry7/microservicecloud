package cn.com.agree.springcloud.service;

import java.util.List;

import cn.com.agree.springcloud.entities.Dept;

public interface DeptService {
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
