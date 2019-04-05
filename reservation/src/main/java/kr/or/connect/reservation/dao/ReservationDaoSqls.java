package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	
	// 카테고리에 해당하는 삼품 수, 카테고리ID, 카테고리 이름 조회
	final static String SELECT_CATEGORIES = "SELECT COUNT(display_info.id) AS count, category.id, category.name FROM category LEFT JOIN product ON category.id=product.category_id LEFT JOIN display_info ON product.id=display_info.product_id GROUP BY product.category_id";
	final static String SELECT_PRODUCTS = "SELECT display_info.id AS display_info_id, display_info.place_name, product.content AS product_content, product.description AS product_description, product.id AS product_id, CONCAT(\"img/\",product_image.product_id,\"_\",product_image.type,\"_\",product_image.id,\".png\") AS product_image_url FROM product_image JOIN product ON product_image.product_id=product.id JOIN display_info ON product_image.product_id=display_info.product_id WHERE product.category_id=:id AND product_image.type=\"th\" LIMIT :start, 4";
	final static String SELECT_PRODUCTS_ALL = "SELECT display_info.id AS display_info_id, display_info.place_name, product.content AS product_content, product.description AS product_description, product.id AS product_id, CONCAT(\"img/\",product_image.product_id,\"_\",product_image.type,\"_\",product_image.id,\".png\") AS product_image_url FROM product_image JOIN product ON product_image.product_id=product.id JOIN display_info ON product_image.product_id=display_info.product_id WHERE product_image.type=\"th\" LIMIT :start, 4";
	final static String SELECT_COUNT = "SELECT COUNT(*) AS count FROM display_info JOIN product ON product.id=display_info.product_id WHERE product.category_id=:id";
	final static String SELECT_COUNT_ALL = "SELECT COUNT(*) AS count FROM display_info";
	final static String SELECT_PROMOTIONS = "SELECT promotion.id, promotion.product_id, CONCAT(\"img/\",product_image.product_id,\"_th_\",product_image.id,\".png\") AS product_image_url FROM promotion JOIN product_image ON product_image.product_id=promotion.product_id WHERE product_image.type=\"th\"";
}
