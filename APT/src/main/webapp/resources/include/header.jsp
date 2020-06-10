<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="header">
	<div class="header_inner">
		<h1 class="logo">
			<a href="/"><img src="/resources/img/logo.png"
				alt="APT meeting proposicion" /></a>
		</h1>
		<div class="lnb">
			<ul class="button_list">
				<c:choose>
					<c:when test="${login.userid == '' || login.userid eq null}">

						<li><a href="/member/loginForm">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/member/logout">로그아웃</a></li>

					</c:otherwise>
				</c:choose>

			</ul>

			<ul class="lnb_nav">
				<li><a href="/payFile/listPage?page=1&keyword=">안건정리</a></li>
				<li><a href="/advice/listPage?page=1">법률자문</a></li>
				<li><a href="/freeFile/listPage?page=1&keyword=">일반자료</a></li>
				<li><a href="/service/listPage?page=1">고객센터</a></li>
				<li><a href="/notice/listPage?page=1">공지사항</a></li>
			</ul>
		</div>
	</div>
</div>