<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="공지사항 상세" name="title"/>
</jsp:include>

<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/customerCenter/customerCenter.css" />

<div class="container customer-center">
	<div class="row">
		<!-- 사이드 바 -->
		<jsp:include page="/WEB-INF/views/customerCenter/sidebar.jsp"></jsp:include>
		
		<!-- 본문 -->
		<div class="col-sm-9 page notice-detail">
		
			<h2>공지사항</h2>
			
			<div class="notice-header">
				<h3 class="notice-title">데브런 점검 안내</h3>
				<div class="notice-info">
					<p>관리자 | 2018-04-10 | 조회수 : 1385</p>
				</div>
			</div>
			
			<div class="notice-content">
				<p>
				내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.<br>
				내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.<br>
				내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.<br>
				내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.<br>
				내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.<br>
				내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.<br>
				내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.<br>
				내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.<br>
				내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.<br>
				내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.<br>
				내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.<br>
				내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.<br>
				</p>
			</div>
			
			<div class="text-center mt-3">
				<a class="notice-list d-inline-block" href="">목록</a>
			</div>
			

		</div>
		<!-- 본문 끝 -->
	</div>

</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>