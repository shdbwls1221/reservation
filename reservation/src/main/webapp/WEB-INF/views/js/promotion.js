/* 광고리스트 템플릿 완성시키기 */
function makePromotionList(data){
	var html = document.getElementById("promotionItem").innerHTML;
	var length = data.promotionList.length;
	var resultHTML = "";
	var promotionUL = document.querySelector("ul.visual_img");
	
	resultHTML += html.replace("{productImageUrl}", data.promotionList[0].productImageUrl)
					.replace("{leftValue}", "0px");
	
	for(var i=1; i<length; i++){
		resultHTML += html.replace("{productImageUrl}", data.promotionList[i].productImageUrl)
						.replace("{leftValue}", "414px");
	}
	promotionUL.innerHTML = resultHTML;
}

/* 광고 슬라이드 효과 */
function slidePromotion(){
	const fixedWidthValue = 414;
	var parent = document.querySelector(".container_visual .visual_img");
	var firstSlideElement = parent.firstElementChild;
	var cloneElement = firstSlideElement.cloneNode();
	
	cloneElement.style.left = fixedWidthValue+"px";
	cloneElement.innerHTML = firstSlideElement.innerHTML;
	parent.append(cloneElement);
	
	var secondSlideElement = firstSlideElement.nextElementSibling;
	
	firstSlideElement.style.left = (parseInt(firstSlideElement.style.left)-fixedWidthValue) + "px";
	secondSlideElement.style.left = (parseInt(secondSlideElement.style.left)-fixedWidthValue) + "px";
	
	setTimeout(()=>{
		firstSlideElement.remove();
		requestAnimationFrame(slidePromotion);
	}, 2000);
}
	
/* 광고 Ajax */
function promotionAjax(url){
	var oReq = new XMLHttpRequest();
	oReq.addEventListener("load", function () {
		var data = JSON.parse(oReq.responseText);
		makePromotionList(data);
		setTimeout(()=>{
		requestAnimationFrame(slidePromotion);
		},1000);
	});
	oReq.open("GET", url);
	oReq.send();
}