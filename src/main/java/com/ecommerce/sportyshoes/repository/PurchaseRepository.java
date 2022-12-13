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
import com.ecommerce.sportyshoes.model.Purchase;

@Repository
public class PurchaseRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PurchaseRowMapper implements RowMapper<Purchase> {

		@Override
		public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {
			Purchase purchase=new Purchase();
			purchase.setId(rs.getLong("id"));
			purchase.setUser_id(rs.getLong("user_id"));
			purchase.setProduct_id(rs.getLong("product_id"));
			purchase.setQuantity(rs.getInt("quantity"));
			purchase.setCategory(Category.getCategory(rs.getString("category")));
			purchase.setCreatedAt(rs.getDate("created_at"));
			purchase.setUpdatedAt(rs.getDate("updated_at"));
			
			return purchase;
		}
	}
	
	public Optional<Purchase> findById(Long id) throws BusinessException{
		try {
		return Optional.of(jdbcTemplate.queryForObject("select * from purchase_order where id=?", 
				new Object[] {id}, new BeanPropertyRowMapper<Purchase>(Purchase.class)));}
		catch (Exception exception) {
			throw new BusinessException("Internal Error Occured "+exception.getMessage());
			}
			
			}
	public List<Purchase> findByDateCategory(Purchase purchase) throws BusinessException{
		try {
			return jdbcTemplate.query("select * from purchase_order where category=? and created_at=?", new Object[] {purchase.getCategory(),
					purchase.getCreatedAt()},new PurchaseRowMapper());}
			catch (Exception exception) {
			throw new BusinessException("Internal Error Occured "+exception.getMessage());
			}
					
			}

	public int deleteSale(Long id) throws BusinessException {
		try {
			return jdbcTemplate.update("delete from purchase_order where id=?", new Object[] {id});}
			catch (Exception exception) {
				throw new BusinessException("Internal Error Occured "+exception.getMessage());
				}
			}
	
	public int createSale(Purchase purchase) throws BusinessException {
		try {

			
		return jdbcTemplate.update("insert into purchase_report( user_id,product_id, quantity, category) values(?,?,?,?)", 
				new Object[] {purchase.getUser_id(),purchase.getProduct_id(),purchase.getQuantity(),purchase.getCategory()});
		}
		catch (Exception exception) {
			throw new BusinessException("Internal Error Occured "+exception.getMessage());
			}
			}
}
