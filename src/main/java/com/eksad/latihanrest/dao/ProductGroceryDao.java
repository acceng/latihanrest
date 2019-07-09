package com.eksad.latihanrest.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eksad.latihanrest.model.ProductGroceries;

@RepositoryRestResource(path = "groceries")
public interface ProductGroceryDao extends CrudRepository<ProductGroceries, Long>{

	public List<ProductGroceries> findByBrandName(@Param("name")String name);
	
	public List<ProductGroceries> findByName(@Param("name")String name);
}
