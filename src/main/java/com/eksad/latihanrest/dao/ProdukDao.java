package com.eksad.latihanrest.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eksad.latihanrest.model.Produk;

public interface ProdukDao extends CrudRepository<Produk, Long>
{
	@Query("select p from Produk p where p.brand.id = :brandId ")
	public Iterable<Produk> findBrandId(@Param("brandId") Long brandId);
}
