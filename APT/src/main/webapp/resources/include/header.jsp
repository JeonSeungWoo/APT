<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="gnb">

        <div class="gnb_inner">
          <a href="login.html">공지 사항</a>
              <c:choose>
                <c:when test="${login.userid == '' || login.userid eq null}">
                    <a href="/member/loginForm">관리사무소 Login</a>                       
                </c:when>
                 <c:otherwise>
                     <a href="/member/logout">Logout</a>
                 </c:otherwise>
              </c:choose>
         
        </div>
      </div>
      <div class="header">
        <div class="header_inner">
          <h1 class="logo">
            <a href="/"
              ><img src="/resources/img/logo.png" alt="APT meeting proposicion"
            /></a>
          </h1>
          <div class="lnb">
            <ul class="lnb_nav">
              <li><a href="/payFile/listPage?page=1">안건정리</a></li>
              <li><a href="/advice/listPage?page=1">법률자문</a></li>
              <li><a href="/freeFile/listPage?page=1">일반자료</a></li>
              <li><a href="/service/listPage?page=1">고객센터</a></li>
            </ul>
          </div>
        </div>
      </div>