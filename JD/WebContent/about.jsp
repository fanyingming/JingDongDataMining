<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="image/favicon.png">

    <title>Sales Analysis Home</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href="carousel.css" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body>
  

    <body>
    <div class="navbar-wrapper">
      <div class="container">

        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="index.jsp">JD Notebook Analysis</a>
            </div>
            <div class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="index.jsp">Home</a></li>
                <li><a href="crawl">Crawl</a></li>
                <li><a href="Analyse">Mining</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Analysis <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="ReadData?type=statistics_base_brand_combo">All Brands Computer Sales Analysis Chart</a></li>
                    <li><a href="ReadData?type=comment_analyse">All Brands Computer Comments Analysis Chart</a></li>
                    <li><a href="ReadData?type=sale_share">Sales Percent Chart</a></li>
                    <li><a href="ReadData?type=cpu_analysis_combo">CPU Analysis Chart</a></li>
                    <li><a href="ReadData?type=size_analysis_combo">Size Analysis Chart</a></li>
                    <li><a href="ReadData?type=price_range">Different Price Range Sales Percent</a></li>
                  </ul>
                </li>
                <li><a href="about.jsp">About Us</a></li>
              </ul>
            </div>
          </div>
        </div>

      </div>
    </div>


    <!-- Carousel
    ================================================== -->

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner">
        <div class="item active" style="background-image:url('image/06.jpg');background-repeat:no-repeat;background-position:center top">
          <!--<img data-src="holder.js/900x500/auto/#777:#7a7a7a/text:First slide" alt="First slide">-->
		   <object id="FlashID" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="100%" height="550">
            <param name="movie" value="swf/mi.swf">
            <param name="quality" value="high">
            <param name="wmode" value="transparent">
            <param name="swfversion" value="6.0.65.0">
            <!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
            <param name="expressinstall" value="Scripts/expressInstall.swf">
            <!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
            <!--[if !IE]>-->
            <object type="application/x-shockwave-flash" data="swf/mi.swf" width="100%" height="550">
              <!--<![endif]-->
              <param name="quality" value="high">
              <param name="wmode" value="transparent">
              <param name="swfversion" value="6.0.65.0">
              <param name="expressinstall" value="Scripts/expressInstall.swf">
              <!-- 浏览器将以下替代内容显示给使用 Flash Player 6.0 和更低版本的用户。 -->
              <div>
                <h4>此页面上的内容需要较新版本的 Adobe Flash Player。</h4>
                <p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="获取 Adobe Flash Player" /></a></p>
              </div>
              <!--[if !IE]>-->
            </object>
            <!--<![endif]-->
      </object>
          <div class="container">
            <div class="carousel-caption">
              
            </div>
          </div>
        </div>
        
    </div><!-- /.carousel -->


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <h1 style="color:#000000;text-align:center;font-size:60px">Members Introduction</h1>
		<h1 style="color:#000000;text-align:center;font-size:40px">We are a TEAM!</h1>
		<h1 class="row" align="center"  >
		<input type="text" id="text_1" value="" align="center" readonly="readonly" style="color:#000000;text-align:center;font-size:30px;BORDER-BOTTOM:   #000000   0px   solid; 
  BORDER-LEFT:   #000000   0px   solid;   
  BORDER-RIGHT:   #000000   0px   solid; 
    BORDER-TOP:   #000000   0px   solid; 

overflow-x:hidden; 
overflow-y:hidden; " >
		</h1>

				<h1 class="row" align="center"  >
		<input type="text" id="text_2" value="" align="center" readonly="readonly"  width="500px" style="color:#000000;text-align:center;font-size:25px;BORDER-BOTTOM:   #000000   0px   solid; 
  BORDER-LEFT:   #000000   0px   solid;   
  BORDER-RIGHT:   #000000   0px   solid; 
    BORDER-TOP:   #000000   0px   solid; 
 " >
		</h1>
      </div><!-- /.row -->

      <hr class="featurette-divider">


      <!-- FOOTER -->
      <footer>
        <p class="pull-right" style="position:relative;right:30px"><a class="btn btn-lg btn-primary" href="#" role="button" title="back to top">B</a></p>
        <p style="color:#333333;text-align:center;">&copy; 2013-2014 The 4th Group of Java Class</p>
      </footer>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
    <script src="js/holder.js"></script>
	<script language="javascript">
//有返回值的函数
function iHaveAReturnValue1(txt){
    return txt;
}
function iHaveAReturnValue2(txt){
    return txt;
}
function clickMeToSendTheValueToText(txt1,txt2){
    //把带返回值的函数"iHaveAReturnValue()"的返回值赋给输入框
    document.getElementById("text_1").value = iHaveAReturnValue1(txt1);
	document.getElementById("text_2").value = iHaveAReturnValue2(txt2);
}
</script>
  </body>
</html>
