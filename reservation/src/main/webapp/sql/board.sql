CREATE TABLE tb_member {
	seqno INT UNIQUE AUTO_INCREMENT,
	id VARCHAR(16) PRIMARY KEY,
	password VARCHAR(21),
	name VARCHAR(11)
};

INSERT INTO tb_member VALUES (null, 'user', '123', '사용자');

CREATE TABLE tb_restaurant {
	seqno INT AUTO_INCREMENT PRIMARY KEY,
	rstnt_name VARCHAR(21),
	rstnt_location VARCHAR(51),
	category CHAR(6),
	register VARCHAR(16),
	regist_date DATE DEFAULT SYSDATE,
	FOREIGN KEY (register) REFERENCES tb_member (id) ON DELETE CASCADE
};

INSERT INTO tb_restaurant VALUES (null, '식당명01', '식당위치01', '한식', 'user', null);
INSERT INTO tb_restaurant VALUES (null, '식당명02', '식당위치02', '한식', 'user', null);
INSERT INTO tb_restaurant VALUES (null, '식당명03', '식당위치03', '중식', 'user', null);
INSERT INTO tb_restaurant VALUES (null, '식당명04', '식당위치04', '양식', 'user', null);
INSERT INTO tb_restaurant VALUES (null, '식당명05', '식당위치05', '패스트푸드', 'user', null);

CREATE TABLE tb_food {
	seqno INT AUTO_INCREMENT PRIMARY KEY,
	rstnt_seqno INT,
	food_name VARCHAR(16),
	price VARCHAR(11),
	score INT(1),
	description VARCHAR(51),
	register VARCHAR(16),
	regist_date DATE DEFAULT SYSDATE,
	FOREIGN KEY (rstnt_seqno) REFERENCES tb_restaurant (seqno) ON DELETE CASCADE,
	FOREIGN KEY (register) REFERENCES tb_member (id) ON DELETE CASCADE
};

INSERT INTO tb_food VALUES (null, 1, '음식명01', '8000원', '5', '무난했다.', 'user', null);
INSERT INTO tb_food VALUES (null, 1, '음식명02', '8500원', '7', '맛있다.', 'user', null);
INSERT INTO tb_food VALUES (null, 1, '음식명03', '9000원', '10', '최고.', 'user', null);
INSERT INTO tb_food VALUES (null, 2, '음식명04', '5000원', '7', '가성비좋다.', 'user', null);
INSERT INTO tb_food VALUES (null, 3, '음식명05', '5000원', '3', '맛없다.', 'user', null);
INSERT INTO tb_food VALUES (null, 4, '음식명06', '12000원', '8', '맛있지만 비싸다.', 'user', null);
INSERT INTO tb_food VALUES (null, 5, '음식명07', '9000원', '6', '무난했다.', 'user', null);

-- ID 중복 확인
SELECT count(1)
FROM tb_member
WHERE id = #{value}

-- loginMember
SELECT	  seqno
		, id
		, password
		, name
FROM tb_member
WHERE id = #{value}

-- selectRstntList
SELECT *
FROM tb_restaurant A, tb_member B
WHERE A.register = B.id
LIMIT ${start}, ${itemNum}

-- selectFoodList
SELECT *
FROM tb_food A, tb_member B
WHERE A.register = B.id
LIMIT ${start}, ${itemNum}

-- insertMember
INSERT INTO tb_member(
	  id
	, password
	, name)
VALUES (
	  #{id}
	, #{password}
	, #{name}
);

-- deleteMember
DELETE FROM tb_member
WHERE id = #{value}

-- updateMember
UPDATE tb_member
SET name = #{name}
WHERE id = #{id}

-- insertRstnt
INSERT INTO tb_restaurant(
	  rstnt_name
	, rstnt_location,
	, category
	, register
	, regist_date)
VALUES (
	  '식당명01'
	, '식당위치01'
	, '한식'
	, 'user'
);

-- deleteRstnt
DELETE FROM tb_restaurant
WHERE seqno = #{value}

-- updateRstnt
UPDATE tb_restaurant
SET rstnt_name = #{rstntName},
	rstnt_location = #{rstntLocation},
	category = #{category},
	regist_date = SYSDATE;
WHERE seqno = #{seqno}

-- insertFood
INSERT INTO tb_food(
	  rstnt_seqno
	, food_name
	, price
	, score
	, description
	, register)
VALUES (
	  #{rstntSeqno}
	, #{foodName}
	, #{price}
	, #{score}
	, #{description}
	, #{register}
)

-- deleteFood
DELETE FROM tb_food
WHERE seqno = #{value}

-- updateFood
UPDATE tb_food
SET   food_name = #{foodName}
	, price = #{price}
	, score = #{score}
	, description = #{description}
WHERE seqno = #{seqno}