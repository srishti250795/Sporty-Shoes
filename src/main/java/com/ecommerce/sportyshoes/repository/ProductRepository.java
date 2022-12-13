package com.ecommerce.sportyshoes.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ecommerce.sportyshoes.enums.Category;
import com.ecommerce.sportyshoes.exceptions.BusinessException;
import com.ecommerce.sportyshoes.model.Product;

@Repository
public class ProductRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class ProductRowMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product=new Product();
			product.setId(rs.getLong("id"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			product.setAvailability(rs.getInt("availability"));
			product.setPrice(rs.getLong("price"));
			product.setCategory(Category.getCategory(rs.getString("category")));
			product.setCreatedAt(rs.getDate("created_at"));
			product.setUpdatedAt(rs.getDate("updated_at"));
			
			return product;
		}
	}
	
	public List<Product> findByCategory(String category) throws BusinessException{
		try {
			return jdbcTemplate.query("select * from products where category=?", new Object[] {category},new ProductRowMapper());}
			catch (Exception exception) {
			throw new BusinessException("Internal Error Occured "+exception.getMessage());
			}
					
			}


	public Optional<Product> findById(Long id) throws BusinessException{
		try {
		return Optional.of(jdbcTemplate.queryForObject("select * from products where id=?", 
				new Object[] {id}, new BeanPropertyRowMapper<Product>(Product.class)));}
		catch (Exception exception) {
			throw new BusinessException("Internal Error Occured "+exception.getMessage());
			}
			
			}
	
	public int createProduct(Product product) throws BusinessException {
		try {

			
		return jdbcTemplate.update("insert into products( name,description, availability,price, category) values(?,?,?,?,?)", 
				new Object[] {product.getName(), product.getDescription(),product.getAvailability(),product.getPrice(),
						product.getCategory().toString()});
		}
		catch (Exception exception) {
			throw new BusinessException("Internal Error Occured "+exception.getMessage());
			}
			}

	public int deleteProduct(Long id) throws BusinessException {
		try {
			return jdbcTemplate.update("delete from products where id=?", new Object[] {id});}
			catch (Exception exception) {
				throw new BusinessException("Internal Error Occured "+exception.getMessage());
				}
			}
	
	public int updateProduct(Product product) throws BusinessException {
		try {
			return jdbcTemplate.update("update products "
					+ "set availability=ifnull(?,availability), "
					+ "price=ifnull(?,price), "
					+ " where id=?", 
					new Object[] {product.getAvailability(),product.getPrice(),product.getId()});
			}
			catch (Exception exception) {
				throw new BusinessException("Internal Error Occured "+exception.getMessage());
				}
			}
	
}
