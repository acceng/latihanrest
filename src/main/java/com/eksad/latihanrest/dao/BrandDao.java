package com.eksad.latihanrest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eksad.latihanrest.model.Brand;

public interface BrandDao extends CrudRepository<Brand, Long>
{
	public List<Brand> findByName(String name);
	public List<Brand> findByProductType(String type);
	
	// mencari data menggunakan query 
	@Query("select b from Brand b where name = :search") //query disini sama seperti di database tetapi kolomnya sams seperti nama di java
	public List<Brand> findBySearch(@Param("search")String search);
	
}
