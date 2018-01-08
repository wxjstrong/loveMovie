<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<META content="免费电影下载,电影下载,最新电影" name=keywords>
        <META content="电影下载网，分享最新电影，高清电影、综艺、动漫、电视剧等下载！" name=description>
		<title>爱电影</title>
		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
		<style type="text/css">
			*{
				margin: 0;
				padding:0;
				box-sizing: border-box;
			}
			html,body{
				/*border: solid 1px blue;*/
				height: 1550px;
				font-family: "微软雅黑";
				font-size:14px;
			}
			
			
			#all{
				border: solid 1px blue;
				height: 1550px;
				background-color: #1a2327;
				
			}
			
			#top{
				border: solid 1px green;
				height: 100px;
				/*float: left;*/
			}
			
			#assortment{
				border: solid 1px black;
				height: 25px;
				background-color:#183778 ;
				/*float: left;*/
			}
			
			
			#searchRow{
				border: solid 1px red;
				height: 60px;
				padding: 5px 5px -5px 5px;
			}
			#searchRow,#searchBox{
				border: solid 1px red;
				height: 50px;
			}
			
			#searchRow,#message{
				border: solid 1px red;
				height: 50px;
			}
			
			
			/*top区内容*/
			#logo{
				height: 100px;
			}
			#banner{
				border: solid 1px red;
				height: 100px;
			}
			/*导航分类区内容*/
			nav ul li{
				display: inline;	
				height: 20px;
			}
			
			nav ul li a{
				
				color: white;

				outline: none;
				text-align: center;
				/*text-shadow:honeydew;*/
				text-decoration: none;
				padding: 8px 8px;
				
			}
			
			/*nav ul li a:hover{
				color: #2a5f00;
			}*/
			/*主体区内容*/
			#recent_movie{
				
			}
			#classical_movie{
				
			}
			
			#CN_TV{
				
			}
			#foreign_TV{
				
			}
			
			#bigdata{
				
			}
			
			#java{
				
			}
			
			
			.row{
				margin-top: 5px;
			}
			
			/*主体区样式*/
			.panel{
				height:400px;
				border: solid 1px red;
				/*padding-left: 10px;
				padding-right: 10px;
				padding-top: 10px;
				padding-bottom: 10px;*/
				margin: 5px 0px 5px 0px;
			}
		   
		   
		   #copyright{
		   	height: 80px;
		   	border: solid 1px red;
		   text-align: center;
		   }
		   .panel-heading{
		   		overflow: hidden;
		   		padding: 4px 15px;
		   }
		</style>
	</head>
	
	
	<body>
		<div id="all" class="container">
			<div id="top" class="row" >
				<div id="logo" class="col-md-2" >
					<img src="img/loveMovieLogo.png"  alt="爱电影" width="100%"  height="98px" align="center"/>
					
				</div>
				<div id="banner" class="col-md-8">
					
				</div>
				
				<div id="login" class="col-md-2" align="center" >
					<span>
					  <a href="resignOrLogin/toLogin.do"  style="line-height: 100px;">登录</a>
					  <a href="resignOrLogin/toResign.do"  style="line-height: 100px;margin-left: 10px;">注册</a>
					</span>
				</div>
			</div>
			<div id="assortment" class="row">
				<nav class="nav-pills nav-justified" role="navigation">
					<ul>
						<li><a href="">最新电影</a></li>
						<li><a href="">经典影片</a></li>	
						<li><a href="">国内电影</a></li>	
						<li><a href="">欧美电影</a></li>	
						<li><a href="">其他电影</a></li>	
						<li><a href="">华语电视</a></li>
						<li><a href="">欧美电视</a></li>	
						<li><a href="">最新综艺</a></li>	
						<li><a href="">动漫资源</a></li>	
						<li><a href="">游戏资源</a></li>	
						<li><a href="">学习视频</a></li>
						<li><a href="">收藏本站</a></li>
						
					</ul>	
				</nav>
			</div>
			
			
			<div id="searchRow"   class="row">
				<div id="searchBox" class="col-md-6" >
					<form class="bs-example bs-example-form" role="form">
						<div class="col-md-8 input-group" style="margin-top: 4px;align-items:center;">
							<input type="text" class="form-control" placeholder="请输入字段名"/>
							<span class="input-group-btn">
								<button class="btn btn-info btn-search" type="button">搜索</button>	
								<button class="btn btn-info btn-search" type="button">高级搜索</button>
							</span>
						</div>
					
					</form>	
				</div>

				<div id="message" class="col-md-6" align="center" >
					<p style="margin-top: 5px;">
					<button type="button" class="btn btn-info col-md-4">联系站长</button>
					<button type="button" class="btn btn-info col-md-4" style="margin-left: 5px;">分享交流</button>
					</p>
				</div>
			</div>
			<div id ="movie" class="row">
				<div id="recent_movie" class="col-md-6 panel panel-info" >
					<div class="panel-heading">
						<h5 class="panel-title pull-left">最新电影</h5>
						<button class='pull-right' >more</button>
					</div>
					<div class="panle-body">
						电影信息
					</div>	
				</div>
				<div id="classical_movie" class="col-md-6 panel panel-info" >
					<div class="panel-heading">
						<h5 class="panel-title pull-left">经典影片</h5>
						<button class='pull-right' >more</button>
					</div>
					<div class="panle-body">
						电影信息
					</div>	
					
				</div>
			</div>
			
			<div id ="TV" class="row">
				<div id="CN_TV" class="col-md-6 panel panel-info" >
					<div class="panel-heading">
						<h5 class="panel-title pull-left">国产电视剧</h5>
						<button class='pull-right' >more</button>
					</div>
					<div class="panle-body">
						电影信息
					</div>	
					
				</div>
				<div id="foreign_TV" class="col-md-6 panel panel-info" >
					<div class="panel-heading">
						<h5 class="panel-title pull-left">海外电视剧</h5>
						<button class='pull-right' >more</button>
					</div>
					<div class="panle-body">
						电影信息
					</div>	
					
				</div>
			</div>
			
			<div id ="learn" class="row">
				<div id="bigdata" class="col-md-6 panel panel-info" >
					<div class="panel-heading">
						<h5 class="panel-title pull-left">大数据学习资料</h5>
						<button class='pull-right' >more</button>
					</div>
					<div class="panle-body">
						电影信息
					</div>	
					
				</div>
				<div id="java" class="col-md-6 panel panel-info" >
					<div class="panel-heading">
						<h5 class="panel-title pull-left">java学习资料</h5>
						<button class='pull-right' >more</button>
					</div>
					<div class="panle-body">
						电影信息
					</div>	
					
				</div>
			</div>
			
			<div id="copyright" class="row well well-small" style="	margin-bottom: 20px;">
				<p>Copyright @ 2017-2027 爱电影-www.dy2018.com.All Rights Reserved
				   <a href="#">联系站长 王叫瘦</a>
				</p>
				
				
			</div>
			
			
		</div>
		
	</body>
</html>
