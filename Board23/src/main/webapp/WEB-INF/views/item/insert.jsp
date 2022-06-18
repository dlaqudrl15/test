<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
<style type="text/css">
#itemimguploadFile{
	width : 100%;
	height : 250px;
	border: 1px solid red;
}


</style>	

</head>



<body>
<h1>상품등록</h1>
<form action="" method="post">
상품 아이디 : <input id = "iId" name = "iId"><br>
상품 이름 : <input id ="iName" name = "iName"><br>
상품 가격 : <input id = "iPrice" name = "iPrice"><br>
상품 할인율 : <input id = "iDc" name = "iDc"><br>
상품 수량 : <input id = "iCount" name = "iCount"><br>
카테고리 : 
<select id = "category" onchange = "changecategory()">
<option value = "clothes">옷</option>
<option value = "shoes">신발</option>
<option value = "bag">가방</option>
<option value = "cap">모자</option>
<option value = "onepiece">원피스</option>
</select>
</form>
<input id = "input" type = "hidden" value = "clothes">
<input id = "item_btn_submit" type="submit" value = "상품 등록">

<div class ="form-group">
<div id = "itemimguploadFile" class ="form-control text-center"></div>
	</div>
<div id = "itemimguploadedItems" class ="row row-cols-3">

</div>	
<script type="text/javascript" src ="/resources/js/item.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	let formData = new FormData();
	let idx = 0;
	
	
	
	$("#itemimguploadFile").on("dragenter dragover", function(event) {
		event.preventDefault();
	});
	
	$("#itemimguploadFile").on("drop", function(event) {
		event.preventDefault();
		let itemimgfiles = event.originalEvent.dataTransfer.files;
		let itemimgfile = itemimgfiles[0];
		
		formData.append("itemimgfile"+idx,itemimgfile);
		
		let reader = new FileReader();
		
		reader.readAsDataURL(itemimgfile);
		
		reader.onload = function(event) {
			
			let str = insertitemimgfile(event.target.result, itemimgfile["name"],"itemimgfile"+idx++);
			
			$("#itemimguploadedItems").append(str);
			
		}
	
		
	});
	$("#itemimguploadedItems").on("click",".btn_del_item", function() {
		let itemimgfilekey = $(this).attr("data-itemimgfilekey");
		formData.delete(itemimgfilekey);
		$(this).parent().parent().parent().remove();
	})	
	
	$("#item_btn_submit").click(function() {
		let iId = $("#iId").val();
		let iName = $("#iName").val();
		let iPrice = $("#iPrice").val();
		let iDc = $("#iDc").val();
		let iCount = $("#iCount").val();
		let icategory = $("#input").val();
		
		formData.append("iId", iId);
		formData.append("iName", iName);
		formData.append("iPrice", iPrice);
		formData.append("iDc", iDc);
		formData.append("iCount", iCount);
		formData.append("icategory",icategory);
		$.ajax({
			
			type : "post",
			url : "/item/insert",
			data : formData,
			processData : false,
			contentType : false,
			dataType : "text",
			success : function(result) {
				if(result == "SUCCESS"){
					location.assign("/item/main");
				}
			
			}
			
		})
	})
	
	
})






</script>
</body>
</html>