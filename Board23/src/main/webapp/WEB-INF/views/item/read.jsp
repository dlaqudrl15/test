<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 자세히 보기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
<style type="text/css">
#formFileMultiple{
   padding-left: 0%;
}
</style>
</head>
<body>
<div class="jumbotron">
   <h1 class="text-center">상품 상세 보기</h1>
</div>

  <div class="form-group row">
    <label for="bno" class="col-sm-2 col-form-label col-form-label-lg">상품아이디</label>
    <div class="col-sm-10">
      <input readonly class="form-control form-control-lg"  id="" value="${item.iId}">
    </div>
  </div>
  
  
  <div class="form-group row">
    <label for="title" class="col-sm-2 col-form-label col-form-label-lg">상품명</label>
    <div class="col-sm-10">
      <input readonly class="form-control form-control-lg"  id="" value="${item.iName}">
    </div>
  </div>

<div class="form-group row">
    <label for="title" class="col-sm-2 col-form-label col-form-label-lg">가격</label>
    <div class="col-sm-10">
      <input readonly class="form-control form-control-lg"  id="" value="${item.iPrice}">
    </div>
  </div>
<br>
<br>

<a class="btn btn-success reply">리뷰</a>

<div class="collapse">
  <div class="card card-body">
   
     
 <div class="form-group row">
  <label for="rtitle" class="form-label">제 목</label>
  <input type="text" class="form-control" id="rtitle" placeholder="제목을 입력해 주세요.">
</div>

<div class="form-group row">
  <label for="rcontent" class="form-label">상품평</label>
  <textarea class="form-control" id="rcontent" placeholder="내용을 입력해 주세요." rows="10"></textarea>
</div>
<div class="form-group row">
   <label for="formFileMultiple" class="form-label">사진첨부</label>
  <input class="form-control" type="file" id="formFileMultiple" multiple>
</div>

     
     <div class="form-group row">
       <input id="reply_btn_submit" class="form-control btn btn-primary col-sm-2 offset-sm-5" type="submit" value="리뷰 작성 완료">   
    </div>    
  </div>
</div>


<div id="review">
</div>


<script type="text/javascript" src="/resources/js/tl.js"></script>

<script type="text/javascript">
$(function() {
$("#reply_btn_submit").on("click", function() {
	
	let Iid = ${item.iId};
    
    let rtitle = $("#rtitle").val();
    let rcontent = $("#rcontent").val();

    $.ajax({
       type : 'post',
       url : '/replies',
       headers : {
          "Content-Type" : "application/json",
          "X-HTTP-Method-Override" : "POST"
       },
       data : JSON.stringify({
          rtitle : rtitle,
          rcontent : rcontent,
          Iid : Iid
      
       }),
       dataType : 'text',
       success : function(result) {
          if(result =='SUCCESS') {
             getAllReply(bno, $("#review"));
              $("#rtitle").val("");
              $("#rcontent").val("");
          }else {
             alert("입력 실패했습니다.");
          }
         
       }
       
    });
    
    
 });
 


 
$(".reply").on("click", function() {
         $(".collapse").collapse("toggle");
      });

   });


</script>
</body>
</html>