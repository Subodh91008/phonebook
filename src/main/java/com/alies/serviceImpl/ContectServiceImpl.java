package com.alies.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;
import org.springframework.stereotype.Service;

import com.alies.binding.Contect;
import com.alies.entity.ContectEntity;
import com.alies.repository.ContectRepisotory;
import com.alies.service.ContectService;
@Service
public class ContectServiceImpl implements ContectService {
	
	@Autowired
	ContectRepisotory repo;

	@Override
	public String saveContectInfo(Contect c) {
		// TODO Auto-generated method stub
		ContectEntity e=new ContectEntity();
		BeanUtils.copyProperties(c, e);
		ContectEntity save = repo.save(e);
		return "data save with "+save.getId()+" id";
	}

	@Override
	public Contect getonecontect(Integer id) {
		  Optional<ContectEntity> findById = repo.findById(id);
		    Contect c=new Contect();
		  if(findById.isPresent()) {
			   ContectEntity e = findById.get();
			   BeanUtils.copyProperties(e, c);
			   return c;
		  }
		 return null;
		
	}

	@Override
	public List<Contect> getallContect() {
		List<ContectEntity> findAll = repo.findAll();
		List<Contect> lc=new ArrayList<>();
		for (ContectEntity e : findAll) {
			Contect c =new Contect();
			BeanUtils.copyProperties(e, c);
			lc.add(c);
    	}
		
		return lc;
	}

	@Override
	public List<Contect> deletContect(Integer id) {
		repo.deleteById(id);
		List<Contect> getallContect =this.getallContect();
		return getallContect;
	}

}
