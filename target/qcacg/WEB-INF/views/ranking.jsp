<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>轻创文学网-目录页</title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/main-B.css" />
	</head>
	<style>
	#background {
		background: url(img/Catalog-bj2.jpg) no-repeat;
		height: 202px;
		min-width: 1200px;
		width: 100%;
		margin-top: -57px;
	}
	#Title {
		width: 100%;
		min-width: 1200px;
		height: 86px;
		
	}
	#Title ul {
		width: 535px;
		height: 86px;
		margin: 0 auto;
		
	}
	#Title ul li {
		width: 92px;
		height: 86px;
		font-size: 18px;
		padding: 40px 0 0 0;
		margin: 0 43px;
		float: left;
		text-align: center;
		font-weight:bold;
	}
	#Title ul li:hover {
		color: #2d72e6;
		border-bottom: 2px solid #2d72e6;
	}
	#Title .Title_a {
		color: #000000;
	}
	#content {
		width: 1120px;
		margin: 0 auto;
		position: relative;
	}
	#content .content_Label {
		width: 1118px;
		height: 54px;
		background-color: #edf2f9;
		margin: 0 auto;
	}
	#content .content_Label ul {
		width: 1152px;
		height: 24px;
		margin: 0 auto;
	}
	#content .content_Label ul li {
		width: 44px;
		height: 24px;
		margin: 21px 3px 0 3px;
		float: left;
		text-align: center;
	}
	#content .content_Label .active{
		color: #2d72e6;
	}
	#content .content_Label ul li:hover{
		cursor: pointer;
		color: #2d72e6;
	}
	#content .content_Draft:hover .content_li{
		display: block;
		cursor: pointer;
	}
	#content .content_Draft {
		width: 88px;
		height: 21px;
		float: left;
		position: absolute;
		top: 0;
		right: 120px;
		border-radius: 4px;
		padding: 19px 0 0 0;
	}
	#content .content_Draft ul {
		background-color: #FFFFFF;
		border-radius: 4px;
		position: relative;
	}
	#content .content_Draft ul img {
		position: absolute;
		top: 7px;
		left: 69px;
	}
	#content .content_Draft ul li{
		height: 21px;
		border-radius: 4px;
		border: 1px solid #e3e6ea;
		padding: 3px 0 0 3px;
		color:#676767;
	}
	#content .content_Draft ul .content_li{
		display: none;
		height: 25px;
		padding: 6px 0 0 3px;
	}
	
	#content .content_List {
		width: 88px;
		height: 21px;
		float: left;
		position: absolute;
		top: 0;
		right: 20px;
		border-radius: 4px;
		padding: 19px 0 0 0;
	}
	#content .content_List ul {
		background-color: #FFFFFF;
		border-radius: 4px;
		position: relative;
	}
	#content .content_List ul img {
		position: absolute;
		top: 7px;
		left: 69px;
	}
	#content .content_List ul li{
		height: 21px;
		border-radius: 4px;
		border: 1px solid #e3e6ea;
		padding: 3px 0 0 3px;
		color:#676767;
	}
	#content .content_List:hover .List_li{
		display: block;
		cursor: pointer;
	}
	#content .content_List .List_li{
		display: none;
	}
	
	#content .content_Collection  {
		display: block;
		width: 85px;
		height: 30px;
		line-height: 30px;
		float: right;
		margin: 89px 63px 0 0;
		border: 1px solid #e6e6e6;
		color: #bebebe;
		text-align: center;
	}
	#content .content_ranking.active .ranking_Collection{
		color: #E3E6EA !important;
		background-color: #FFFFFF !important;
		border: 1px solid #E3E6EA !important;
	}
	#content .content_ranking:hover {
		box-shadow:  1px 6px 20px 1px #cfcece;
		
	}
	#content .content_ranking {
		width: 1104px;
		height: 160px;
		margin: 10px 0 0 0px ;
		border-bottom: 1px solid #dcdcdc;
	}
	#content .content_ranking h1 {
		width: 70px;
		font-size: 30px;
		color: #c7c7c7;
		text-align: center;
		margin: 92px 0 0 0;
		float: left;
	}
	#content .content_ranking img {
		display: block;
		padding: 38px 28px 0 0px;
		float: left;
	}
	#content .content_ranking ul {
		width: 550px;
		height: 111px;
		float: left;
		margin: 59px 0 0 0px;
		
	}
	#content .content_ranking ul li {
		width: 160px;
		height: 50px;
		float: left;
	}
	#content .content_ranking ul span{
		font-size: 20px;
	}
	#content .ranking_Collection  {
		display: block;
		width: 85px;
		height: 30px;
		line-height: 30px;
		float: right;
		margin: 89px 63px 0 0;
		background-color: #1d67e4;
		color: #FFFFFF;
		text-align: center;
	}
	#content .content_a {
		display: block;
		color: #000000;
		width: 135px;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
	}
	</style>
	<body>
	<%@ include file="public-header.jsp" %>
	  <div id="background"></div>
	  <div id="Title">
	  	<ul>
	  		<li><a class="Title_a" href="javascript:;">好人榜</a></li>
	  		<li><a class="Title_a" href="javascript:;">字数榜</a></li>
	  		<li><a class="Title_a" href="javascript:;">点击榜</a></li>
	  	</ul>
	  </div>
	  <div id="content">
	  	<div class="content_Label">
		  	<ul>
		  		<li class="active">全部</li>
		  		<li>幻想</li>
		  		<li>恋爱</li>
		  		<li>异界</li>
		  		<li>搞笑</li>
		  		<li>日常</li>
		  		<li>校园</li>
		  		<li>后宫</li>
		  		<li>推理</li>
		  		<li>科幻</li>
		  		<li>治愈</li>
		  		<li>超能力</li>
		  		<li>恐怖</li>
		  		<li>伪娘</li>
		  		<li>乙女</li>
		  		<li>同人</li>
		  		<li>悬疑</li>
		  		<li>网游</li>
		  	</ul>
	  	</div>
	  	<div class="content_Draft">
	  		<ul>
	  			<img src="${pageContext.servletContext.contextPath }/img/arrow1.png"/>
	  			<li>全部投稿</li>
	  			<li class="content_li">近期投稿</li>
	  			<li class="content_li">近期投稿</li>
	  			<li class="content_li">近期投稿</li>
	  		</ul>
	  	</div>
	  	<div class="content_List">
	  		<ul>
	  			
	  			<img src="${pageContext.servletContext.contextPath }/img/arrow1.png"/>
	  			<li>近日排行</li>
	  			<li class="List_li">日排行</li>
	  			<li class="List_li">周排行</li>
	  			<li class="List_li">月排行</li>
	  		</ul>
	  	</div>
	  	<div class="content_ranking active">
	  		<h1>1</h1>
	  		<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/Cover-map.jpg"/></a>
	  		<ul>
	  			<li><a href="javascript:;" class="content_a" title="巴拉拉老魔仙巴拉拉老魔仙巴拉拉老魔仙巴拉拉"><span>巴拉拉老魔仙巴拉拉老魔仙巴拉拉老魔仙巴拉拉老魔仙</span></a></li>
	  			<li>作者：huhuf5</li>
	  			<li></li>
	  			<li>点击：34.4万</li>
	  			<li>好人卡：70万</li>
	  			<li>字数：50万</li>
	  		</ul>
	  		<a class="ranking_Collection" href="javascript:;">已收藏</a>
	  	</div>
	  	<div class="content_ranking ">
	  		<h1>2</h1>
	  		<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/Cover-map.jpg"/></a>
	  		<ul>
	  			<li><a href="javascript:;" class="content_a" title="巴拉拉老魔仙巴拉拉老魔仙巴拉拉老魔仙巴拉拉"><span>巴拉拉老魔仙巴拉拉老魔仙巴拉拉老魔仙巴拉拉老魔仙</span></a></li>
	  			<li>作者：huhuf5</li>
	  			<li></li>
	  			<li>点击：34.4万</li>
	  			<li>好人卡：70万</li>
	  			<li>字数：50万</li>
	  		</ul>
	  		<a class="ranking_Collection" href="javascript:;">点击收藏</a>
	  	</div>
	  	<div class="content_ranking ">
	  		<h1>3</h1>
	  		<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/Cover-map.jpg"/></a>
	  		<ul>
	  			<li><a href="javascript:;" class="content_a" title="巴拉拉老魔仙巴拉拉老魔仙巴拉拉老魔仙巴拉拉"><span>巴拉拉老魔仙</span></a></li>
	  			<li>作者：huhuf5</li>
	  			<li></li>
	  			<li>点击：34.4万</li>
	  			<li>好人卡：70万</li>
	  			<li>字数：50万</li>
	  		</ul>
	  		<a class="ranking_Collection" href="javascript:;">点击收藏</a>
	  	</div>
	  	<div class="content_ranking ">
	  		<h1>4</h1>
	  		<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/Cover-map.jpg"/></a>
	  		<ul>
	  			<li><a href="javascript:;" class="content_a" title="巴拉拉老魔仙巴拉拉老魔仙巴拉拉老魔仙巴拉拉"><span>巴拉拉老魔仙</span></a></li>
	  			<li>作者：huhuf5</li>
	  			<li></li>
	  			<li>点击：34.4万</li>
	  			<li>好人卡：70万</li>
	  			<li>字数：50万</li>
	  		</ul>
	  		<a class="ranking_Collection" href="javascript:;">点击收藏</a>
	  	</div>
	  	<div class="content_ranking ">
	  		<h1>5</h1>
	  		<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/Cover-map.jpg"/></a>
	  		<ul>
	  			<li><a href="javascript:;" class="content_a" title="巴拉拉老魔仙巴拉拉老魔仙巴拉拉老魔仙巴拉拉"><span>巴拉拉老魔仙</span></a></li>
	  			<li>作者：huhuf5</li>
	  			<li></li>
	  			<li>点击：34.4万</li>
	  			<li>好人卡：70万</li>
	  			<li>字数：50万</li>
	  		</ul>
	  		<a class="ranking_Collection" href="javascript:;">点击收藏</a>
	  	</div>
	  	<div class="content_ranking ">
	  		<h1>6</h1>
	  		<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/Cover-map.jpg"/></a>
	  		<ul>
	  			<li><a href="javascript:;" class="content_a" title="巴拉拉老魔仙巴拉拉老魔仙巴拉拉老魔仙巴拉拉"><span>巴拉拉老魔仙</span></a></li>
	  			<li>作者：huhuf5</li>
	  			<li></li>
	  			<li>点击：34.4万</li>
	  			<li>好人卡：70万</li>
	  			<li>字数：50万</li>
	  		</ul>
	  		<a class="ranking_Collection" href="javascript:;">点击收藏</a>
	  	</div>
	  	<div class="content_ranking ">
	  		<h1>7</h1>
	  		<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/Cover-map.jpg"/></a>
	  		<ul>
	  			<li><a href="javascript:;" class="content_a" title="巴拉拉老魔仙巴拉拉老魔仙巴拉拉老魔仙巴拉拉"><span>巴拉拉老魔仙</span></a></li>
	  			<li>作者：huhuf5</li>
	  			<li></li>
	  			<li>点击：34.4万</li>
	  			<li>好人卡：70万</li>
	  			<li>字数：50万</li>
	  		</ul>
	  		<a class="ranking_Collection" href="javascript:;">点击收藏</a>
	  	</div>
	  	<div class="content_ranking ">
	  		<h1>8</h1>
	  		<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/Cover-map.jpg"/></a>
	  		<ul>
	  			<li><a href="javascript:;" class="content_a" title="巴拉拉老魔仙巴拉拉老魔仙巴拉拉老魔仙巴拉拉"><span>巴拉拉老魔仙</span></a></li>
	  			<li>作者：huhuf5</li>
	  			<li></li>
	  			<li>点击：34.4万</li>
	  			<li>好人卡：70万</li>
	  			<li>字数：50万</li>
	  		</ul>
	  		<a class="ranking_Collection" href="javascript:;">点击收藏</a>
	  	</div>
	  	<div class="content_ranking ">
	  		<h1>9</h1>
	  		<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/Cover-map.jpg"/></a>
	  		<ul>
	  			<li><a href="javascript:;" class="content_a" title="巴拉拉老魔仙巴拉拉老魔仙巴拉拉老魔仙巴拉拉"><span>巴拉拉老魔仙</span></a></li>
	  			<li>作者：huhuf5</li>
	  			<li></li>
	  			<li>点击：34.4万</li>
	  			<li>好人卡：70万</li>
	  			<li>字数：50万</li>
	  		</ul>
	  		<a class="ranking_Collection" href="javascript:;">点击收藏</a>
	  	</div>
	  		<div class="content_ranking ">
	  		<h1>10</h1>
	  		<a href="javascript:;"><img src="${pageContext.servletContext.contextPath }/img/Cover-map.jpg"/></a>
	  		<ul>
	  			<li><a href="javascript:;" class="content_a" title="巴拉拉老魔仙巴拉拉老魔仙巴拉拉老魔仙巴拉拉"><span>巴拉拉老魔仙</span></a></li>
	  			<li>作者：huhuf5</li>
	  			<li></li>
	  			<li>点击：34.4万</li>
	  			<li>好人卡：70万</li>
	  			<li>字数：50万</li>
	  		</ul>
	  		<a class="ranking_Collection" href="javascript:;">点击收藏</a>
	  	</div>
	  </div>
	  <div id="page" class="page">
	      	<ul>
	      		<li><a>上一页</a></li>
	      		<li><a>1</a></li>
	      		<li class="active"><a>2</a></li>
	      		<li><a>3</a></li>
	      		<li><a>4</a></li>
	      		<li><a>5</a></li>
	      		<li><a>下一页</a></li>
	      		<li class="goto"><input type="text"  value="" /><span>/1211</span><a>转页</a></li>
	      	</ul>
      	</div>
	<%@ include file="public-footer.jsp" %>
	</body>
</html>
