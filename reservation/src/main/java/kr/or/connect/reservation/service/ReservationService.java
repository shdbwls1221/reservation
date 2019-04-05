package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;

public interface ReservationService {
	public List<Category> getCategories();
	public List<Product> getProducts(int id, int start);
	public List<Product> getProductsAll(int start);
	public List<Promotion> getPromotions();
	public int getCount(int id);
	public int getCountAll();
}
