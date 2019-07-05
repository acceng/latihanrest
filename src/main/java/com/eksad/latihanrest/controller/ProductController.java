package com.eksad.latihanrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.latihanrest.dao.BrandDao;
import com.eksad.latihanrest.dao.ProdukDao;
import com.eksad.latihanrest.model.Brand;
import com.eksad.latihanrest.model.Produk;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProdukDao produkDao;
	
	@Autowired
	BrandDao brandDao;
	
	@RequestMapping("getBrandById/{brandId}")
	public List<Produk> getBrandId(@PathVariable Long brandId){
		
		List<Produk> result = new ArrayList<Produk>();
		produkDao.findBrandId(brandId).forEach(result::add);
		
		return result;
	}
	
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public Produk save (@RequestBody Produk produk){
		
		Brand brand = brandDao.findById(produk.getBrandId()).orElse(null);
		
		if(brand != null) {
			produk.setBrand(brand);
			return produkDao.save(produk);
		}
		
		return produkDao.save(produk);

	}
	
}
