package com.alies.service;

import java.util.List;

import com.alies.binding.Contect;
import com.alies.entity.ContectEntity;

public interface ContectService {
	
	public String saveContectInfo(Contect c);
	public Contect getonecontect(Integer id);
	public List<Contect> getallContect();
	public List<Contect> deletContect(Integer id);

}
