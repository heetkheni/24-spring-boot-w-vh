package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EProductBean;

@Repository
public class EProductDao {

	@Autowired
	JdbcTemplate stmTemplate;

	public void addProduct(EProductBean productBean) {
		stmTemplate.update("insert into eproduct(productName , category , price , qty , productImagePath) values (? ,? , ? , ? , ?)",
				productBean.getProductName(), productBean.getCategory(), productBean.getPrice(), productBean.getQty() , productBean.getProductImagePath());
	}

	public List<EProductBean> getAllProduct() {
		List<EProductBean> productList = stmTemplate.query("select * from eproduct",
				new BeanPropertyRowMapper<EProductBean>(EProductBean.class));

		return productList;
	}
	
	public void deleteProduct(Integer productId) {
		stmTemplate.update("delete from eproduct where productId = ?",productId);
	}
	
	public EProductBean getProductById(Integer productId) {
		EProductBean product =  stmTemplate.queryForObject("select * from eproduct where productId = ?", new BeanPropertyRowMapper<>(EProductBean.class) , new Object[] {productId});
		return product;
	}

}
