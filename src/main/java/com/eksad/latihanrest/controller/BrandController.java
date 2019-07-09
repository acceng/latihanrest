package com.eksad.latihanrest.controller;

import java.lang.management.MemoryType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.latihanrest.dao.BrandDao;
import com.eksad.latihanrest.model.Brand;

@RestController
@RequestMapping("brand")
public class BrandController {
	
	@Autowired
	BrandDao brandDaoX;
	
	@RequestMapping("getAll")
	public List<Brand> getAll(){
		
		List<Brand> result = new ArrayList<>();
		
		brandDaoX.findAll().forEach(result::add);
		
		return result;
	}

	@RequestMapping("getOne/{id}")
	public Brand getOne(@PathVariable Long id) {
		
		return brandDaoX.findById(id).orElse(null);
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestBody Brand brand) {
		
		try {
			brandDaoX.save(brand);
			return "Berhasil Tersimpan";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Gagal Tersimoan";
		}
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
	public Brand update(@RequestBody Brand brand,@PathVariable Long id) {
		
		Brand brandPilih = brandDaoX.findById(id).orElse(null);
		if(brandPilih != null) {
			brandPilih.setName(brand.getName());
			brandPilih.setProductType(brand.getProductType());
		
		
			brandDaoX.save(brandPilih);
			return brandDaoX.save(brandPilih);		
	}else {
		
		return null;
	}
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public HashMap<String, Object> delete (@PathVariable Long id){
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		brandDaoX.deleteById(id);
		result.put("message", "berhasil dihapus");
		return result;
		
	}
}
