package com.alies.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alies.binding.Contect;
import com.alies.entity.ContectEntity;
import com.alies.service.ContectService;

@CrossOrigin(value = "http://localhost:4200/")
@RestController
@RequestMapping("/contect")

public class ContectRestcontroller {
	
	@Autowired
	ContectService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveContectdetails(@RequestBody Contect c){
		String saveContectInfo = service.saveContectInfo(c);
		return ResponseEntity.ok(saveContectInfo);
	}
	
	@GetMapping("getall")
	public ResponseEntity<List<Contect>> getallContect(){
		List<Contect> getallContect = service.getallContect();
		return ResponseEntity.ok(getallContect);
	}
	@DeleteMapping("remove/{id}")
	public ResponseEntity<String> deletecontect(@PathVariable Integer id){
		service.deletContect(id);
		return ResponseEntity.ok("record deleted");
	}
	
	@GetMapping("/getone/{id}")
	public ResponseEntity<Contect> getoneContect(@PathVariable Integer id){
		Contect getonecontect = service.getonecontect(id);
		return ResponseEntity.ok(getonecontect);
	}
	@PutMapping("/modify/{id}")
	public ResponseEntity<String> modifyContect(@RequestBody Contect c, @PathVariable Integer id){
		ResponseEntity<Contect> response = this.getoneContect(id);
		Contect existing = response.getBody();
		
		existing.setId(id);
		existing.setName(c.getName());
		existing.setEmail(c.getEmail());
		existing.setPhonenumber(c.getPhonenumber());
		service.saveContectInfo(existing);
		return ResponseEntity.ok("your data updated successfully");
		
		
	}
	
}
