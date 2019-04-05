package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDao reservationDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Category> getCategories() {
		return reservationDao.selectCategories();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Product> getProducts(int id, int start) {
		return reservationDao.selectProducts(id, start);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Product> getProductsAll(int start) {
		return reservationDao.selectProductsAll(start);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Promotion> getPromotions() {
		return reservationDao.selectPromotions();
	}

	@Override
	@Transactional(readOnly=true)
	public int getCount(int id) {
			return reservationDao.selectCount(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public int getCountAll() {
			return reservationDao.selectCountAll();
	}
}
