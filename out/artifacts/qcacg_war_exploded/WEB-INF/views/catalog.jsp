<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>轻创文学网-目录页</title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/main-B.css" />
	</head>
	<style>
	#search {
		background: url(./img/Catalog-bj.jpg) no-repeat;
		height: 374px;
		min-width: 1200px;
		width: 100%;
		margin-top: -57px;
	}
	#index {
		width: 1125px;
		background-color: #FFFFFF;
		margin:0 auto;
		margin-top: -150px;
		position: relative;
	}
	#index .index_Line{
		height: 36px;
		border-bottom: 1px solid #cdcdcd
	}
	#index .screen {
		width: 321px;
		height: 1621px;
		position: absolute;
		top: 50px;
		left: 768px;
		background-color: #fdfdfd;
		
	}
	#index .picture {
		width: 194px;
		height: 271px;
		position: absolute;
		top: 46px;
		left: 34px;
	}
	.text {
		width: 550px;
		height: 298px;;
		margin: 47px 0 0 264px;
	}
	.text h1{
		height: 60px;
	}
	.text .text_ul  {
		width: 470px;
		height: 60px;
		font-size: 15px;
		line-height: 30px;
	}
	.text .text_ul li {
		width: 145px;
		height: ;
		float: left;
	}
	.screen h2 {
		width: 300px;
		height: 19px;
		padding: 47px 0 0 20px;
	}
	.screen .author {
		width: 217px;
		height: 72px;
		margin: -80px 0 0 110px;
	}
	.screen .author li {
		width: 184px;
		padding-top: 20px;
	}
	.head {
		margin: 30px 0 0 25px;
	}
	.screen .a_author {
		text-align: center;
		width: 72px;
		height: 20px;
		font-size: 14px;
		margin: 0 0 0 30px;
		background-color: #099cef;
		border-radius: 4px;
		color: #FFFFFF;
		padding: 5px 5px ;
		
	}
	.screen .span_author {
		color: #4a8eec;
	}
	.screen h3{
		width: 285px;
		height: 19px;
		margin: 40px 0 0 39px;
	}
	.works ul{
		width: 252px;
		height: 140px;
		margin: 0 0 0 42px;
	}
	.button {
		width: 321px;
		height: 10px;
	}
	.button img{
		display: block;
		float: left;
	}
	.works ul li {
		width: 84px;
		height: 140px;
		float: right;
		margin: 14px 0px 0 0;

	}
	.works li img {
		margin: 0 0 10px 0;
		display: block;
	}
	.list {
		width: 300px;
		height: 600px;
	}
	.list_ul {
		width: 100px;
		height: 17px;
		float: right;
		margin: 0 10px 0 0;
	}
	.list_ul li {
		width: 20px;
		margin: 10px 10px 0 0;
		float: left;
		text-align: center;
		display: block;
		cursor: pointer;
		border-radius: 4px;
	}
	.list_ul li:hover {
		color: #FFFFFF;
		padding: 2px;
		background-color: #E74C3C;
	}
	.list_ul .active {
		color: #FFFFFF;
		padding: 2px;
		background-color: #E74C3C;
	}
	.ranking {
		height: 565px;
	}
	.ranking_head {
		width: 64px;
		height: 65px;
		display: block;
		margin: 46px 0 0 45px ;
	}
	.ranking ul{
		width: 200px;
		height: 71px;
		float: right;
		margin: -65px -5px 0 0;
	}
	.ranking li {
		width: 90px;
		height: 35px;
		line-height: 20px;
		float: left;
		text-align: center;
	}
	.ranking .name {
		font-size: 10px;
		font-weight: lighter;
	}
	.ranking .num {
		width: 50px;
		height: 29px;
		color: red;
		float: left;
	}
	.num img {
		margin-left: 15px;
		text-align: center;
		display: block;
	}
	.ranking .money {
		margin-top: 13px;
		margin-left: 10px;
		font-size: 25px;
		float: right;
		color: #e74c3c;
	}
	.ranking_name {
		margin: -35px 0;
		float: none;
	}
	.rank {
		width: 243px;
		height: 295px;
	}
	.rank ul {
		width: 216px;
		height: 31px;
		position: relative;
		text-align: center;	
		margin: 10px -16px 0 0;
		border-bottom: 1px dashed #999;
	}
	.rank ul li {
		width: 88px;
		height: 26px;
	}
	.rank_num {
		padding: 0 0 0 100px;
		float: none;
	}
	.rank .rank_span{
		font-size: 14px;
		text-align: center;
		padding: 0px 6px 0px 4px;
		border-radius: 4px;
		display: block;
		float: left;
		background-color: #b3b3b3;
		color:#fff;
	}
	.rank .rank_Title{
		position: absolute;
		top: 0;
		left: 35px;
	}
	#more {
		width: 321px;
		height: 22px;
		line-height: 22px;
		text-align: center;
		float: left;
		margin: -8px 0 0 0;
		color: #f56767;
		cursor: pointer;
	}
	#recommed {
		height: 440px;
		float: left;
		margin: 40px auto;
		padding: 0;
		
	}
	#recommed .many {
		float: right;
		margin: 8px 70px 0 0;
		font-weight: lighter;
		font-size: 8px;
	}
	#recommed .recommed_works {
		height: 118px;
		
	}
	#recommed .recommed_works img {
		display: block;
		margin: 34px 0 0 42px;
		
	}
	#recommed .recommed_works ul{
		width: 100px;
		height: 100px;
		margin: -80px 0 -24px 146px;
		float: left;
	}
	#recommed .recommed_works ul li {
		width: 150px;
		height: 33px;
		line-height: 17px;
	}
	#recommed .recommed_works h4 {
		float: right;
		margin: -120px 100px 0 0px;
	}
	#recommed .recommed_Title {
		width: 300px;
		height: 103px;
		padding: 35px 0 0 0;
	}
	#recommed .recommed_Title ul {
		width: 155px;
		height: 92px;
		margin: 0 0 0 43px;
	}
	#recommed .recommed_Title .Title_a {
		display: block;
		width: 158px;
		height: 30px;
		line-height: 15px;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
		color: #000000;
	}
	.recommed_works .works_span {
		display: block;
		width: 42px;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
		float: right;
		margin: 0 65px 0 0;
	}
	.screen .author label {
		display: block;
		float: left;
	} 
	.screen .author .span {
		display: block;
		float: left;
		width: 68px;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
	}
	.works .button .next {
		float: right;
		margin: 0px 37px 0px 5px ;
		cursor: pointer;
	}
	.works .button .Previous {
		float: right;
		cursor: pointer;
	}
	.num_money {
		margin-left: 20px;
	}
	.screen .works_a {
		display: block;
		width: 80px;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
		color: #000000;
	}
	.screen .rank_a {
		display: block;
		width: 170px;
		position: relative;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
		text-align: left;
		color: #000000;
	}
	.relative {
		position: relative;
	}
	.ranking .ranking_Img_line {
		position: absolute;
		height: 26px;
		width: 21px;
		top: 40px;
    	left: 40px;
	}
		#index .text_brief {
			width: 472px;
			height: 55px;
			border-bottom: 1px dashed #999;
		}	
		#index .text_brief p {
			width: 463px;
		    overflow: hidden;
		    display: -webkit-box;
		    -webkit-line-clamp: 3;
		    -webkit-box-orient: vertical;
		}
		#index .text_type {
			width: 472px;
			height: 50px;
			padding: 21px 0 0 0;
			
		}
		#index .text_type ul {
			height: 20px;
		}
		#index .text_type ul li{
			width: 60px;
			height: 20px;
			line-height: 17px;
			float: left;
		}
		#index .text_type .text_span {
			width: 40px;
			height: 20px;
			display: block;
			text-align: center;
			border-radius: 4px;
			color: #ff4242;
			border: 1px solid #ff0000;
		}
		#index .text_type .text_span:hover {
			background-color: red;
			cursor: pointer;
			color: #FFFFFF;
		}
			
		#index .text_reading {
			width: 420px;
			height: 110px;
			padding: 18px 0 0 0;
		}
		#index .text_reading ul {
			height: 40px;
		}
		#index .text_reading ul li {
			width: 125px;
			height: 37px;
			float: left;
		}
		#index .text_reading .text_Read {
			width: 97px;
			border: 1px solid #dddddd;
			border-radius: 10px;
			display:block;
			line-height: 37px;
			text-align: center;
			font-size: 18px;
			background-color: #3379da;
			color: #FFFFFF;
			
		}
		#index .text_reading span {
			width: 97px;
			height: 37px;
			border: 1px solid #dddddd;
			border-radius: 10px;
			display:block;
			font-size: 12px;
			color: #535353;
			cursor: pointer;
		}
		#index .text_reading .text_card {
			margin: 5px 0 0 8px ;
		}
		#index .text_reading .text_Collection {
			margin: 7px 0 0 8px ;
		}
		#index .text_reading p {
			margin: -25px 0px 0px 45px;
		}
		#index .text_reading num {
			margin: -25px 0 0 45px;
		}
		#index .text_Catalog {
			width: 711px;
			height: 775px;
			border: 1px solid #dddddd;
			margin: 0 0 0 30px;
			border-radius: 8px;
		}
		#index .text_Catalog ul {
			width: 169px;
			height: 30px;
			margin: 18px 0 0 37px;
		}
		#index .text_Catalog ul li{
			font-size: 15px;
			line-height: 20px;
			float: left;
		}
		#index .text_mark {
			width: 9px;
			height: 18px;
			background-color: #ea4d5c;
			border-radius: 4px;
			margin: 0 7px 0 0;
		}
		#index .text_chapter {
			width: 669px;
			height: 27px;
			margin: 0 0 0 24px;
			border-bottom: 1px solid #ececec;
		}
		#index .text_chapter ul {
			width: 600px;
			height: 29px;
		}
		#index .text_chapter ul li { 
			width: 180px;
			height: 20px;
			line-height: 5px;
			float: left;
			color: #010101;
		}
		#index .text_chapter .text_sign {
				width: 5px;
				height: 8px;
				background-color: #f79ea7;
				margin: 0 10px 0 0;
		}
		#index .text_Catalog a {
			color: #000000;
		}
		#index .text_comment {
			width: 680px;
			height: 29px;
			margin: 42px 0 0 40px;
			border-bottom: 1px solid #d7d7d7;
		}
		#index .text_comment ul {
			height: 20px;
			margin: 0 0 0 -15px;
		}
		#index .text_comment ul li {
			width: 53px;
			float: left;
		}
		#index .text_comment ul li span {
			color: #ea4d5c;
			font-size: 18px;
			line-height: 5px;
		}
		#index .text_input {
			width: 672px;
			margin: 21px 0 0 66px;
		}
		#index .text_input ul {
			width: 669px;
			height: 122px;
		}
		#index .text_input ul li {
			width: 83px;
			float: left;
			
		}
		#index .text_input ul textarea {
			width: 550px;
			height: 116px;
			margin: 6px 0 0 0;
			border-radius: 8px;
			resize:none;
		}
		#index .text_input .text_Submit {
			text-align: center;
			border-radius: 4px;
			width: 46px;
			height: 23px;
			line-height: 23px;
			float: right;
			margin: 17px 19px 0 0;
			background-color: #f4616f;
			color: #FFFFFF;
		}
		#index .text_input .text_chart {
			width: 380px;
			height:35px;
			margin: 20px 0px 0 83px;
		}
		#index .text_sort {
			width: 678px;
			height: 27px;
			border-bottom: 2px solid #d9d9d9 ;
		}
		#index .text_sort ul {
			width: 600px;
			height: 27px;
			margin: 23px 0 0 26px;
			
		}
		#index .text_sort ul li {
			width:90px;
			height: 27px;
			cursor: pointer;
			text-align: center;
			
		}
		#index .text_sort .active{
			border-bottom: 2px solid #1686ef;
			height: 27px;
		}
		#index .text_sort ul li:hover {
			color: #1686ef;
			width: 90px;
			height: 27px;
			text-align: center;
			border-bottom: 2px solid #1686ef;
		}
		#index .text_user {
		 	width: 678px;
		 	
		 }
		 #index .text_user img {
		 	margin: 18px  0 0 0;
		 }
		#index .text_user ul {
		 	width: 583px;
		 	height: 101px;
		 	float: right;
		 	margin: 20px 13px 0 0px;
		 }
		#index .text_user ul li {
			width: 578px;
			height: 37px;
		}
		#index .text_user .user_a {
			display: block;
			color: #3d9def;
			width: 80px;
			overflow: hidden;
			white-space: nowrap;
			text-overflow: ellipsis;
			float: left;
		}
		#index .text_user .user_Top {
			width: 50px;
			height: 20px;
			line-height: 20px;
			text-align: center;
			background-color: #fdc56c;
			border-radius: 4px;
			float: left;
			color: #FFFFFF;
			margin: -5px 0 0 0;
		}
		#index .text_user .user_comment {
			width: 530px;
		    overflow: hidden;
		    display: -webkit-box;
		    -webkit-line-clamp: 2;
		    -webkit-box-orient: vertical;
		}
		#index .text_Open {
			height: 51px;
			position: relative;
		}
		#index .text_Open img {
			position: absolute;
			top: 30px;
			right: 97px;
		}
		#index .text_Open text{
			width: 623px;
			float: right;
			margin: 0 -530px 0 0px;
			color: #000000;
		}
		#index .text_Stop {
			width: 633px;
			height: 25px;
			margin: 30px 0 0 20px;
		}
		#index .text_Stop ul {
			float: right;
			width: 633px;
			height: 30px;
			text-align: center;
			margin: 0 -420px 0 0;
		}
		#index .text_Stop ul li {
			width: 67px;
			height: 25px;
			color: #bebebe;
			line-height: 25px;
		}
		#index .text_Stop .Stop_Reply {
			display: block;
			width: 87px;
			height: 25px;
			margin: 0 0px 0 5px;
			line-height: 25px;
			background-color: #fafafa;
			text-align: center;
			border-radius: 5px;
			color: #222222;
			cursor: pointer;
		} 
		#index .text_Reply {
			width: 633px;
			height: 240px;
			background-color: #fafafa;
			margin: -7px 0 0 33px;
			
		}
		#index .text_Reply img {
			width: 31px;
			height: 31px;
			margin: 16px 0px 0 28px;
		}
		#index .text_Reply .Reply_ul {
			width: 450px;
			height: 20px;
			float: left;

		}
		#index .text_Reply .Reply_ul li {
			width: 60px;
			margin: 0 0 0 6px;
		}
		#index .text_Reply .Reply_ul .Reply_li {
			width: 35px;
		}
		#index .text_Reply .Reply_ul .Reply_a {
			width: 100px;
			height: 20px;
			color: #4d99e9;
		}
		#index .text_Reply .Reply_ul .Reply_span {
			display: block;
			width: 350px;
		}
		#index .text_Reply .Reply_time  {
			width: 592px;
			height: 20px;
			margin: 2px 0px 0 17px;
			text-align: center;
			border-bottom: 1px dashed #cbcbcb ;
		}
		#index .text_Reply .Reply_time li{
			width: 47px;
			font-size: 9px;
			color: #808080;
			float: right;
		}
		#index .text_Reply .Reply_See {
			width: 594px;
			height: 20px;
			float: right;
			margin: 21px 11px 0 0;
		}
		#index .text_Reply a  {
			float: left;
		}
		#index .text_Reply .Reply_See span {
			cursor: pointer;
			color: #7eb2ec;
			cursor: pointer;
		}
		#index .text_Reply  .See_li {
			width: 65px;
			height: 16px;
			line-height: 16px;
			float: right;
			text-align: center;
			font-size: 11px;
			background-color: #FFFFFF;
			margin: -20px 21px 0 0;
			border-radius: 8px;
			color: #000000;
		}
		#index .text_user .Reply_Underline {
			margin: 29px 0 0 0;
			border-bottom: 1px solid #d5d5d5;
		}
		#index .text_Respond {
		 	width: 678px;
		 }
		 #index .text_Respond .Respond_img {
		 	margin: 37px  0 0 0;
		 }
		#index .text_Respond .Respond_ul {
		 	width: 583px;
		 	height: 351px;
		 	margin: -54px 0 0 67px;
		 }
		#index .text_Respond .Respond_ul li {
			width: 578px;
			height: 37px;
		}
		#index .text_Respond .reply_a {
			display: block;
			color: #3d9def;
			width: 80px;
			overflow: hidden;
			white-space: nowrap;
			text-overflow: ellipsis;
			float: left;
		}
		#index .text_Respond .reply_comment {
			width: 530px;
			height: 43px;
		}
		#index .reply_Open {
			width: 660px;
			height: 34px;
			position: relative;
		}
		#index .reply_Open img {
			position: absolute;
			top: 0;
			right: 120px;
		}
		#index .reply_Open text{
			width: 110px;;
			margin: 0px 0px 0 546px;
			color: #000000;
		}
		#index .replyt_Stop {
			width: 633px;
			height: 25px;
		}
		#index .replyt_Stop ul {
			float: right;
			width: 633px;
			height: 30px;
			text-align: center;
			margin: 0 -420px 0 0;
		}
		#index .replyt_Stop ul li {
			width: 67px;
			height: 25px;
			color: #bebebe;
			line-height: 25px;
		}
		#index .replyt_Stop .replyt_Reply {
			display: block;
			width: 87px;
			height: 25px;
			margin: 0 0px 0 5px;
			line-height: 25px;
			background-color: #fafafa;
			text-align: center;
			border-radius: 5px;
			color: #222222;
			cursor: pointer;
		}
		#index .text_Answer  .See_li {
			width: 65px;
			height: 16px;
			line-height: 16px;
			float: right;
			text-align: center;
			font-size: 11px;
			background-color: #FFFFFF;
			margin: -20px 21px 0 0;
			border-radius: 8px;
			color: #000000;
		}
		#index .text_user .Answer_See {
			width: 594px;
			height: 20px;
			margin: 21px 11px 0 0;
			color: #6cabf0;
		}
		#index .text_user.Answer_See .Answer_one {
			color: #000000;
		}
		#index .text_user .Answer_See li {
			cursor: pointer;
			text-align: center;
			width: 50px;
		}
		#index .text_user .Answer_See li:hover {
			color: #000000;
		}
		#index .text_input .text_user .active {
			display: none;
		}
		#index .text_Answer a  {
			width: 200px;
			height: 20px;
			line-height: 20px;
		}
		#index .text_Answer  .say_li {
			width: 65px;
			height: 16px;
			line-height: 16px;
			float: right;
			text-align: center;
			font-size: 11px;
			background-color: #FFFFFF;
			margin: -20px 21px 0 0;
			border-radius: 8px;
			color: #000000;
		}
		#index .text_input .input_a {
			color: #808080;
		}
		.btn {
			
		}
		.btn:hover {

		}
		.btn:focus {
			
		}
		.btn:active {
			box-shadow: inset 3px 3px 5px 1px rgba(0,0,0,0.7);
		}
		</style>
	<body>

	<%@ include file="public-header.jsp" %>
		<div id="search"></div>
		<div id="index">
			<div class="index_Line"></div>
			<img class="picture" src="${pageContext.servletContext.contextPath }/img/sss2.jpg"/>
			<div class="text">
			
				<h1>夏日大作战</h1>
				<ul class="text_ul">
					<li>字数: <span style="color:#7e7e7e">70万</span></li>
					<li>点击: <span style="color:#7e7e7e">756445</span></li>
					<li>更新: <span style="color:#7e7e7e">2016-8-16</span></li>
				</ul>
				<div class="text_brief">
						<p title="一名胆小的高二数学天才小矶健二在学一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一 同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一连串
						一名胆小的高二数学天才小矶健二在学一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一 同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一
						一名胆小的高二数学天才小矶健二">简介：一名胆小的高二数学天才小矶健二在学一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一 同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一连串
						一名胆小的高二数学天才小矶健二在学一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一 同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一
						一名胆小的高二数学天才小矶健二在学一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一 同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一
						</p>
					<div class="text_type">
						<ul>
							<li>分类：</li>
							<li><span class="text_span">恋爱</span></li>
							<li><span class="text_span">科幻</span></li>
							<li><span class="text_span">冒险</span></li>
						</ul>
					</div>
					<div class="text_reading">
						<ul>
							<li><a class="text_Read btn" href="javascript:;">开始阅读</a></li>
							<li><span><img src="${pageContext.servletContext.contextPath }/img/sss4.png"/ class="text_Collection"><p>收藏作品</p><num>5048</num></li>
							<li><span><img src="${pageContext.servletContext.contextPath }/img/sss3.png"/ class="text_card"><p>好人卡</p><num>1584</num></li>
						</ul>
					</div>
				</div>
			</div>
				<div class="text_Catalog">
					<ul>
						<li class="text_mark"></li>
						<li><b>公告栏</b></li>
					</ul>
					<div class="text_chapter">
						<ul>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
						</ul>
					</div>
						<ul>
							<li class="text_mark"></li>
							<li><b>公告栏</b></li>
						</ul>
					<div class="text_chapter">
						<ul>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
						</ul>
					</div>
					<div class="text_chapter">
						<ul>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
						</ul>
					</div>
					<div class="text_chapter">
						<ul>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
						</ul>
					</div>
					<div class="text_chapter">
						<ul>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
						</ul>
					</div>
					<div class="text_chapter">
						<ul>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
						</ul>
					</div>
					<div class="text_chapter">
						<ul>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
						</ul>
					</div>
					<div class="text_chapter">
						<ul>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
						</ul>
					</div>
					<div class="text_chapter">
						<ul>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
						</ul>
					</div>
					<div class="text_chapter">
						<ul>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
						</ul>
					</div>
					<div class="text_chapter">
						<ul>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
						</ul>
					</div>
					<div class="text_chapter">
						<ul>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
						</ul>
					</div>
					<div class="text_chapter">
						<ul>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
						</ul>
					</div>
					<div class="text_chapter">
						<ul>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
							<li class="text_sign"></li>
							<li><a href="javascript:;">宝宝生病了，请假一年</a></li>
						</ul>
					</div>
					</div>
				<div class="text_comment">
						<ul>
							<li><span>1982</span></li>
							<li>评论</li>
						</ul>
					</div>
				<div class="text_input">
					<ul>
						<li><a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss8.jpg"/></a></li>
						<li><textarea></textarea></li>
					</ul>
					<a class="text_Submit" href="javascript:;">评论</a>
					<div class="text_chart">
						<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss6.jpg" style="padding: 0 12px 0 0;"/></a>
						<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss5.jpg" /></a>
					</div>	
					<div class="text_sort active">
						<ul>
							<li class="active">默认排序</li>
							<li>按回复数量</li>
							<li>按赞同数</li>
						</ul>
					</div>
					<div class="text_user">
						<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss8.jpg"/ ></a>
						<ul>
							<li>
								<a href="javascript:;" class="user_a" title="我是我是我我是我是我我是我是我我是我是我我是我是我我是我是我我是">huhuhf5</a>
								<a href="javascript:;" class="user_Top">置顶</a></li>
							<li><span class="user_comment" title="我是比企······我是比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比%#￥%#~~~~~~~~~~~·······我是比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡">
									我是比企······我是比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比%#￥%#~~~~~~~~~~~·······我是比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比%#￥%#~幡····················！@#￥！@￥@#比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡
								</span>
							</li>	
						</ul>
					<div class="text_Open">
							<a href="javascript:;" ><img src="${pageContext.servletContext.contextPath }/img/sss23.png"/></a>
							<a href="javascript:;" ><text>展开全文</text></a>
					</div>
					<div class="text_Stop">
						<ul>
							<li>8月16日</li>
							<li>15：46</li>
							<li class="Stop_Reply">收起回复</li>
						</ul>
					</div>
					<div class="text_Reply">
						<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss24.png"/></a>
						<ul class="Reply_ul">
							<li><a href="javascript:;" class="Reply_a">huhuf6:</a></li>
							<li><span class="Reply_span" title="是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我">是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我</span></li>
						</ul>
						<ul class="Reply_time">
							<li><a href="javascript:;" class="input_a">回复</a></li>
							<li>15：46</li>
							<li>8月16日</li>
						</ul>
						<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss24.png"/></a>
						<ul class="Reply_ul">
							<li><a href="javascript:;" class="Reply_a">huhuf6:</a></li>
							<li class="Reply_li">回复</li>
							<li><a href="javascript:;" class="Reply_a">huhuf6:</a></li>
							<li><span class="Reply_span" title="是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我">是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我</span></li>
						</ul>
						<ul class="Reply_time">
							<li><a href="javascript:;" class="input_a">回复</a></li>
							<li>15：46</li>
							<li>8月16日</li>
						</ul>
						<ul class="Answer_See">
							<li class="Answer_one">1</li>
							<li>2</li>
							<li>3</li>
							<li>4</li>
							<li>5</li>
							<li>下一页</li>
							<li>尾页</li>
						</ul>
							<a  class="Reply_See">还有28条回复，<span>点击查看</span></a>
							<a  href="javascript:;" class="See_li">我也说一句</a>
					</div>
					<div class="Reply_Underline"></div>
				</div>
				<div class="text_user active">
						<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss8.jpg"/ ></a>
						<ul>
							<li>
								<a href="javascript:;" class="user_a" title="我是我是我我是我是我我是我是我我是我是我我是我是我我是我是我我是">huhuhf5</a>
							<li><span class="user_comment" title="我是比企······我是比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比%#￥%#~~~~~~~~~~~·······我是比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡">
									我是比企······我是比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比%#￥%#~~~~~~~~~~~·······我是比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比%#￥%#~幡····················！@#￥！@￥@#比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡比企谷八幡
								</span>
							</li>	
						</ul>
					<div class="text_Open">
							<a href="javascript:;" ><img src="${pageContext.servletContext.contextPath }/img/sss23.png"/></a>
							<a href="javascript:;" ><text>收起全文</text></a>
					</div>
					<div class="text_Stop">
						<ul>
							<li>8月16日</li>
							<li>15：46</li>
							<li class="Stop_Reply">收起回复</li>
						</ul>
					</div>
					<div class="text_Reply">
						<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss24.png"/></a>
						<ul class="Reply_ul">
							<li><a href="javascript:;" class="Reply_a">huhuf6:</a></li>
							<li><span class="Reply_span" title="是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我">是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我</span></li>
						</ul>
						<ul class="Reply_time">
							<li><a href="javascript:;" class="input_a">回复</a></li>
							<li>15：46</li>
							<li>8月16日</li>
						</ul>
						<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss24.png"/></a>
						<ul class="Reply_ul">
							<li><a href="javascript:;" class="Reply_a">huhuf6:</a></li>
							<li class="Reply_li">回复</li>
							<li><a href="javascript:;" class="Reply_a">huhuf6:</a></li>
							<li><span class="Reply_span" title="是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我">是我是我我是我是是我我是我是是我我是我是是我我是我是是我我是我是我我是我</span></li>
						</ul>
						<ul class="Reply_time">
							<li><a href="javascript:;" class="input_a">回复</a></li>
							<li>15：46</li>
							<li>8月16日</li>
						</ul>
						<ul class="Answer_See">
							<li class="Answer_one">1</li>
							<li>2</li>
							<li>3</li>
							<li>4</li>
							<li>5</li>
							<li>下一页</li>
							<li>尾页</li>
						</ul>
							<a  href="javascript:;" class="See_li">我也说一句</a>
					</div>
					<div class="Reply_Underline"></div>
				</div>
				
					
			</div>
			
			
			<div class="screen">
				<h2>作者相关</h2>
				<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss10.png"/ class="head"></a>
				<ul class="author">
					<li><label>作者：</label>
						<a href="javascript:;" class="span span_author" title="我是我是我我是我是我我是我是我我是我是我我是我是我我是我是我我是">我是我是我我是我是我我是我是我我是我是我我是我是我我是我是我我是</a>
						<a class="a_author" href="javascript:;">关注</a>
					</li>
					<li><label>签名：</label><span class="span" title="我是我是我我是我是我我是我是我我是我是我我是我是我我是我是我我是">巴拉拉小魔仙~~巴拉拉小魔仙~~巴拉拉小魔仙~~巴拉拉小魔仙~~巴拉拉小魔仙~~</span></li>
				</ul>
				<style>
					
				</style>
				<div class="works">
					<h3>其他作品</h3>
					<div class="button">
						<button class="next"><img src="${pageContext.servletContext.contextPath }/img/sss12.png"/></button>
						<button class="Previous"><img src="${pageContext.servletContext.contextPath }/img/sss13.png"/></button>
					</div>
					<ul>
						<li>
							<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss11.png"/></a>
							<a class="works_a" href="javascript:;" class="span span_author" title="我是我是我我是我是我我是我是我我是我是我我是我是我我是我是我我是">夏日小作战</a>
						</li>
						<li><a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss11.png"/></a>
							<a class="works_a" href="javascript:;" title="夏日小作战夏日小作战夏日小作战">夏日小作战夏日小作战</a>
						</li>
						<li>
							<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss11.png"/></a>
						<a class="works_a" href="javascript:;" title="夏日小作战夏日小作战夏日小作战">夏日小作战</a>
						</li>
					</ul>
				</div>
				<div class="list">
					<h2>好人榜</h2>
					<ul class="list_ul">
						<li>周</li>
						<li>月</li>
						<li class="active">总</li>
					</ul>
					<div class="ranking">
						<div class="relative">
							<img src="${pageContext.servletContext.contextPath }/img/sss19.png" class="ranking_Img_line"/>
							<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss22.png" class="ranking_head"/></a>
							<ul>
								<li><a class="works_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡"><b>比企谷八幡比企谷八幡</b></a></li>
								<li class="name"><a class="works_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡">比企谷八幡</a></li>
								<li class="num"><img src="${pageContext.servletContext.contextPath }/img/sss15.png"/>好人币</li>
								<li class="num_money"><span class="money">42357</span></li>
							</ul>
						</div>
						<div class="ranking_name relative">
							<img src="${pageContext.servletContext.contextPath }/img/sss20.png" class="ranking_Img_line"/>
							<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss10.png" class="ranking_head"/></a>
							<ul>
								<li><a class="works_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡"><b>比企谷八幡</b></a></li>
								<li class="name"><a class="works_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡">比企谷八幡</a></li>
								<li class="num" style="color: #3781E7;"><img src="${pageContext.servletContext.contextPath }/img/sss16.png"/>好人币</li>
								<li class="num_money"><span class="money" style="color: #3781E7;">42357</span></li>
							</ul>
						</div>
						<div class="ranking_name relative">
							<img src="${pageContext.servletContext.contextPath }/img/sss21.png" class="ranking_Img_line"/>
							<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/sss14.png" class="ranking_head"/></a>
							<ul>
								<li><a class="works_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡"><b>比企谷八幡</b></a></li>
								<li class="name"><a class="works_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡">比企谷八幡</a></li>
								<li class="num"style="color: #08a690;"><img src="${pageContext.servletContext.contextPath }/img/sss17.png"/>好人币</li>
								<li class="num_money"><span class="money" style="color:#08a690;">42357</span></li>
							</ul>
						</div>
						<div class="rank">
							<ul >
								<li><a class="rank_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡"><span class="rank_span">4</span><span class="rank_Title">封弊者</span></a></li>
								<li class="rank_num">340</li>
							</ul>
							<ul >
								<li><a class="rank_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡"><span class="rank_span">5</span><span class="rank_Title">凤凰园凶真</span></a></li>
								<li class="rank_num">22</li>
							</ul>
							<ul >
								<li><a class="rank_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡"><span class="rank_span">6</span><span class="rank_Title">封弊者</span></a></li>
								<li class="rank_num">12</li>
							</ul>
							<ul >
								<li><a class="rank_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡"><span class="rank_span">7</span><span class="rank_Title">凤凰园凶真</span></a></li>
								<li class="rank_num">2</li>
							</ul>
							<ul >
								<li><a class="rank_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡"><span class="rank_span">8</span><span class="rank_Title">凤凰园凶真</span></a></li>
								<li class="rank_num">2</li>
							</ul>
							<ul >
								<li><a class="rank_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡"><span class="rank_span">9</span><span class="rank_Title">凤凰园凶真</span></a></li>
								<li class="rank_num">2</li>
							</ul>
							<ul >
								<li><a class="rank_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡"><span class="rank_span">10</span><span class="rank_Title">凤凰园凶真</span></a></li>
								<li class="rank_num">2</li>
							</ul>
							<ul >
								<li><a class="rank_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡"><span class="rank_span">11</span><span class="rank_Title">凤凰园凶真</span></a></li>
								<li class="rank_num">2</li>
							</ul>
						</div>
					</div>
					<div id="more"><a>查看更多</a></div>
				</div>
				<div id="recommed">
					<h2>同类作品推荐</h2>
					<ul class="many">
						<li><a  href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡" style="color: #000000;">更多</a></li>
					</ul>
					<div class="recommed_works">
						<div>
							<a href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡"><img src="${pageContext.servletContext.contextPath }/img/sss18.png"/></a>
							<h4>夏日小作战</h4>
							<ul>
								<li>字数：<span style="color:#7e7e7e">50万</span></li>
								<li>人气：<span style="color:#7e7e7e">155443</span></li>
								<li>作者：<span style="color:#7e7e7e" class="works_span" title="比企谷八幡比企谷八幡比企谷八幡">huhuf8</span></li>
							</ul>
						</div>
					</div>
					<div class="recommed_works">
						<div>
							<a href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡"><img src="${pageContext.servletContext.contextPath }/img/sss18.png"/></a>
							<h4>夏日小作战</h4>
							<ul>
								<li>字数：<span style="color:#7e7e7e">50万</span></li>
								<li>人气：<span style="color:#7e7e7e">155443</span></li>
								<li>作者：<span style="color:#7e7e7e" class="works_span" title="比企谷八幡比企谷八幡比企谷八幡">huhuf8</span></li>
							</ul>
						</div>
					</div>
					<div class="recommed_Title">
						<ul>
							<li><a class="Title_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡">幻城之巴拉啦老魔仙</a></li>
							<li><a class="Title_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡">巴拉拉小魔仙奇遇记</a></li>
							<li><a class="Title_a" href="javascript:;" title="比企谷八幡比企谷八幡比企谷八幡">舞法舞天巴拉拉小魔仙</a></li>
						</ul>
					</div>
					</div>
				</div>
		</div>

	<%@ include file="public-footer.jsp" %>
	</body>
</html>
