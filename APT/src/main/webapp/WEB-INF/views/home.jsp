<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=\, initial-scale=1.0" />
    <title></title>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <style>
      .main_banner {
        border-bottom: 1px solid #dbdbdb;
      }
      .banner_inner {
        width: 1080px;
        margin: 0 auto;
      }
      .banner_img {
        width: 100%;
      }
      .box_wrap {
        padding: 30px 0;
      }
      .box_inner {
        width: 1080px;
        margin: 0 auto;
        overflow: hidden;
      }
      .box {
        float: left;
        width: 340px;
        height: 200px;
        margin: 10px;
        border-radius: 10px;
        box-shadow: 3px 4px 10px 1px rgba(0, 0, 0, 0.05);
      }
      .box .box_header {
        background-color: #8897af;
        padding-left: 25px;
        line-height: 62px;
        font-size: 1.7em;
        letter-spacing: 0em;
        color: #fff;
        font-family: "Nanum Barun Gothic";
        font-weight: 500;
        border-radius: 10px 10px 0 0;
      }
      .box.box2 .box_header {
        background-color: #ed7c7a;
      }
      .box.box3 .box_header {
        background: #5a91e4;
      }
      .box_content {
        margin-bottom: 5px;
        padding: 25px 25px 0 45px;
        font-size: 1.3em;
        line-height: 2.1em;
        letter-spacing: -0.025em;
        text-overflow: ellipsis;
        overflow: hidden;
        white-space: nowrap;
      }
      .box_content li {
        position: relative;
      }
      .box_content a {
        color: #333;
      }
      .box_content li::after {
        content: "";
        position: absolute;
        left: -10px;
        top: 9px;
        width: 4px;
        height: 4px;
        background: #999;
        border-radius: 2px;
      }
      .sm_box {
        box-sizing: border-box;
        padding: 36px 30px 0;
        font-size: 1.5em;
        line-height: 1.6;
        font-weight: bold;
        color: #fff;
      }

      .sm_box a {
        margin-top: 25px;
        padding: 10px 17px 8px;
        border-radius: 21px;
        font-size: 0.8em;
        float: right;
        font-weight: normal;
        border: 1px solid #fff;
        color: #fff;
        font-weight: bold;
      }
      .sm_box.box6 a {
        margin-top: 48px;
      }
      .sm_box a:hover {
        background: rgba(255, 255, 255, 0.1);
      }
      .box5 {
        background: #ed7c7a;
      }
      .box6 {
        background: #5a91e4;
      }
    </style>
  </head>
  <body>
    <div class="wrap">
      <%@ include file="/resources/include/header.jsp" %>
      <div class="contents">
        <div class="main_banner">
          <div class="banner_inner">
            <img src="1.png" alt="" class="banner_img" />
          </div>
        </div>
        <div class="box_wrap">
          <div class="box_inner">
            <div class="box box1">
              <div class="box_header">공지사항</div>
              <div class="box_content">
                <ul class="">
                  <li><a href="">공지 블라블라 1...</a></li>
                  <li><a href="">공지 블라블라 2...</a></li>
                  <li><a href="">공지 블라블라 3...</a></li>
                </ul>
              </div>
            </div>
            <div class="box box2">
              <div class="box_header">안건정리</div>
              <div class="box_content">
                <ul class="">
                  <li><a href="">안건정리 안건정리 안건정리....</a></li>
                  <li><a href="">블라블라블라....</a></li>
                </ul>
              </div>
            </div>
            <div class="box box3">
              <div class="box_header">법률자문</div>
              <div class="box_content">
                <ul class="">
                  <li><a href="">블라블라블라....</a></li>
                  <li>
                    <a href="">리스트 내용 리스트 내용 리스트 내용2...</a>
                  </li>
                  <li><a href="">법률자문 법률자문 블라블라블라....</a></li>
                </ul>
              </div>
            </div>
            <div class="box box4">
              <div class="box_header">일반자료</div>
              <div class="box_content">
                <ul class="">
                  <li><a href="">일반 자료 리스트가 보이게 하자....</a></li>
                  <li><a href="">일반 자료 리스트가 보여요...</a></li>
                  <li>
                    <a href="">리스트 내용 리스트 내용 리스트 내용2...</a>
                  </li>
                </ul>
              </div>
            </div>
            <div class="box box5 sm_box">
              <p>
                원하시는 자료가 없으신가요? <br />회원가입 후 고객센터를 통해
                자료를 <br />요청해주세요.
              </p>
              <a href="" class="">자료요청 하기</a>
            </div>
            <div class="box box6 sm_box">
              <p>다양한 서비스를 사용을 위해 <br />회원가입을 해주세요.</p>
              <a href="" class="">회원가입하기</a>
            </div>
          </div>
        </div>
      </div>
        <%@ include file="/resources/include/footer.jsp" %>
    
      
    </div>
  </body>
</html>

