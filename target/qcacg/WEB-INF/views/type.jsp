<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>轻创文学网-分类页</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/main.css" />
  </head>
  <style>
    .class-content {
      width: 1200px;
      margin: 0px auto;
      padding: 0px;
      margin-top: 20px;
    }
    .class-label {
      padding: 5px;
      width: 70px;
      display: block;
      float: left;
    }
    .class-label-ul {
      width: 795px;
      overflow: hidden;
    }
    .class-title {
      width: 865px;
      margin: 0px auto;
    }
    .class-title-line {

    }
    .class-content div {
      overflow: hidden;
    }
    .class-title-line span {
      cursor: pointer;
      display: block;
      float: left;
      margin: 0px 20px 0px 0px;
      padding: 5px;
    }
    .class-content .class-title-line ul li {
      padding: 5px;
      cursor: pointer;
      float: left;
      margin: 0px 20px 10px 0px;
    }
    .class-content .class-title-line ul li:hover {
    	background-color: #e74c3c;
      border-radius: 4px;
      color: #FFFFFF;
    }
    .class-content .class-title-line span:hover {
    	background-color: #e74c3c;
      border-radius: 4px;
      color: #FFFFFF;
    }
    .class-content .class-title-line .vertical-transverse li {
    	padding: 5px;
      cursor: pointer;
      float: left;
      margin: 0px 20px 10px 0px;
    }
    .class-content .class-title-line .active {
      background-color: #e74c3c;
      border-radius: 4px;
      color: #FFFFFF;
    }
    .class-btn-search {
      padding:5px;
      display: inline-block;
      height: 26px;
      width: 50px;
      text-align: right;
      background-color: #00a1d6;
      margin-left: 10px;
      border-radius: 4px;
      color: #ffffff;
    }
    .class-btn-search-input {
      height: 26px;
      width: 178px;
      border: 2px solid #c6c6c6;
      border-radius: 5px;
      text-align: center;
    }
    .class-search-img {
      position: absolute;
      display: block;
      width: 15px;
      height: 14px;
      background-image: url(img/search.png);
      background-repeat: no-repeat;
      right: 32px;
      top: 6px;
    }
    
    .class-content .line:hover {
      width: 915px;
      margin: 0px auto;
      height: 190px;
      margin-top: 30px;
      -webkit-box-shadow: 0px 4px 7px rgba(0, 0, 0, 0.3);
      box-shadow:  0px 4px 7px rgba(0, 0, 0, 0.3);
    }
    .class-content .line {
      width: 915px;
      margin: 0px auto;
      height: 190px;
      margin-top: 30px;
      border-bottom: 1px solid #999999;
    }
    .class-content .line .line-img {
      margin: 25px 20px 25px 30px;
    }
    .class-content .line .line-content {
      width: 765px;
    }
    .class-content .line .line-content label {
      margin-right: 10px;
      float: left;
      display: block;
      color: #000000;
    }
    .class-content .line .line-content .span {
      overflow: hidden;
      display: block;
      float: left;
      margin-right: 20px;
      width: 150px;
      text-overflow: ellipsis;
      white-space: nowrap;
    }
    .class-content .line .line-content .p {
      color: #00a1d6;
      font-size: 22px;
      margin-top: 25px;
    }
    .class-content .line .line-content .div {
      margin-top: 20px;  
    }
    .class-content .line .line-content .p-2 {
      margin-top: 20px;
      color: #7f7e7e;
    }
    
    .page {
		      margin-top: 30px;
		      min-height: 1px;
		      margin-bottom: 30px;
		    }
      	.page ul {
      		margin: 0 auto;
      		width: 540px;
      		height: 26px;
      	}
      	.page ul li {
      		float: left;
      		border: solid 1px #c7c7c7;
      		padding: 5px 10px;
      		margin-right: 10px;
      		border-radius: 4px;
      		cursor: pointer;
      	}
      	.page ul li.active {
      		background-color: #00a1d6;
      		color: #FFFFFF;
      	}
      
      	.page ul li.goto {
      		border: 0px;
      		position: relative;
      		cursor: default;
      	}
      	.page ul li.goto input {
      		height: 26px;
      		width: 80px;
      		border-radius: 4px 0px 0px 4px;
      		border: 1px solid #c7c7c7;
      		margin-top: -5px;
      		font-size: 14px;
      	}
      	.page ul li.goto span {
      		position: absolute;
      		display: block;
      		top: 5px;
      		right: -85px;
      		cursor: default;
      	}
      	.page ul li.goto a {
      		top: 0px;
			    right: -39px;
			    display: block;
			    position: absolute;
			    border-radius: 0px 4px 4px 0px;
			    border: 1px solid #c7c7c7;
			    height: 26px;
			    padding: 5px 10px;
			    text-align: center;
			    cursor: pointer;
      	}
    		.class-content .line-vertical {
      		height: 295px;
      		border-top: 1px solid #999999;
      		width: 895px;
      		margin: 0 auto;
      		margin-top: 20px;
      	}
      	.line-vertical * {
      		overflow: initial;
      	}
      	.class-content .line-vertical ul {
      		height: 100%;
      	}
      	.class-content .line-vertical ul li {
      		width: 25%;
      		height: 100%;
      		float: left;
      	}
      	.class-content .line-vertical .vertical-img {
      		width: 150px;
      		height: 210px;
      		margin: 0 auto;
      		display: block;
      		margin-top: 42.5px;
      		position: relative;
      		overflow: hidden;
      	}
      	.class-content .line-vertical .vertical-img .vertical-img-line {
      		position: absolute;
			    z-index: 1;
			    width: 100%;
			    height: 100%;
			    top: 0;
			    background-color: #000;
			    background-color: rgba(0,0,0,.2);
			    filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=0);
			    padding: 10px;
			    opacity: 0;
			    -webkit-transition: opacity .3s ease;
			    transition: opacity .3s ease;
			    border-radius: 4px;
			    
      	}
      	.class-content .line-vertical .vertical-img .vertical-img-line:hover{
      		filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=100);
    			opacity: 1;
      	}
      	.class-content .line-vertical .vertical-img .vertical-img-line img {
      		width: 50px;
      		height: 50px;
      		display: block;
      		position: absolute;
      		border-radius: 25px;
      		overflow: hidden;
      		border: 0px;
      	}
      	.class-content .line-vertical .vertical-img:hover .cover  {
      		-webkit-filter: blur(4px);
    			filter: blur(4px);
      	}
      	.class-content .line-vertical .vertical-img .cover {
      		-webkit-transition: all .5s;
    			transition: all .5s;
    			width: 100%;
    			height: 100%;
    			position: relative;
      	}
    		.class-content .line-vertical .vertical-img .vertical-hover {
    			white-space: nowrap;
    			overflow: hidden;
    			text-overflow: ellipsis;
    			width: 100%;
    			color: #FFFFFF;
    		}
    		.class-content .line-vertical .vertical-img .vertical-hover label {
    			float: left;
    			display: block;
    			margin-right: 5px;
    		}
    		.class-content .line-vertical .vertical-img .vertical-Author-name {
    			    position: absolute;
					    left: 70px;
					    padding-right: 80px;
					    top: 25px;
    		}
    		.class-content .line-vertical .vertical-img .vertical-font-size {
    			position: absolute;
    			top: 105px;
    			padding-right: 20px;
    			
    		}
    		
    		.class-content .line-vertical .vertical-img .vertical-click-size {
    			position: absolute;
    			top: 130px;
    			padding-right: 20px;
    		}
    		.class-content .line-vertical .vertical-img .vertical-collection-size {
    			position: absolute;
    			top: 155px;
    			padding-right: 20px;
    		}
    		.class-content .line-vertical .vertical-img .vertical-a-reward {
    			position: absolute;
    			top: 180px;
    			padding-right: 20px;
    		}
    		.class-content .line-vertical .vertical-title {
      		padding-top: 12px;
			    width: 150px;
			    height: 35px;
			    font-size: 22px;
			    text-align: center;
			    margin: 0 auto;
			    overflow: hidden;
			    text-overflow: ellipsis;
			    white-space: nowrap;
      	}
      	.class-body {
      		background-color: #FFFFFF;
      	}
  </style>
  <body class="class-body">
    <iframe id="qcacg-header" style="height: 56px;width: 100%;min-width:1200px;border: 0px;overflow: hidden;" src="${pageContext.servletContext.contextPath }/public/public-header.html"></iframe>
    <div class="class-content">
      <div class="class-title">
        <div class="class-title-line">
          <label class="class-label">排序:</label>
          <div class="pull-left">
            <span class="active">最新</span>
            <span>最热</span>
          </div>
          <ol class="pull-right vertical-transverse">
            <li><img src="${pageContext.servletContext.contextPath }/img/class1-1.png" /></li>
            <li><img src="${pageContext.servletContext.contextPath }/img/class2-2.png" /></li>
          </ol>
        </div>
        <div class="class-title-line">
          <label class="class-label" >分类:</label>
          <ul class="class-label-ul">
            <li class="active">战斗</li>
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
        <div class="class-title-line">
          <label class="class-label">字数:</label>
          <ul class="class-label-ul">
            <li>10万字以上</li>
            <li class="active">10-30万字</li>
            <li>30-50万字</li>
            <li>50-100万字</li>
            <li>100万以上</li>
          </ul>
        </div>
       <div class="class-title-line">
          <label class="class-label" >签约:</label>
          <div class="pull-left">
          <span class="active">精品作品</span>
          <span>签约作品</span>
          </div>
          <div class="pull-right relative"><input type="text" class="class-btn-search-input" /><i class="class-search-img"></i><a class="btn class-btn-search">搜索</a></div>
        </div>
      </div>
      <!--
      	作者：275120399@qq.com
      	时间：2016-09-12
      	描述：下面是横向导航部分
      -->
      <ul id="transverse">
        <li class="line active">
          <img src="img/100x140.png" class="line-img pull-left">
          <div class="pull-left line-content">
            <p class="p" title="夏日大作战">夏日大作战</p>
            <div class="div">
              <span class="span" title="作者:paipi酱我我我我我我我"><label>作者:</label>paipi酱我我我我我我我</span>
              <span class="span" title="画师:paipi酱我我我我我我我"><label>画师:</label>paipi酱</span>
              <span class="span" title="字数:3000000"><label>字数:</label>30000000</span>
              <span class="span" title="人气:3000000"><label>人气:</label>90000000</span>
            </div>
            <p class="p-2"title="一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一连串故事。健二在偶然的机遇下解开一个">
              <label>简介:</label>一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的 一连串故事。健二在偶然的机遇下解开一个奇……
            </p>
            <div class="div">
              <span class="span" title="最新卷:78卷"><label>最新卷:</label>78卷</span>
              <span class="span" title="最新更新:2016-9-13"><label>最新更新:</label>2016-9-13</span>
            </div>
          </div>
        </li>
        
        <li class="line">
          <img src="img/100x140.png" class="line-img pull-left">
          <div class="pull-left line-content">
            <p class="p" title="夏日大作战">夏日大作战</p>
            <div class="div">
              <span class="span" title="作者:paipi酱我我我我我我我"><label>作者:</label>paipi酱我我我我我我我</span>
              <span class="span" title="画师:paipi酱我我我我我我我"><label>画师:</label>paipi酱</span>
              <span class="span" title="字数:3000000"><label>字数:</label>30000000</span>
              <span class="span" title="人气:3000000"><label>人气:</label>90000000</span>
            </div>
            <p class="p-2"title="一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一连串故事。健二在偶然的机遇下解开一个">
              <label>简介:</label>一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的 一连串故事。健二在偶然的机遇下解开一个奇……
            </p>
            <div class="div">
              <span class="span" title="最新卷:78卷"><label>最新卷:</label>78卷</span>
              <span class="span" title="最新更新:2016-9-13"><label>最新更新:</label>2016-9-13</span>
            </div>
          </div>
        </li>
        
        <li class="line">
          <img src="img/100x140.png" class="line-img pull-left">
          <div class="pull-left line-content">
            <p class="p" title="夏日大作战">夏日大作战</p>
            <div class="div">
              <span class="span" title="作者:paipi酱我我我我我我我"><label>作者:</label>paipi酱我我我我我我我</span>
              <span class="span" title="画师:paipi酱我我我我我我我"><label>画师:</label>paipi酱</span>
              <span class="span" title="字数:3000000"><label>字数:</label>30000000</span>
              <span class="span" title="人气:3000000"><label>人气:</label>90000000</span>
            </div>
            <p class="p-2"title="一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一连串故事。健二在偶然的机遇下解开一个">
              <label>简介:</label>一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的 一连串故事。健二在偶然的机遇下解开一个奇……
            </p>
            <div class="div">
              <span class="span" title="最新卷:78卷"><label>最新卷:</label>78卷</span>
              <span class="span" title="最新更新:2016-9-13"><label>最新更新:</label>2016-9-13</span>
            </div>
          </div>
        </li>
        
        <li class="line">
          <img src="img/100x140.png" class="line-img pull-left">
          <div class="pull-left line-content">
            <p class="p" title="夏日大作战">夏日大作战</p>
            <div class="div">
              <span class="span" title="作者:paipi酱我我我我我我我"><label>作者:</label>paipi酱我我我我我我我</span>
              <span class="span" title="画师:paipi酱我我我我我我我"><label>画师:</label>paipi酱</span>
              <span class="span" title="字数:3000000"><label>字数:</label>30000000</span>
              <span class="span" title="人气:3000000"><label>人气:</label>90000000</span>
            </div>
            <p class="p-2"title="一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一连串故事。健二在偶然的机遇下解开一个">
              <label>简介:</label>一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的 一连串故事。健二在偶然的机遇下解开一个奇……
            </p>
            <div class="div">
              <span class="span" title="最新卷:78卷"><label>最新卷:</label>78卷</span>
              <span class="span" title="最新更新:2016-9-13"><label>最新更新:</label>2016-9-13</span>
            </div>
          </div>
        </li>
        
        <li class="line">
          <img src="img/100x140.png" class="line-img pull-left">
          <div class="pull-left line-content">
            <p class="p" title="夏日大作战">夏日大作战</p>
            <div class="div">
              <span class="span" title="作者:paipi酱我我我我我我我"><label>作者:</label>paipi酱我我我我我我我</span>
              <span class="span" title="画师:paipi酱我我我我我我我"><label>画师:</label>paipi酱</span>
              <span class="span" title="字数:3000000"><label>字数:</label>30000000</span>
              <span class="span" title="人气:3000000"><label>人气:</label>90000000</span>
            </div>
            <p class="p-2"title="一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一连串故事。健二在偶然的机遇下解开一个">
              <label>简介:</label>一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的 一连串故事。健二在偶然的机遇下解开一个奇……
            </p>
            <div class="div">
              <span class="span" title="最新卷:78卷"><label>最新卷:</label>78卷</span>
              <span class="span" title="最新更新:2016-9-13"><label>最新更新:</label>2016-9-13</span>
            </div>
          </div>
        </li>
        
        <li class="line">
          <img src="img/100x140.png" class="line-img pull-left">
          <div class="pull-left line-content">
            <p class="p" title="夏日大作战">夏日大作战</p>
            <div class="div">
              <span class="span" title="作者:paipi酱我我我我我我我"><label>作者:</label>paipi酱我我我我我我我</span>
              <span class="span" title="画师:paipi酱我我我我我我我"><label>画师:</label>paipi酱</span>
              <span class="span" title="字数:3000000"><label>字数:</label>30000000</span>
              <span class="span" title="人气:3000000"><label>人气:</label>90000000</span>
            </div>
            <p class="p-2"title="一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一连串故事。健二在偶然的机遇下解开一个">
              <label>简介:</label>一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的 一连串故事。健二在偶然的机遇下解开一个奇……
            </p>
            <div class="div">
              <span class="span" title="最新卷:78卷"><label>最新卷:</label>78卷</span>
              <span class="span" title="最新更新:2016-9-13"><label>最新更新:</label>2016-9-13</span>
            </div>
          </div>
        </li>
        
        <li class="line">
          <img src="img/100x140.png" class="line-img pull-left">
          <div class="pull-left line-content">
            <p class="p" title="夏日大作战">夏日大作战</p>
            <div class="div">
              <span class="span" title="作者:paipi酱我我我我我我我"><label>作者:</label>paipi酱我我我我我我我</span>
              <span class="span" title="画师:paipi酱我我我我我我我"><label>画师:</label>paipi酱</span>
              <span class="span" title="字数:3000000"><label>字数:</label>30000000</span>
              <span class="span" title="人气:3000000"><label>人气:</label>90000000</span>
            </div>
            <p class="p-2"title="一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一连串故事。健二在偶然的机遇下解开一个">
              <label>简介:</label>一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的 一连串故事。健二在偶然的机遇下解开一个奇……
            </p>
            <div class="div">
              <span class="span" title="最新卷:78卷"><label>最新卷:</label>78卷</span>
              <span class="span" title="最新更新:2016-9-13"><label>最新更新:</label>2016-9-13</span>
            </div>
          </div>
        </li>
        
        <li class="line">
          <img src="img/100x140.png" class="line-img pull-left">
          <div class="pull-left line-content">
            <p class="p" title="夏日大作战">夏日大作战</p>
            <div class="div">
              <span class="span" title="作者:paipi酱我我我我我我我"><label>作者:</label>paipi酱我我我我我我我</span>
              <span class="span" title="画师:paipi酱我我我我我我我"><label>画师:</label>paipi酱</span>
              <span class="span" title="字数:3000000"><label>字数:</label>30000000</span>
              <span class="span" title="人气:3000000"><label>人气:</label>90000000</span>
            </div>
            <p class="p-2"title="一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一连串故事。健二在偶然的机遇下解开一个">
              <label>简介:</label>一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的 一连串故事。健二在偶然的机遇下解开一个奇……
            </p>
            <div class="div">
              <span class="span" title="最新卷:78卷"><label>最新卷:</label>78卷</span>
              <span class="span" title="最新更新:2016-9-13"><label>最新更新:</label>2016-9-13</span>
            </div>
          </div>
        </li>
        
        <li class="line">
          <img src="img/100x140.png" class="line-img pull-left">
          <div class="pull-left line-content">
            <p class="p" title="夏日大作战">夏日大作战</p>
            <div class="div">
              <span class="span" title="作者:paipi酱我我我我我我我"><label>作者:</label>paipi酱我我我我我我我</span>
              <span class="span" title="画师:paipi酱我我我我我我我"><label>画师:</label>paipi酱</span>
              <span class="span" title="字数:3000000"><label>字数:</label>30000000</span>
              <span class="span" title="人气:3000000"><label>人气:</label>90000000</span>
            </div>
            <p class="p-2"title="一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一连串故事。健二在偶然的机遇下解开一个">
              <label>简介:</label>一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的 一连串故事。健二在偶然的机遇下解开一个奇……
            </p>
            <div class="div">
              <span class="span" title="最新卷:78卷"><label>最新卷:</label>78卷</span>
              <span class="span" title="最新更新:2016-9-13"><label>最新更新:</label>2016-9-13</span>
            </div>
          </div>
        </li>
        
        <li class="line">
          <img src="img/100x140.png" class="line-img pull-left">
          <div class="pull-left line-content">
            <p class="p" title="夏日大作战">夏日大作战</p>
            <div class="div">
              <span class="span" title="作者:paipi酱我我我我我我我"><label>作者:</label>paipi酱我我我我我我我</span>
              <span class="span" title="画师:paipi酱我我我我我我我"><label>画师:</label>paipi酱</span>
              <span class="span" title="字数:3000000"><label>字数:</label>30000000</span>
              <span class="span" title="人气:3000000"><label>人气:</label>90000000</span>
            </div>
            <p class="p-2"title="一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一连串故事。健二在偶然的机遇下解开一个">
              <label>简介:</label>一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的 一连串故事。健二在偶然的机遇下解开一个奇……
            </p>
            <div class="div">
              <span class="span" title="最新卷:78卷"><label>最新卷:</label>78卷</span>
              <span class="span" title="最新更新:2016-9-13"><label>最新更新:</label>2016-9-13</span>
            </div>
          </div>
        </li>
        
        <li class="line">
          <img src="img/100x140.png" class="line-img pull-left">
          <div class="pull-left line-content">
            <p class="p" title="夏日大作战">夏日大作战</p>
            <div class="div">
              <span class="span" title="作者:paipi酱我我我我我我我"><label>作者:</label>paipi酱我我我我我我我</span>
              <span class="span" title="画师:paipi酱我我我我我我我"><label>画师:</label>paipi酱</span>
              <span class="span" title="字数:3000000"><label>字数:</label>30000000</span>
              <span class="span" title="人气:3000000"><label>人气:</label>90000000</span>
            </div>
            <p class="p-2"title="一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一连串故事。健二在偶然的机遇下解开一个">
              <label>简介:</label>一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的 一连串故事。健二在偶然的机遇下解开一个奇……
            </p>
            <div class="div">
              <span class="span" title="最新卷:78卷"><label>最新卷:</label>78卷</span>
              <span class="span" title="最新更新:2016-9-13"><label>最新更新:</label>2016-9-13</span>
            </div>
          </div>
        </li>
        
        <li class="line">
          <img src="img/100x140.png" class="line-img pull-left">
          <div class="pull-left line-content">
            <p class="p" title="夏日大作战">夏日大作战</p>
            <div class="div">
              <span class="span" title="作者:paipi酱我我我我我我我"><label>作者:</label>paipi酱我我我我我我我</span>
              <span class="span" title="画师:paipi酱我我我我我我我"><label>画师:</label>paipi酱</span>
              <span class="span" title="字数:3000000"><label>字数:</label>30000000</span>
              <span class="span" title="人气:3000000"><label>人气:</label>90000000</span>
            </div>
            <p class="p-2"title="一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的一连串故事。健二在偶然的机遇下解开一个">
              <label>简介:</label>一名胆小的高二数学天才小矶健二在学姊筱原夏希的拜托之下，一同前往她祖母位于上田市的宅邸来庆祝曾祖母的90岁生日所发生的 一连串故事。健二在偶然的机遇下解开一个奇……
            </p>
            <div class="div">
              <span class="span" title="最新卷:78卷"><label>最新卷:</label>78卷</span>
              <span class="span" title="最新更新:2016-9-13"><label>最新更新:</label>2016-9-13</span>
            </div>
          </div>
        </li>
        
      </ul>
      <ul id="vertical">
        <li class="line-vertical">
        	<ul>
        		<li>
        			<div class="vertical-img">
        				<img src="img/150x210.jpg" class="cover"/>
        				<div class="vertical-img-line">
        					<img src="img/50x50-tou.jpg" />
        					<div class="vertical-Author-name vertical-hover">huhuf6我我我我我我我我我</div>
        					<div class="vertical-font-size vertical-hover"><label>字数:</label>28.7万我我我我我我我</div>
        					<div class="vertical-click-size vertical-hover"><label>点击:</label>49.5万我我我我我我</div>
        					<div class="vertical-collection-size vertical-hover"><label>收藏:</label>16万我我我我我我我我我</div>
        					<div class="vertical-a-reward vertical-hover"><label>打赏:</label>50000我s我s我s我s我s我s我s我s我s我s我s我s我</div>
        				</div>
        			</div>
        			<div class="vertical-title" title="夏日大作战夏日大作战夏日大作战">夏日大作战夏日大作战夏日大作战</div>
        		</li>
        		<li>
        			<div class="vertical-img">
        				<img src="img/150x210.jpg" class="cover"/>
        				<div class="vertical-img-line">
        					<img src="img/50x50-tou.jpg" />
        					<div class="vertical-Author-name vertical-hover">huhuf6我我我我我我我我我</div>
        					<div class="vertical-font-size vertical-hover"><label>字数:</label>28.7万我我我我我我我</div>
        					<div class="vertical-click-size vertical-hover"><label>点击:</label>49.5万我我我我我我</div>
        					<div class="vertical-collection-size vertical-hover"><label>收藏:</label>16万我我我我我我我我我</div>
        					<div class="vertical-a-reward vertical-hover"><label>打赏:</label>50000我s我s我s我s我s我s我s我s我s我s我s我s我</div>
        				</div>
        			</div>
        			<div class="vertical-title" title="夏日大作战夏日大作战夏日大作战">夏日大作战夏日大作战夏日大作战</div>
        		</li>
        		<li>
        			<div class="vertical-img">
        				<img src="img/150x210.jpg" class="cover"/>
        				<div class="vertical-img-line">
        					<img src="img/50x50-tou.jpg" />
        					<div class="vertical-Author-name vertical-hover">huhuf6我我我我我我我我我</div>
        					<div class="vertical-font-size vertical-hover"><label>字数:</label>28.7万我我我我我我我</div>
        					<div class="vertical-click-size vertical-hover"><label>点击:</label>49.5万我我我我我我</div>
        					<div class="vertical-collection-size vertical-hover"><label>收藏:</label>16万我我我我我我我我我</div>
        					<div class="vertical-a-reward vertical-hover"><label>打赏:</label>50000我s我s我s我s我s我s我s我s我s我s我s我s我</div>
        				</div>
        			</div>
        			<div class="vertical-title" title="夏日大作战夏日大作战夏日大作战">夏日大作战夏日大作战夏日大作战</div>
        		</li>
        		<li>
        			<div class="vertical-img">
        				<img src="img/150x210.jpg" class="cover"/>
        				<div class="vertical-img-line">
        					<img src="img/50x50-tou.jpg" />
        					<div class="vertical-Author-name vertical-hover">huhuf6我我我我我我我我我</div>
        					<div class="vertical-font-size vertical-hover"><label>字数:</label>28.7万我我我我我我我</div>
        					<div class="vertical-click-size vertical-hover"><label>点击:</label>49.5万我我我我我我</div>
        					<div class="vertical-collection-size vertical-hover"><label>收藏:</label>16万我我我我我我我我我</div>
        					<div class="vertical-a-reward vertical-hover"><label>打赏:</label>50000我s我s我s我s我s我s我s我s我s我s我s我s我</div>
        				</div>
        			</div>
        			<div class="vertical-title" title="夏日大作战夏日大作战夏日大作战">夏日大作战夏日大作战夏日大作战</div>
        		</li>
        	</ul>
        </li>
        <li class="line-vertical">
        	<ul>
        		<li>
        			<div class="vertical-img">
        				<img src="img/150x210.jpg" class="cover"/>
        				<div class="vertical-img-line">
        					<img src="img/50x50-tou.jpg" />
        					<div class="vertical-Author-name vertical-hover">huhuf6我我我我我我我我我</div>
        					<div class="vertical-font-size vertical-hover"><label>字数:</label>28.7万我我我我我我我</div>
        					<div class="vertical-click-size vertical-hover"><label>点击:</label>49.5万我我我我我我</div>
        					<div class="vertical-collection-size vertical-hover"><label>收藏:</label>16万我我我我我我我我我</div>
        					<div class="vertical-a-reward vertical-hover"><label>打赏:</label>50000我s我s我s我s我s我s我s我s我s我s我s我s我</div>
        				</div>
        			</div>
        			<div class="vertical-title" title="夏日大作战夏日大作战夏日大作战">夏日大作战夏日大作战夏日大作战</div>
        		</li>
        		<li>
        			<div class="vertical-img">
        				<img src="img/150x210.jpg" class="cover"/>
        				<div class="vertical-img-line">
        					<img src="img/50x50-tou.jpg" />
        					<div class="vertical-Author-name vertical-hover">huhuf6我我我我我我我我我</div>
        					<div class="vertical-font-size vertical-hover"><label>字数:</label>28.7万我我我我我我我</div>
        					<div class="vertical-click-size vertical-hover"><label>点击:</label>49.5万我我我我我我</div>
        					<div class="vertical-collection-size vertical-hover"><label>收藏:</label>16万我我我我我我我我我</div>
        					<div class="vertical-a-reward vertical-hover"><label>打赏:</label>50000我s我s我s我s我s我s我s我s我s我s我s我s我</div>
        				</div>
        			</div>
        			<div class="vertical-title" title="夏日大作战夏日大作战夏日大作战">夏日大作战夏日大作战夏日大作战</div>
        		</li>
        		<li>
        			<div class="vertical-img">
        				<img src="img/150x210.jpg" class="cover"/>
        				<div class="vertical-img-line">
        					<img src="img/50x50-tou.jpg" />
        					<div class="vertical-Author-name vertical-hover">huhuf6我我我我我我我我我</div>
        					<div class="vertical-font-size vertical-hover"><label>字数:</label>28.7万我我我我我我我</div>
        					<div class="vertical-click-size vertical-hover"><label>点击:</label>49.5万我我我我我我</div>
        					<div class="vertical-collection-size vertical-hover"><label>收藏:</label>16万我我我我我我我我我</div>
        					<div class="vertical-a-reward vertical-hover"><label>打赏:</label>50000我s我s我s我s我s我s我s我s我s我s我s我s我</div>
        				</div>
        			</div>
        			<div class="vertical-title" title="夏日大作战夏日大作战夏日大作战">夏日大作战夏日大作战夏日大作战</div>
        		</li>
        		<li>
        			<div class="vertical-img">
        				<img src="img/150x210.jpg" class="cover"/>
        				<div class="vertical-img-line">
        					<img src="img/50x50-tou.jpg" />
        					<div class="vertical-Author-name vertical-hover">huhuf6我我我我我我我我我</div>
        					<div class="vertical-font-size vertical-hover"><label>字数:</label>28.7万我我我我我我我</div>
        					<div class="vertical-click-size vertical-hover"><label>点击:</label>49.5万我我我我我我</div>
        					<div class="vertical-collection-size vertical-hover"><label>收藏:</label>16万我我我我我我我我我</div>
        					<div class="vertical-a-reward vertical-hover"><label>打赏:</label>50000我s我s我s我s我s我s我s我s我s我s我s我s我</div>
        				</div>
        			</div>
        			<div class="vertical-title" title="夏日大作战夏日大作战夏日大作战">夏日大作战夏日大作战夏日大作战</div>
        		</li>
        	</ul>
        </li>
        <li class="line-vertical">
        	<ul>
        		<li>
        			<div class="vertical-img">
        				<img src="img/150x210.jpg" class="cover"/>
        				<div class="vertical-img-line">
        					<img src="img/50x50-tou.jpg" />
        					<div class="vertical-Author-name vertical-hover">huhuf6我我我我我我我我我</div>
        					<div class="vertical-font-size vertical-hover"><label>字数:</label>28.7万我我我我我我我</div>
        					<div class="vertical-click-size vertical-hover"><label>点击:</label>49.5万我我我我我我</div>
        					<div class="vertical-collection-size vertical-hover"><label>收藏:</label>16万我我我我我我我我我</div>
        					<div class="vertical-a-reward vertical-hover"><label>打赏:</label>50000我s我s我s我s我s我s我s我s我s我s我s我s我</div>
        				</div>
        			</div>
        			<div class="vertical-title" title="夏日大作战夏日大作战夏日大作战">夏日大作战夏日大作战夏日大作战</div>
        		</li>
        		<li>
        			<div class="vertical-img">
        				<img src="img/150x210.jpg" class="cover"/>
        				<div class="vertical-img-line">
        					<img src="img/50x50-tou.jpg" />
        					<div class="vertical-Author-name vertical-hover">huhuf6我我我我我我我我我</div>
        					<div class="vertical-font-size vertical-hover"><label>字数:</label>28.7万我我我我我我我</div>
        					<div class="vertical-click-size vertical-hover"><label>点击:</label>49.5万我我我我我我</div>
        					<div class="vertical-collection-size vertical-hover"><label>收藏:</label>16万我我我我我我我我我</div>
        					<div class="vertical-a-reward vertical-hover"><label>打赏:</label>50000我s我s我s我s我s我s我s我s我s我s我s我s我</div>
        				</div>
        			</div>
        			<div class="vertical-title" title="夏日大作战夏日大作战夏日大作战">夏日大作战夏日大作战夏日大作战</div>
        		</li>
        		<li>
        			<div class="vertical-img">
        				<img src="img/150x210.jpg" class="cover"/>
        				<div class="vertical-img-line">
        					<img src="img/50x50-tou.jpg" />
        					<div class="vertical-Author-name vertical-hover">huhuf6我我我我我我我我我</div>
        					<div class="vertical-font-size vertical-hover"><label>字数:</label>28.7万我我我我我我我</div>
        					<div class="vertical-click-size vertical-hover"><label>点击:</label>49.5万我我我我我我</div>
        					<div class="vertical-collection-size vertical-hover"><label>收藏:</label>16万我我我我我我我我我</div>
        					<div class="vertical-a-reward vertical-hover"><label>打赏:</label>50000我s我s我s我s我s我s我s我s我s我s我s我s我</div>
        				</div>
        			</div>
        			<div class="vertical-title" title="夏日大作战夏日大作战夏日大作战">夏日大作战夏日大作战夏日大作战</div>
        		</li>
        		<li>
        			<div class="vertical-img">
        				<img src="img/150x210.jpg" class="cover"/>
        				<div class="vertical-img-line">
        					<img src="img/50x50-tou.jpg" />
        					<div class="vertical-Author-name vertical-hover">huhuf6我我我我我我我我我</div>
        					<div class="vertical-font-size vertical-hover"><label>字数:</label>28.7万我我我我我我我</div>
        					<div class="vertical-click-size vertical-hover"><label>点击:</label>49.5万我我我我我我</div>
        					<div class="vertical-collection-size vertical-hover"><label>收藏:</label>16万我我我我我我我我我</div>
        					<div class="vertical-a-reward vertical-hover"><label>打赏:</label>50000我s我s我s我s我s我s我s我s我s我s我s我s我</div>
        				</div>
        			</div>
        			<div class="vertical-title" title="夏日大作战夏日大作战夏日大作战">夏日大作战夏日大作战夏日大作战</div>
        		</li>
        	</ul>
        </li>
        	</ul>
        </li>
      </ul>
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
    </div>
    <iframe style="height: 240px;width: 100%;border: 0px;min-width:1200px;overflow: hidden;" src="${pageContext.servletContext.contextPath }/public/public-footer.html"></iframe>
  </body>
</html>
