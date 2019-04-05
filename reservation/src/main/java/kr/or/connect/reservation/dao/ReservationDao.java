package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;

@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Category> rowMapperCategory = BeanPropertyRowMapper.newInstance(Category.class);
	private RowMapper<Product> rowMapperProduct = BeanPropertyRowMapper.newInstance(Product.class);
	private RowMapper<Promotion> rowMapperPromotion = BeanPropertyRowMapper.newInstance(Promotion.class);
	
	public ReservationDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Category> selectCategories(){
		return jdbc.query(SELECT_CATEGORIES, rowMapperCategory);
	}
	public List<Product> selectProducts(Integer id, Integer start){
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		params.put("start", start);
		return jdbc.query(SELECT_PRODUCTS, params, rowMapperProduct);
	}
	public List<Product> selectProductsAll(Integer start){
		Map<String, Integer> params = Collections.singletonMap("start",start);
		return jdbc.query(SELECT_PRODUCTS_ALL, params, rowMapperProduct);
	}
	public List<Promotion> selectPromotions(){
		return jdbc.query(SELECT_PROMOTIONS, rowMapperPromotion);
	}
	public int selectCount(Integer id){
		Map<String, Integer> params = Collections.singletonMap("id",id);
		return jdbc.queryForObject(SELECT_COUNT, params, Integer.class);
	}
	public int selectCountAll() {
		return jdbc.queryForObject(SELECT_COUNT_ALL,Collections.emptyMap(), Integer.class);
	}
}
