/* 상품리스트 템플릿 완성 시키기 */
function makeProductList(data, isMore) {
	var html = document.getElementById("itemList").innerHTML;
	var event_box = document.querySelectorAll(".lst_event_box");	// 상품이 올라갈 <ul>. 0:왼쪽, 1:오른쪽
	var resultHTML = "";	// 왼쪽
	var resultHTML2 = "";	// 오른쪽
	var length = data.productList.length;	// 받아 온 상품 수(4)
	var count = data.totalCount;	// 해당 카테고리에 존재하는 전체 상품 수
	
	for (var i = 0; i < length; i++) {
		var temp = html.replace("{id}", data.productList[i].displayInfoId)
						.replace("{productDescription}", data.productList[i].productDescription)
						.replace("{productImageUrl}", data.productList[i].productImageUrl)
			        	.replace("{productDescription}", data.productList[i].productDescription)
			        	.replace("{placeName}", data.productList[i].placeName)
			        	.replace("{productContent}", data.productList[i].productContent);
		
		if(i%2===0)
			resultHTML += temp;
		else
			resultHTML2 += temp;
	}
	
	// 상품 수 갱신(분홍 글씨)
	document.querySelector("span.pink").innerText = count;
	// 탭 메뉴 이벤트일 경우 : 내용 바꾸기
	if(!isMore){
		event_box[0].innerHTML = resultHTML;
		event_box[1].innerHTML = resultHTML2;
	}
	// 더보기 이벤트일 경우 : 내용 추가
	else{
		event_box[0].innerHTML += resultHTML;
		event_box[1].innerHTML += resultHTML2;
	}
}

/* 상품 Ajax, 더보기 칸 처리 */
// isMore:더보기이벤트 여부. (true:더보기 이벤트, false:탭메뉴 이벤트)
// start:상품 4개씩 받아올 때 시작 인덱스.
function productAjax(url, isMore, start) {
	var oReq = new XMLHttpRequest();
	oReq.addEventListener("load", function () {
		var data = JSON.parse(oReq.responseText);
		var more = document.querySelector(".more .btn");
		
		makeProductList(data, isMore);
		
		// 더보기 이벤트 + 더 이상 받아올 상품이 없다 -> 더보기 칸을 지운다.
		if(isMore && (start+4)>=data.totalCount)
			more.classList.toggle("invisible");
		// 더보기 이벤트 + 상품이 있을 때
		else if(more.className==="btn invisible")
			more.classList.toggle("invisible");
	});
	oReq.open("GET", url);
	oReq.send();
}

/* 더보기 버튼 클릭 이벤트 */
document.querySelector(".more .btn").addEventListener("click", function (evt){
	var target = evt.target;
	var start = document.querySelectorAll(".lst_event_box .item").length;
	var categoryId = 0;
	
	switch(target.tagName){
	case "BUTTON":
		categoryId = target.dataset.category;
		break;
		
	case "SPAN":
		categoryId = target.parentElement.dataset.category;
		break;		
	}
	productAjax("./api/products?id=" + categoryId + "&start=" + start, true, start);
});

/* 탭 메뉴 클릭 이벤트 */
document.querySelector(".event_tab_lst").addEventListener("click", function (evt) {
	var target = evt.target;
	var currentTarget = evt.currentTarget;
	var categoryId = 0;
	var moreBtn = document.querySelector(".more .btn");
	var start = document.querySelectorAll(".lst_event_box .item").length;
	
	if(target.tagName!=="UL"){
		for(var i=0; i<currentTarget.children.length; i++){
			if(currentTarget.children[i].firstElementChild.className==="anchor active"){
				currentTarget.children[i].firstElementChild.classList.toggle("active");
				break;
			}
		}
	}
	
	switch (target.tagName){
		case "LI":
			categoryId = target.dataset.category;
			moreBtn.dataset.category = categoryId;
			target.firstElementChild.classList.toggle("active");
			break;
		case "A":
			categoryId = target.parentElement.dataset.category;
			moreBtn.dataset.category = categoryId;
			target.classList.toggle("active");
			break;
		case "SPAN":
			categoryId = target.parentElement.parentElement.dataset.category;
			moreBtn.dataset.category = categoryId;
			target.parentElement.classList.toggle("active");
			break;
	}
	if(target.tagName!=="UL")
		productAjax("./api/products?id=" + categoryId, false, start);
});