package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path="/api")
public class ReservationApiController {
	
	@Autowired
	ReservationService reservationService;
	
	// 카테고리 ID로
	// 카테고리에 해당하는 상품 수, 카테고리 ID, 카테고리 이름을 조회한다.
	@GetMapping(path="/categories")
	public Map<String, Object> categoryList(){
		List<Category> categoryList = reservationService.getCategories();
		
		Map<String, Object> map = new HashMap<>();
		map.put("categoryList", categoryList);
		
		return map;
	}
	
	// 상품 4개씩 조회하기
	@GetMapping(path="/products")
	public Map<String, Object> productList(@RequestParam(name="id", required=false, defaultValue="0")int id,
											@RequestParam(name="start", required=false, defaultValue="0")int start){
		List<Product> productList = null;
		int count = 0;
		if(id!=0) {
			productList = reservationService.getProducts(id, start);
			count = reservationService.getCount(id);
		}
		else {
			productList = reservationService.getProductsAll(start);
			count = reservationService.getCountAll();
		}	
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", count);
		map.put("productList", productList);
		
		return map;
	}
	
	// 모든 광고 조회
	@GetMapping(path="/promotions")
	public Map<String, Object> promotionList(){
		List<Promotion> promotionList = reservationService.getPromotions();
		
		Map<String, Object> map = new HashMap<>();
		map.put("promotionList", promotionList);

		return map;
	}
}
