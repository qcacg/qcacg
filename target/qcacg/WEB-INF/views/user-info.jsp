<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		
		<title>用户中心 - 轻悦轻小说</title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/user-info/moe.css">
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/user-info/member.css">
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/user-info/user-info.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/user-info/wangEditor.min.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/css/cropper.min.css" />
		<script src="${pageContext.servletContext.contextPath }/user-info/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/cropper.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/user-info-A.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/user-info-H.js"></script>
	    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/user-info-B.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/css/main.css" />
	    <link rel="shortcut icon" href="http://www.qcacg.com/favicon.ico" type="image/x-icon" />

		 <style>
   img {
      max-width: 100%; /* This rule is very important, please do not ignore this! */
      
   } 
   img {
    vertical-align: middle;
   }
   #cropper-img {
     width: 100%;
     height: 400px;
   }
  </style>
		<script>
		 $(function(){
		  
		
  
		 })
		</script>
	</head>

	<body style="zoom: 1;">
	<%@ include file="public-header.jsp" %>
	 <div id="canvas"></div>
		<div id="content" style="min-height: 608px;" class="content">
			<div class="container">
				<div class="block-nav block">
					<div class="title-nav">用户中心</div>

					<div id="nav-member">
						<a href="javascript:;" class="item-nav user-nav active">
							<i class="fa icon-a fa-user-md"></i><span>个人信息</span>
							<i class="fa fa-angle-right icon-b"></i>
						</a>
						<a href="javascript:;" class="item-nav post-nav">
							<i class="fa icon-a fa-folder-open"></i><span>我的投稿</span>
							<i class="fa fa-angle-right icon-b"></i>
						</a>
							
							<a href="javascript:;" class="item-nav favor-nav">
								<i class="fa icon-a fa-bar-chart"></i><span>我的书架</span>
								<i class="fa fa-angle-right icon-b"></i>
							</a>

						<a href="javascript:;" class="item-nav follow-nav">
							<i class="fa icon-a fa-users"></i><span>我的关注</span>
							<i class="fa fa-angle-right icon-b"></i>
						</a>
						<a href="javascript:;" class="item-nav message-nav">
							<i class="fa icon-a fa-commenting-o"></i><span>我的消息</span>
							<i class="fa fa-angle-right icon-b"></i>
						</a>
							<a href="javascript:;" class="item-nav wallet-nav">
								<i class="fa icon-a fa-credit-card"></i><span>我的钱包</span>
								<i class="fa fa-angle-right icon-b"></i>
							</a>
						<a href="javascript:;" class="item-nav coin-nav">
							<i class="fa icon-a fa-lemon-o"></i><span>评论管理</span>
							<i class="fa fa-angle-right icon-b"></i>
						</a>
					<a href="javascript:;" class="item-nav gold-nav">
						<i class="fa icon-a fa-diamond"></i><span>我的活动</span>
						<i class="fa fa-angle-right icon-b"></i>
					</a>
					</div>
				</div>

				<div class="area-mainer">
					<div id="starlight-stage" class="wrap-mainer">
						<div class="js-stage active-user-info js-stage active">
							<div id="block-card-profile" class="block block-card-profile">
								<div class="avatar"><img src="${USER_SESSION_KEY.userHead}">
									<div class="mask-avatar"><i class="fa fa-edit"></i>
										<div class="edit-text">修改头像</div><input id="inputImage" type="file"  accept="image/gif,image/jpeg,image/png,image/jpg,image/bmp" class="ipt-file-avatar"></div>
							</div>
							<div class="info-user" style="margin-top: 20px;">
								<p class="info-top"><a href="javascript:;" class="name">
									<em>275120399</em>
									<i class="fa fa-venus"></i></a>
									<span class="uid"><em>uid：</em>209668</span>
									<span class="coin"><em>好人卡：</em>50</span>
							</p></div>
						</div>
						<div id="block-nav-profile" class="block block-nav-profile block-nav-stage">
					    <a data-target="content" class="tab active" id="user-info-A">基本信息</a>
						<a data-target="password" class="tab" id="user-passUpdata-A">修改密码</a></div>
						<div id="userInfo-A" class="block block-content-profile js-block-content js-block active">
							<form id="form-profile-a" class="form-member">
								<div class="row-m"><label class="label-m">昵称：</label>
									<p class="ipt-text-profile">275120399</p>
								</div>
								<div class="row-m"><label class="label-m">性别：</label>
									<div class="ipt-group">
										<div class="ipt-item"><input id="ipt-gender-a" type="radio" name="sex" value="1" class="magic-radio"><label for="ipt-gender-a">男</label></div>
										<div class="ipt-item"><input id="ipt-gender-b" type="radio" name="sex" value="2" class="magic-radio"><label for="ipt-gender-b">女</label></div>
									</div>
								</div>
								<div class="row-m"><label class="label-m">生日：</label>
									<div class="ipt-group">
										<div class="ipt-item"><select id="ipt-year-profile" onchange="window.renderBirth()"><option value="1970" selected="">1970年</option><option value="1971">1971年</option><option value="1972">1972年</option><option value="1973">1973年</option><option value="1974">1974年</option><option value="1975">1975年</option><option value="1976">1976年</option><option value="1977">1977年</option><option value="1978">1978年</option><option value="1979">1979年</option><option value="1980">1980年</option><option value="1981">1981年</option><option value="1982">1982年</option><option value="1983">1983年</option><option value="1984">1984年</option><option value="1985">1985年</option><option value="1986">1986年</option><option value="1987">1987年</option><option value="1988">1988年</option><option value="1989">1989年</option><option value="1990">1990年</option><option value="1991">1991年</option><option value="1992">1992年</option><option value="1993">1993年</option><option value="1994">1994年</option><option value="1995">1995年</option><option value="1996">1996年</option><option value="1997">1997年</option><option value="1998">1998年</option><option value="1999">1999年</option><option value="2000">2000年</option><option value="2001">2001年</option><option value="2002">2002年</option><option value="2003">2003年</option><option value="2004">2004年</option><option value="2005">2005年</option><option value="2006">2006年</option><option value="2007">2007年</option><option value="2008">2008年</option><option value="2009">2009年</option><option value="2010">2010年</option><option value="2011">2011年</option><option value="2012">2012年</option><option value="2013">2013年</option><option value="2014">2014年</option><option value="2015">2015年</option><option value="2016">2016年</option></select></div>
										<div class="ipt-item"><select id="ipt-month-profile" onchange="window.renderBirth()"><option value="1" selected="">1月</option><option value="2">2月</option><option value="3">3月</option><option value="4">4月</option><option value="5">5月</option><option value="6">6月</option><option value="7">7月</option><option value="8">8月</option><option value="9">9月</option><option value="10">10月</option><option value="11">11月</option><option value="12">12月</option></select></div>
									<div class="ipt-item"><select id="ipt-date-profile"><option value="1" selected="">1日</option><option value="2">2日</option><option value="3">3日</option><option value="4">4日</option><option value="5">5日</option><option value="6">6日</option><option value="7">7日</option><option value="8">8日</option><option value="9">9日</option><option value="10">10日</option><option value="11">11日</option><option value="12">12日</option><option value="13">13日</option><option value="14">14日</option><option value="15">15日</option><option value="16">16日</option><option value="17">17日</option><option value="18">18日</option><option value="19">19日</option><option value="20">20日</option><option value="21">21日</option><option value="22">22日</option><option value="23">23日</option><option value="24">24日</option><option value="25">25日</option><option value="26">26日</option><option value="27">27日</option><option value="28">28日</option><option value="29">29日</option><option value="30">30日</option><option value="31">31日</option></select></div>
						</div>
					</div>
					<div class="row-m"><label class="label-m">手机号码：</label>
						<p class="ipt-text-profile">******1605</p>
					</div>
					<div class="row-m"><label class="label-m"></label>
						<div class="ipt-group"><button id="btn-save-profile" type="submit" class="btn btn-primary btn-sm btn-wide">保存</button></div>
					</div>
					</form>
				</div>
				<div id="userPassUpdata-A" class="block js-block-password js-block">
					<p>目前只支持使用客户端修改密码。<a href="javascript:;" target="_blank">立即下载</a></p>
				</div>
				<div id="modal-signature-profile" class="modal fade modal-post">
					<div class="modal-dialog modal-sm"><button data-dismiss="modal" class="close"><i class="fa fa-remove"></i></button>
						<form id="form-signature-profile" class="modal-content">
							<div class="modal-body">
								<p class="text-center">请输入新的签名</p><input id="ipt-signature-profile" placeholder="签名" maxlength="33" autocomplete="off" class="form-control input-sm"></div>
							<div class="modal-footer text-center"><button id="btn-signature-profile" type="submit" class="btn-primary btn-sm btn btn-wide">提交</button></div>
						</form>
					</div>
				</div>
				
				
				<!-- style="display: block; padding-right: 17px;"  -->
				<div id="modal-avatar-profile" class="modal fade modal-post" >
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-body">
							 <img id="cropper-img"></div>
							<div class="modal-footer text-center">
							 <button id="btn-avatar-profile" class="btn-primary btn-sm btn btn-wide">上传</button>
							 <button data-dismiss="modal" class="btn-default btn-sm btn btn-wide">取消</button>
							</div>
						</div>
					</div>
				</div>
				
				
				
			</div>
			<div class="js-stage active-user js-stage">
				<div id="book-list-post" class="js-block block block-booklist active">
					<div class="area-title-block"><span class="prev"></span><span class="title">作品列表</span><span class="next">
						<a href="javascript:;" class="btn btn-default btn-sm"><i class="fa fa-edit"></i>创建</a></span></div>
					<div class="js-block-main book-list">
						<div class="clearfix">
							<a href="javascript:;" class="item add-book">
								<div class="thumb" id="thumb">
									<div class="cover"><i class="fa fa-plus"></i></div>
								</div>
							</a>
							<div class="item" id="item-thumb">
								<div class="thumb-wrap">
								<a href="javascript:;" class="thumb">
									<img src="${bookEntity.bookCoverImage}" srcset="${bookEntity.bookCoverImage}" data-sizes="128px" class="cover"><span class="tag-a status status-0">草稿</span></a><span class="count tag-a">0 字</span><span class="tag-a channel channel-10">少年</span><span class="tag-b view">点击：0</span><span class="tag-b coin">轻石：0</span><span class="tag-b follow">收藏：0</span></div>
										<a href="javascript:;" class="title">
										${bookEntity.bookName}</a>
							</div>
						</div>
						<ul class="pagination"></ul>
					</div>
				</div>
				<div class="js-block block block-bookinfo">
					<div id="title-post-info" class="area-title-block">
						<a href="http://121.196.194.211/user-info.shtml#/post/list" class="prev"><i class="fa fa-angle-left"></i></a> 
						<a class="title">创建作品</a> 
						<span class="next">
							<a class="btn btn-sm btn-link js-btn-create hide">下一步</a>
						</span>
					</div>
					<div class="book-info-post js-book-info js-book">
						<%--<form id="form-book-info" class="form-member" action="/book/saveOrUpdateBook.shtml">--%>
							<div class="row-m" ><label for="ipt-title-post-info" class="label-m"  >标题：</label>
								<div class="ipt-group" ><input id="ipt-title-post-info" placeholder="64个字符以内" required="" maxlength="64" autocomplete="off" spellcheck="false" class="form-control input-sm" name="bookName" value="${bookEntity.bookName}"></div>
							</div>
							<div class="row-m"><label for="ipt-intro-post-info" class="label-m label-top">简介：</label>
								<div class="ipt-group"><textarea id="ipt-intro-post-info" placeholder="300个字符以内" required="" maxlength="300" spellcheck="false" class="form-control input-sm" name="bookIntroduction" >${bookEntity.bookIntroduction}</textarea></div>
							</div>
							<div class="row-m"><label class="label-m" >分区：</label>
								<div class="ipt-group" >
									<div class="ipt-item"><input id="ipt-channel-a" type="radio" name="channel" value="10" checked="checked" class="magic-radio"><label for="ipt-channel-a" >少年</label></div>
									<div class="ipt-item"><input id="ipt-channel-b" type="radio" name="channel" value="11" class="magic-radio"><label for="ipt-channel-b" >少女</label></div>
								</div>
							</div>
							<div class="row-m"><label class="label-m">分类：</label>
								<div class="ipt-group"><input id="ipt-cat-post-info" class="hide"><span id="area-cat-info" class="text-primary"></span>
									<div class="area-cat-btn"><a id="btn-choose-cat" class="btn btn-sm btn-default">选择分类</a>
										<div id="block-cat-list" class="cat-list-post">
											<div class="btn-block clearfix"></div>
											<div class="bottom-block"><a data-type="submit" class="btn btn-wide btn-xs btn-primary">确定</a></div>
										</div>
									</div>
								</div>
							</div>
							<div class="row-m hide"><img src="${bookEntity.bookCoverImage}"><label class="label-m">封面：</label>
								<div class="ipt-group"><input id="ipt-cover-post-info" name="bookCoverImage" class="form-control input-sm" value="${bookEntity.bookCoverImage}"></div>
							</div>
							<div class="row-m"><label class="label-m"></label>
								<div class="ipt-group"><button id="btn-info-book" type="submit" class="btn btn-primary btn-sm btn-wide">保存</button></div>
							</div>
						<%--</form>--%>
						<div class="area-post-notice">
							<blockquote>
								<h4>注意事项：</h4>
								<ol>
									<li>请慎重填写书名，选择作品分类，一旦提交将不可修改创建书籍亦不可删除。</li>
									<li>作品封面请选用大尺寸高清的ACG风格图片，本站拒绝三次元封面或与轻小说感觉严重不符的封面。请勿使用违规图片，违规者将被处罚。</li>
									<li>书名请勿使用侮辱性词汇。</li>
									<li>本站只接受原创作品，投稿人将默认为作品的作者。</li>
									<li>请勿恶意无聊刷稿，违规者将被处罚。</li>
								</ol>
							</blockquote>
						</div>
						<div id="area-cover-upload" class="area-cover-upload">
							<div class="cover-wrap active">
								<div id="img-cover-post" class="img-wrap"></div><a id="btn-choose-cover" class="btn btn-default btn-block btn-sm">选择封面<input id="ipt-cover-post" type="file" accept="image/gif,image/jpeg,image/png,image/jpg,image/bmp" class="ipt-file-cover"></a></div>
							<div class="cropper-wrap">
								<div class="cropper-img-wrap"><img id="img-cropper-post"></div>
								<div class="area-btn"><a id="btn-cover-upload" class="btn-xs btn-success btn btn-wide">上传</a><a id="btn-crop-cancle" class="btn-xs btn-default btn btn-wide">取消</a></div>
							</div>
						</div>
					</div>
					<div class="book-content-post js-book-content js-book">
						<div class="area-tool-top">
						<a id="btn-add-vol" data-toggle="modal" data-target="#modal-add-vol" class="btn btn-sm btn-default btn-wide">
							<i class="fa fa-plus"></i>新增卷</a>
							<a id="btn-book-apply" class="btn-sm btn btn-primary btn-wide">提交审核</a>
							<a id="btn-show-cptcount" class="btn-sm btn btn-default btn-wide">章节字数</a>
						</div>
						<div id="menu-list-post" class="volume-list">
							<div data-id="40111" data-name="重生" data-order="2" class="volume panel panel-default"><div class="panel-heading"><span>重生</span><span class="count-vol">（0 字）</span><div class="tools-title pull-right"><span data-type="back" class="btn-vol js-btn-order-vol"><i class="fa fa-angle-up"></i>上移</span><span data-type="forward" class="btn-vol js-btn-order-vol"><i class="fa fa-angle-down"></i>下移</span><span class="btn-vol js-btn-rename-vol"><i class="fa fa-edit"></i>重命名</span><span class="btn-vol js-btn-remove-vol"><i class="fa fa-remove"></i>删除</span></div></div><div class="chapter-list panel-body"><div class="chapter"><div class="chpt-m">
								<a href="javascript:;" class="btn btn-add-chapter btn-sm btn-default"><i class="fa fa-plus"></i>新增章</a></div></div></div></div>
							<div data-id="40112" data-name="都市" data-order="3" class="volume panel panel-default"><div class="panel-heading"><span>都市</span><span class="count-vol">（0 字）</span><div class="tools-title pull-right"><span data-type="back" class="btn-vol js-btn-order-vol"><i class="fa fa-angle-up"></i>上移</span><span data-type="forward" class="btn-vol js-btn-order-vol"><i class="fa fa-angle-down"></i>下移</span><span class="btn-vol js-btn-rename-vol"><i class="fa fa-edit"></i>重命名</span><span class="btn-vol js-btn-remove-vol"><i class="fa fa-remove"></i>删除</span></div></div><div class="chapter-list panel-body"><div class="chapter"><div class="chpt-m">
								<a href="javascript:;" class="btn btn-add-chapter btn-sm btn-default"><i class="fa fa-plus"></i>新增章</a></div></div></div></div>
						</div>
				</div>
			</div>
			<div class="js-block block block-bookcontent">
				<div class="area-title-block"><span onclick="history.back()" class="prev"><i class="fa fa-angle-left"></i></span><span class="title">章节</span><span class="next"></span></div>
				<%--<form id="form-content-post" class="form-member form-chapter">--%>
					<div id="area-title-content" class="row-m" ><label for="ipt-chapter-post" class="label-m" >标题：</label>
						<div class="ipt-group" ><input id="ipt-chapter-post" required="" maxlength="64" autocomplete="off" placeholder="请输入章名" class="form-control input-sm" name="chapterName" value="${contentEntity.contentTitle}"></div>
					</div>
					<div class="row-m"><label for="ipt-content-post" class="label-m label-top" >正文：</label>
						<div class="ipt-group" style="height:400px">
							<textarea id="ipt-content-post" required="" spellcheck="false" placeholder="${contentEntity.content}" class="form-control input-sm" style="display: none;">

							</textarea>
						</div>
					</div>
					<div class="row-m"><label class="label-m"></label>
						<div class="ipt-group text-center relative">
							<div id="text-count-post" class="count-content"></div><button id="btn-content-post" class="btn btn-sm btn-primary btn-wide">保存</button><a id="link-restore-edit" class="btn btn-link link-restore">恢复上次编辑的内容</a></div>
					</div>
				<%--</form>--%>
			</div>
			<!-- 新增卷   加入style="display: block; padding-right: 17px;"  class加入 in-->
			<div id="modal-add-vol" class="modal fade modal-post">
				<div class="modal-dialog modal-sm">
					<button data-dismiss="modal" class="close"><i class="fa fa-remove"></i></button>
					<%--<form id="form-add-vol" class="modal-content">--%>
						<div class="modal-body">
							<p class="text-center">请输入卷的标题</p><input id="ipt-title-volume" placeholder="${volumeEntity.volumeName}" required="" maxlength="64" autocomplete="off" class="form-control input-sm"></div>
						<div class="modal-footer text-center"><button id="btn-add-vol-submit" type="submit" class="btn-primary btn-sm btn btn-wide">提交</button></div>
					<%--</form>--%>
				</div>
			</div>
			<div id="modal-book-apply" class="modal fade modal-post">
				<div class="modal-dialog modal-sm"><button data-dismiss="modal" class="close"><i class="fa fa-remove"></i></button>
					<form id="form-book-apply" class="modal-content">
						<div class="modal-body">
							<p class="text-center">想对编辑说的话，没有可以不填</p><textarea id="ipt-msg-book" placeholder="备注" autocomplete="off" class="form-control input-sm"></textarea></div>
						<div class="modal-footer text-center"><button id="btn-book-apply-submit" type="submit" class="btn-primary btn-sm btn btn-wide">提交</button></div>
					</form>
				</div>
			</div>
			<div id="modal-rename-vol" class="modal fade modal-post">
				<div class="modal-dialog modal-sm"><button data-dismiss="modal" class="close"><i class="fa fa-remove"></i></button>
					<%--<form id="form-rename-vol" class="modal-content">--%>
						<div class="modal-body">
							<p class="text-center">请输入卷的标题</p><input id="ipt-title-rename-volume" placeholder="卷标题" required="" maxlength="64" autocomplete="off" class="form-control input-sm"></div>
						<div class="modal-footer text-center"><button id="btn-rename-vol-submit" type="submit" class="btn-primary btn-sm btn btn-wide">提交</button></div>
					<%--</form>--%>
				</div>
			</div>
			<div id="modal-rename-cpt" class="modal fade modal-post">
				<div class="modal-dialog modal-sm"><button data-dismiss="modal" class="close"><i class="fa fa-remove"></i></button>
					<form id="form-rename-cpt" class="modal-content">
						<div class="modal-body">
							<p class="text-center">修改章信息</p>
							<div class="form-member">
								<div class="row-m"><label class="label-m">标题：</label>
									<div class="ipt-group"><input id="ipt-title-rename-chapter" placeholder="章标题" required="" maxlength="64" autocomplete="off" class="form-control input-sm"></div>
								</div>
								<div class="row-m"><label class="label-m">序号：</label>
									<div class="ipt-group"><input id="ipt-order-rename-chapter" type="number" placeholder="序号" required="" min="1" max="10000" class="form-control input-sm"></div>
								</div>
							</div>
							<p class="text-center hint-modal">序号会影响章节的顺序，越小越靠前</p>
						</div>
						<div class="modal-footer text-center"><button id="btn-rename-cpt-submit" type="submit" class="btn-primary btn-sm btn btn-wide">提交</button></div>
					</form>
				</div>
			</div>
		</div>
		<div class="js-stage active-favor js-stage">
			<div id="block-nav-favor" class="block block-nav-favor block-nav-stage">
				<a  id="Collection-A" class="tab tab-star active">我的收藏</a>
				<a  id="History-A" class="tab tab-history">历史记录</a></div>
			
			<div id="CollectionViewA" class="block block-star-favor js-block active">
				<div id="list-star-favor" class="book-list clearfix">
					<p class="alert alert-info">没有找到任何数据。</p>
					<ul class="pagination"></ul>
				</div>
			</div>
			
			<div id="HistoryViewA" class="block block-history-favor js-block">
				<div id="list-history-favor" class="book-list clearfix">
					<div class="item">
						<a href="/book/3596/" target="_blank" class="thumb">
						<img src="//image.iqing.in/cover/beaea609-6b54-4625-bec7-a10059cc780d.jpg?imageView2/1/w/128/h/171/format/jpg/interlace/1/q/86" srcset="//image.iqing.in/cover/beaea609-6b54-4625-bec7-a10059cc780d.jpg?imageView2/1/w/128/h/171/format/jpg/interlace/1/q/86 128w, //image.iqing.in/cover/beaea609-6b54-4625-bec7-a10059cc780d.jpg?imageView2/1/w/256/h/342/format/jpg/interlace/1/q/86 256w" data-sizes="128px" class="cover"></a>
						<a href="/book/3596/" target="_blank" class="title">Error Code错误代码</a>
					</div> 
					<ul class="pagination">
					</ul>
				</div>
			</div>
			
		</div>
		<div class="js-stage active-follow js-stage">
			<div id="block-nav-follow" class="block block-nav-follow block-nav-stage">
				<a id="I-follow"  class="tab tab-star active">我关注的</a>
				<a id="follow-I"  class="tab tab-fan">关注我的</a></div>
			
			<div id="I-followView" class="block block-star-follow js-block active">
			 <div id="list-star-follow" class="list-follow">
			  <div class="item">
			   <a href="/u/119795" class="thumb">
			    <img src="//image.iqing.in/avatar/119795/70c6d126-b81f-47df-8898-dfb6ee7f130a.jpg-avatarSmall" class="avatar"></a>
			    <div class="info-user">
			     <a href="/u/119795" class="name">东野壹祈<i class="fa fa-mars"></i></a>
			     <p class="desc"></p></div></div><div class="item"><a href="/u/133708" class="thumb">
			      <img src="//image.iqing.in/avatar/133708/d730a89e-a8d6-4ec1-9de6-4f7951923889.png-avatarSmall" class="avatar"></a>
			      <div class="info-user"><a href="/u/133708" class="name">一宫数美<i class="fa fa-mars"></i></a><p class="desc">还记得，第一次，借钱买下狮鹫兽</p></div></div>
			      <div class="item"><a href="/u/199160" class="thumb">
			       <img src="//image.iqing.in/avatar/199160/e667eb86-8002-47f2-9bca-ceed764189b3.png-avatarSmall" class="avatar"></a>
			       <div class="info-user"><a href="/u/199160" class="name">维多利亚酱<i class="fa fa-mars"></i></a><p class="desc">作者，是最孤独的那群人</p></div></div> 
			       <ul class="pagination"></ul>
			  </div>
			 </div>
			 
			 <div id="follow-Iview" class="block block-fan-follow js-block">
			  <div id="list-fan-follow" class="list-follow">
			   <p class="alert alert-warning">没有找到任何数据。</p><ul class="pagination"></ul>
			  </div>
			 </div>
		
		</div>
		
		
		
		<div class="js-stage active-message js-stage">
			<div id="block-nav-message" class="block block-nav-message block-nav-stage">
				<a href="javascript:;" class="tab tab-reply active">回复我的</a>
				<a href="javascript:;" class="tab tab-at">@我的</a>
				<a href="javascript:;" class="tab tab-book">作品相关</a>
				<a href="javascript:;" class="tab tab-system">系统消息</a>
				<a href="javascript:;" class="tab tab-notice">官方公告</a></div>
			<div class="block block-reply-message js-block active">
				<div id="list-reply-message" class="message-list clearfix">
					<p class="not-found">没能找到任何相关消息</p>
					<ul class="pagination"></ul>
				</div>
			</div>
			<div class="block block-at-message js-block">
				<div id="list-at-message" class="message-list clearfix"></div>
			</div>
			<div class="block block-book-message js-block">
				<div id="list-book-message" class="message-list clearfix"></div>
			</div>
			<div class="block block-system-message js-block">
				<div id="list-system-message" class="message-list clearfix"></div>
			</div>
			<div class="block block-notice-message js-block">
				<div id="list-notice-message" class="message-list clearfix"></div>
			</div>
		</div>
		<div class="js-stage active-wallet js-stage">
			
			<div id="block-nav-wallet" class="block block-nav-wallet block-nav-stage">
				<a href="javascript:;" id="qianbao-H" class="tab tab-index active">我的钱包</a>
				<a href="javascript:;" id="zhangdan-H" class="tab tab-bill">收支账单</a></div>
				
			<div id="qianBaoView-H" class="block block-index-wallet js-block active">
				<div id="list-index-wallet" class="list-wallet">
					<div class="area-over-wallet area-wallet">
						<p class="title">可用余额</p>
						<div class="detail-info clearfix">
							<p class="count"><span class="m">￥</span><span class="a">0.</span><span class="b">00</span></p><button data-target="#modal-withdraw-wallet" data-toggle="modal" class="btn btn-primary btn-wide btn-md">提现</button></div>
					</div>
					<div class="area-history-wallet area-wallet">
						<p class="title">历史收入</p>
						<div class="detail-info clearfix">
							<p class="count"><span class="m">￥</span><span class="a">0.</span><span class="b">00</span></p>
							<a href="javascript:;" class="btn btn-link">查看账单</a></div>
					</div>
					<div class="area-hint">
						<p>提现说明：</p>
						<p class="hint-wallet">1.提现申请成功提交后不可撤回</p>
						<p class="hint-wallet">2.提现金额为100的整数倍（单位人民币）</p>
						<p class="hint-wallet">3.申请成功提交后，工作人员会在30个工作日内将相应金额打入指定账户</p>
					</div>
				</div>
			</div>
			
			<div id="zhangDanView-H" class="block block-bill-wallet js-block">
			 <div id="list-bill-wallet" class="list-wallet">
			  <p class="title">钱包明细</p>
			  <div class="detail-bill">
			   <p class="detail-block">
			    <span class="t">可用余额：</span>
			    <span class="m">￥</span>
			    <span class="a">0.</span>
			    <span class="b">00</span>
			   </p>
			   <p class="detail-block">
			    <span class="t">总收入：</span>
			    <span class="m">￥</span>
			    <span class="a">0.</span>
			    <span class="b">00</span>
			   </p>
			  </div>
			  <table class="table-bill">
			   <thead>
			    <tr>
			     <th style="width:25%">日期</th>
			     <th style="width:20%">收入（元）</th>
			     <th style="width:20%">支出（元）</th>
			     <th style="width:35%">详情</th>
			    </tr>
			   </thead>
			   <tbody></tbody>
			  </table>
			  <ul class="pagination"></ul>
			 </div>
			</div>
			
			
			<div id="modal-withdraw-wallet" class="modal fade modal-wallet">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header"><button data-dismiss="modal" class="close"><i class="fa fa-close"></i></button>
							<h4 class="modal-title">登记支付信息</h4></div>
						<div class="modal-body">
							<div class="js-block-withdraw-wallet hide">
								<div class="form-member">
									<div class="row-m"><label class="label-m">可用余额：</label>
										<div class="ipt-group count js-count-wallet"></div>
									</div>
									<div class="row-m"><label class="label-m">提取金额：</label>
										<div class="ipt-group you"><a class="btn btn-default btn-sm first js-btn-minus-wallet"><i class="fa fa-minus"></i></a><span class="no js-no-wallet">0</span><a class="btn btn-default btn-sm last js-btn-plus-wallet"><i class="fa fa-plus"></i></a><span class="unit">元</span></div>
									</div>
									<div class="row-m"><label class="label-m"></label>
										<div class="ipt-group">
											<p class="hint">提取金额需为￥100的整倍。</p>
											<p class="hint">如果需要重新登记支付信息，请联系编辑。</p>
										</div>
									</div>
								</div>
							</div>
							<div class="js-block-userinfo-wallet">
								<div class="form-member">
									<div class="row-m"><label class="label-m">真实姓名：</label>
										<div class="ipt-group"><input id="ipt-realname-wallet" placeholder="必填" required="" class="form-control"></div>
									</div>
									<div class="row-m"><label class="label-m">支付宝账号：</label>
										<div class="ipt-group"><input id="ipt-alipay-wallet" placeholder="请输入支付宝账号" required="" class="form-control"></div>
									</div>
									<div class="row-m"><label class="label-m">确认支付宝账号：</label>
										<div class="ipt-group"><input id="ipt-alipay2-wallet" placeholder="请再次输入支付宝账号" required="" class="form-control"></div>
									</div>
								</div>
								<p class="hint mg-top">注意：支付信息提交后将无法直接修改，请仔细检查个人信息。确认填写无误后再提交。</p>
							</div>
							<div class="js-block-success-wallet hide">
								<div class="area-success-wallet clearfix">
									<div class="bg-success"></div>
									<div class="info-success">
										<p class="a js-text-success-wallet"></p>
										<p class="b">工作人员会在30个工作日之内发放对应金额到登记的账户。</p>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer text-center"><button id="btn-withdraw-wallet" class="btn-primary btn-sm btn btn-wide">确定</button><button data-dismiss="modal" class="btn-default btn-sm btn btn-wide">关闭</button></div>
					</div>
				</div>
			</div>
		</div>
		<div class="js-stage active-coin js-stage">
			<div class="block block-index-coin">
				<p>我的轻石</p>
				<p id="text-count-coin" class="count">50</p>
			</div>
			<div class="block block-bill-coin">
				<div id="list-bill-coin" class="list-coin">
					<table class="table-bill">
						<thead>
							<tr>
								<th style="width:25%">日期</th>
								<th style="width:50%">明细</th>
								<th style="width:25%">收支</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>2016-6-22 22:18:16</td>
								<td>注册礼包</td>
								<td class="td-b">50</td>
							</tr>
						</tbody>
					</table>
					<ul class="pagination"></ul>
				</div>
			</div>
		</div>
		<div class="js-stage active-gold js-stage">
			<div class="block block-index-gold">
				<p>我的重石</p>
				<p><span id="text-count-gold" class="count">0</span><a id="btn-appmodal-gold" class="btn btn-primary btn-sm btn-wide">充值</a></p>
			</div>
			<div class="block block-bill-gold">
				<div id="list-bill-gold" class="list-gold">
					<table class="table-bill">
						<thead>
							<tr>
								<th style="width:25%">日期</th>
								<th style="width:50%">明细</th>
								<th style="width:25%">收支</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
					<ul class="pagination"></ul>
				</div>
			</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		<div></div>
		<div class="modal-backdrop fade in" style="display:none" id="heimu"></div>
	<%@ include file="public-footer.jsp" %>

	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/user-info/wangEditor.min.js"></script>
	<script type="text/javascript">

			var textarea = document.getElementById('ipt-content-post');
			var editor = new wangEditor(textarea);
			editor.config.uploadImgUrl = '/content/upload.shtml';

			editor.config.emotions = {
				'default': {
					title: '轻悦娘',
					data: [
						{
							'icon': 'http://127.0.0.1:8080/img/不明所以然.jpg',
							'value': '[不明所以然]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/伤心欲绝.jpg',
							'value': '[伤心欲绝]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/发呆.jpg',
							'value': '[发呆]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/吃惊.jpg',
							'value': '[吃惊]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/哭泣.jpg',
							'value': '[哭泣]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/害羞.jpg',
							'value': '[害羞]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/就是那个.jpg',
							'value': '[就是那个]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/微笑.jpg',
							'value': '[微笑]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/恼怒.jpg',
							'value': '[恼怒]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/悲伤.jpg',
							'value': '[悲伤]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/战斗力渣渣.jpg',
							'value': '[战斗力渣渣]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/抛媚眼.jpg',
							'value': '[抛媚眼]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/早就看穿一切.jpg',
							'value': '[早就看穿一切]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/汗.jpg',
							'value': '[汗]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/菜刀.jpg',
							'value': '[菜刀]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/那个有没有.jpg',
							'value': '[那个有没有]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/震惊.jpg',
							'value': '[震惊]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/高兴.jpg',
							'value': '[高兴]'
						},
						{
							'icon': 'http://127.0.0.1:8080/img/默默地看着.jpg',
							'value': '[默默地看着]'
						}
					]
				}

			};
			editor.create();

	</script>
<script>
	$(function(){
		$('.item-nav').on('click',function(){
			$('.item-nav').each(function(){
			  $(this).removeClass('active');
			});
			$(this).addClass('active');
		});
		
		$('.user-nav').on('click',function(){
			$('.js-stage').each(function(){
			  $(this).removeClass('active');
			});
			 $('.active-user-info').addClass('active');
			/*
			 获取用户信息
			 */
			$.ajax('/user/queryUser.shtml', {
				type: "GET",
				cache: false,
				dataType: "json",
				success: function () {

					console.log('queryUser success');
				},
				error: function () {
					console.log('queryUser error');
				}
			});

		});
		
		$('.post-nav').on('click',function(){
			 $('.js-stage').each(function(){
			  $(this).removeClass('active');
			});
			 $('.active-user').addClass('active');
			/*
			 获取作品列表
			 */
			$.ajax('/book/findBookByUser.shtml', {
				type: "GET",
				cache: false,
				dataType: "json",

				success: function (bookEntity) {
					$('#item-thumb').each(function(e){
						$(this).html(bookEntity.bookName);
						$(this).html(bookEntity.bookCoverImage);
					})


					console.log('findBookByUser success');
				},
				error: function () {
					console.log('findBookByUser error');
				}
			});

		});
		$('.favor-nav').on('click',function(){
			 $('.js-stage').each(function(){
			  $(this).removeClass('active');

			});
			 $('.active-favor').addClass('active');
			/*
			 获取用户收藏
			 */
			$.ajax('/bookCollect/findBookCollectByUser.shtml', {
				type: "GET",
				data: {},
				dataType: "json",
				success: function () {
					console.log('findBookCollectByUser success');
				},
				error: function () {
					console.log('findBookCollectByUser error');
				}
			});
			/*
			 获取用户浏览
			 */
			$.ajax('/bookHit/findBookHitByUser.shtml', {
				type: "GET",
				data: {},
				dataType: "json",
				success: function () {
					console.log('findBookHitByUser success');
				},
				error: function () {
					console.log('findBookHitByUser error');
				}
			});
		});
		$('.follow-nav').on('click',function(){
			 $('.js-stage').each(function(){
			  $(this).removeClass('active');
			});
			 $('.active-follow').addClass('active');
		});
		$('.message-nav').on('click',function(){
			 $('.js-stage').each(function(){
			  $(this).removeClass('active');
			});
			 $('.active-message').addClass('active');
		});
		$('.wallet-nav').on('click',function(){
			 $('.js-stage').each(function(){
			  $(this).removeClass('active');
			});
			 $('.active-wallet').addClass('active');
		});
		$('.coin-nav').on('click',function(){
			 $('.js-stage').each(function(){
			  $(this).removeClass('active');
			});
			 $('.active-coin').addClass('active');
		});
		$('.gold-nav').on('click',function(){
			 $('.js-stage').each(function(){
			  $(this).removeClass('active');
			});
			 $('.active-gold').addClass('active');
		});
		
		$('#thumb').on('click',function(){
			 $('.block-booklist').removeClass('active');
			 $('.block-bookinfo').addClass('active');
			 $('.js-book-info').addClass('active');
		});
		// js-book-content item-thumb
		$('#item-thumb').on('click',function(){
			 $('.block-booklist').removeClass('active');
			 $('.block-bookinfo').addClass('active');
			 $('.js-book-content').addClass('active');
		});
		$('#btn-add-vol').on('click',function(){
			 $('#modal-add-vol').addClass('in');
			 $('#modal-add-vol').attr('style','display: block; padding-right: 17px;');
			 $("#heimu").attr("style","");
		});
		
		$('.chpt-m').on('click',function(){
			 $('.block-bookinfo').removeClass('active');
			 $('.block-bookcontent').addClass('active');
		});

		
	})
</script>

<script type="text/javascript" src="${pageContext.servletContext.contextPath }/user-info/highlight.min.js"></script></body></html>