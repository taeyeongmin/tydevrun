<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	
<fmt:requestEncoding value="utf-8"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="order" name="title"/>
</jsp:include>
<style>
.table td, .table th{
	border-top: 0;
}
.card-header{
	background-color: inherit;
}
.card{
	border: 0;
}
.btn-link{
	color : #000;
	font-size : x-large;
}
.delivery-option{
	border: 1px solid #1A81FF;
}
.order-form-control{
	width: 80%;
    padding: 0.375rem 0.75rem;
    font-size: 1rem;
    line-height: 1.5;
    color: #495057;
    background-color: #fff;
    background-clip: padding-box;
    border: 0;
    border-bottom: 1px solid #ced4da;
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
}
.list-group-item{
	border: 0;
}
#orderPaymentBtn{
	font-size : x-large;
}
.order-list{
	display:none;
}
.order-container{
	margin: 0 10% 0 10%;
}
</style>
<div class="row p-5 d-flex justify-content-around order-container">
  <div class="col-7">
  	<div class="accordion" id="orderAccordion">
	  <div class="card">
	    <div class="card-header" id="headingOne">
	      <h5 class="mb-0">
	        <button class="btn btn-link order-btn" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
		        <span class="badge badge-dark">1</span>
		        배송 정보
	        </button>
	      </h5>
	      <div id="orderOne" class="order-list pl-5 pr-5">
	      	<p><strong>택배 배송 : 출고 예정일 3~5일 이내에 배송되며, 2박스 이상으로 분리 배송될 수 있습니다.</strong></p>
		      	<strong>배송지 : </strong>
	      	<p>대한민국 어쩌구</p>
	      	<strong>출고 예정일 : </strong>
	      	<p>2021.12.09 09:00 - 21:00</p>
	      </div>
	    </div>
	
	    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#orderAccordion">
	      <div class="card-body pl-5">
	      	배송지 : 
	      	<div class="input-group mb-3 w-75">
			  <input type="number" class="form-control" placeholder="주소" aria-describedby="basic-addon2">
			  <div class="input-group-append w-10">
			    <span class="input-group-text " id="basic-addon2">수정</span>
			  </div>
			</div>
			<strong>배송 옵션</strong>
			<div class="delivery-option p-3">
				<i class="fas fa-truck"><strong>일반 배송</strong></i>
				<p class="pt-2 mb-0">택배 배송 : 출고 예정일 3~5일 이내에 배송되며, 2박스 이상으로 분리 배송될 수 있습니다.</p>
			</div>
		    <button 
		  	  type="button" 
		  	  id="orderNextBtn" 
		  	  class="btn btn-primary w-100 h-50 mt-2 order-btn" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
		  	  다음
		    </button>
	      </div>
	    </div>
	  </div>
	  <div class="card">
	    <div class="card-header" id="headingTwo">
	      <h5 class="mb-0">
	        <button class="btn btn-link collapsed order-btn" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
		        <span class="badge badge-dark">2</span>
		         주문을 어디로 배송할까요?
	        </button>
	      </h5>
	      <div id="orderTwo" class="order-list pl-5 pr-5">
		  	<p>이름 : 길동</p>
		   	<p>이메일 : honggd@gmail.com</p>
		   	<p>전화번호 : 01012341234</p>
		   	<p>상세주소 : 어쩌구동</p>
	      </div>
	    </div>
	    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#orderAccordion">
	      <div class="card-body">
	      	<ul class="list-group">
			  <li class="list-group-item">이름 : <input type="text" class="order-form-control" name="" id="" /></li>
			  <li class="list-group-item">이메일 : <input type="text" class="order-form-control" name="" id="" /></li>
			  <li class="list-group-item">전화번호 : <input type="text" class="order-form-control" name="" id="" /></li>
			  <li class="list-group-item">상세주소 : <input type="text" class="order-form-control" name="" id="" /></li>
			</ul>
		    <button 
		  	  type="button" 
		  	  id="orderNextBtn" 
		  	  class="btn btn-primary w-100 h-50 mt-2 order-btn" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
		  	  다음
		    </button>
	      </div>
	    </div>
	  </div>
	  <div class="card">
	    <div class="card-header" id="headingThree">
	      <h5 class="mb-0">
	        <button class="btn btn-link collapsed order-btn" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
		        <span class="badge badge-dark">3</span>
		        결제
	        </button>
	      </h5>
	    </div>
	    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#orderAccordion">
	      <div class="card-body">
	        <button 
		  	  type="button" 
		  	  id="orderPaymentBtn" 
		  	  class="btn btn-primary w-100 h-50 mt-2" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
		  	  ￦12,800원 결제하기 <i class="fas fa-chevron-circle-right"></i>
		    </button>
	      </div>
	    </div>
	  </div>
	</div>
  </div>
  <div class="col-4 m-3 pl-3 pt-5 d-flex flex-column justify-content-start">
  	<strong>주문 정보</strong>
  	<div class="row d-flex justify-content-start">
  		<img src="${pageContext.request.contextPath }/resources/images/500x500.jpg" alt="" class="img-b w-25 p-2">
  		<img src="${pageContext.request.contextPath }/resources/images/500x500.jpg" alt="" class="img-b w-25 p-2">
  	</div>
    <hr class="w-100"/>
	<table class="table">
	  <tbody>
	  	<tr>
	  		<th colspan="2">주문 내역</th>
	  	</tr>
	    <tr>
	      <td>주문 금액(배송비 제외)</td>
	      <td class="text-right">￦17,800</td>
	    </tr>
	    <tr>
	      <td>전체 배송비</td>
	      <td class="text-right">￦3,000</td>
	    </tr>
	    <tr>
	      <td>주문 금액(부가세 제외)</td>
	      <td class="text-right">￦18,909</td>
	    </tr>
	    <tr>
	      <td>부가세(10%)</td>
	      <td class="text-right">￦1,891</td>
	    </tr>
	  </tbody>
	</table>
	<hr class="w-100"/>
	<table class="table">
	  <tbody>
	    <tr>
	      <th>
			총 주문 금액
	      </th>
	      <td class="text-right">￦17,800</td>
	    </tr>
	    <tr>
	      <th class="col-4">
			보유 포인트
	      </th>
	      <td class="col-5">
	      	<input type="text" name="" id="" value="3,000" class="form-control w-100" disabled/>
		  </td>
	    </tr>
	    <tr>
	      <th>
			사용 포인트
	      </th>
	      <td class="w-50">
	      	<div class="input-group mb-3 ">
			  <input type="number" class="form-control" placeholder="사용 포인트" aria-describedby="basic-addon2">
			  <div class="input-group-append w-10">
			    <span class="input-group-text " id="basic-addon2">적용</span>
			  </div>
			</div>
	      </td>
	    </tr>
	  </tbody>
	</table>
  </div>
</div>
<script>
//버튼 클릭 시 아코디언 헤더의 상세 내용 숨기거나 드러내기
$(".order-btn").click((e)=>{
	const target = $(e.target).data("target");
	
	if(target == '#collapseThree'){
		$("#orderOne").show();
		$("#orderTwo").show();
	}
	else if(target == '#collapseOne'){
		$("#orderOne").hide();
		$("#orderTwo").show();
		
	}
	else if(target == '#collapseTwo'){
		$("#orderOne").show();
		$("#orderTwo").hide();
		
	}
		
});
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
