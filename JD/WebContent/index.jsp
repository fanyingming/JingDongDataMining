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
              <a class="navbar-brand" href="index.jsp">Sales Analysis</a>
            </div>
            <div class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="index.jsp">Home</a></li>
                <li><a href="crawl">analyse</a></li>
                <li><a href="Analyse">analyse</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Analysis <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="ReadData?type=statistics_base_brand_combo">All Brands Computer Sales Analysis Chart</a></li>
                    <li><a href="analysis_item_1.jsp">All Brands Computer Comments Analysis Chart</a></li>
                    <li><a href="analysis_item_2.jsp">Sales Percent Chart</a></li>
                    <li><a href="ReadData?type=cpu_analysis_combo">CPU Analysis Chart</a></li>
                    <li><a href="ReadData?type=size_analysis_combo">Size Analysis Chart</a></li>
                    <li><a href="ReadData?type=price_range">Different Price Range Sales Percent</a></li>
                  </ul>
                </li>
                <li><a href="#about">About</a></li>
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
        <div class="item active" style="background-image:url('image/01-1.jpg');background-repeat:no-repeat;background-position:center top">
          <!--<img data-src="holder.js/900x500/auto/#777:#7a7a7a/text:First slide" alt="First slide">-->
          <div class="container">
            <div class="carousel-caption">
              <h1 class="pull-left" style="position:relative;bottom:100px;">Big Data Time</h1>
              <p class="pull-left" style="position:relative;bottom:50px;">In the era of big data, huge amouts of data make people feel confused. </p>
              <p class="pull-left" style="position:relative;bottom:50px;">Sales analysis system can help you understand sales data easy.</p>
            </div>
          </div>
        </div>
        <div class="item" style="background-image:url('image/02.jpg');background-repeat:no-repeat;background-position:center top">
          <div class="container">
            <div class="carousel-caption">
              <h1 class="pull-left" style="position:relative;bottom:150px;">Accurate analysis</h1>
              <p class="pull-left" style="position:relative;bottom:100px;">Accurate analysis and clear charts makes the results reliable and understandable.</p>
            </div>
          </div>
        </div>
        <div class="item" style="background-image:url('image/05.jpg');background-repeat:no-repeat;background-position:center top">
          <div class="container">
            <div class="carousel-caption">
              <h1  class="pull-left" style="position:relative;bottom:80px;">Let's begin</h1>
              <p  class="pull-left" style="position:relative;bottom:40px;">If you want to buy or sell something, sales analysis system is a good helper!</p>
              <p  class="pull-left" style="position:relative;bottom:10px;"><a class="btn btn-lg btn-primary" href="statistics_base_brand_combo.jsp" role="button">Use it now</a></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
    </div><!-- /.carousel -->


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <h1 style="color:#000000;text-align:center;font-size:60px">Welcome To Our Pages!</h1>
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
  </body>
</html>
