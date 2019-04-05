/* 카테고리 리스트 템플릿 완성시키기 */
function makeCategoryList(data){
	var html = document.getElementById("categoryList").innerHTML;
	var resultHTML = "";
	var length = data.categoryList.length;
	for(var i=0; i<length; i++){
		resultHTML += html.replace("{id}", data.categoryList[i].id)
						.replace("{name}", data.categoryList[i].name);
	}
	document.querySelector(".event_tab_lst").innerHTML += resultHTML;
}

/* 카테고리 Ajax */
function categoryAjax(url){
	var oReq = new XMLHttpRequest();
	oReq.addEventListener("load", function () {
		var data = JSON.parse(oReq.responseText);
		makeCategoryList(data);
	});
	oReq.open("GET", url);
	oReq.send();
}