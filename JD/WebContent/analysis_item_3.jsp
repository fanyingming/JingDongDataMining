<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Analysis_Item_1</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <style>
      body {
        padding-top: 50px;
        padding-bottom: 20px;
      }
    </style>
    <script type="text/javascript" src="js/jquery-1.10.2.min.js" ></script>
    <script src="js/highcharts.js"></script>
    <script src="js/exporting.js"></script>

        <script type="text/javascript">
$(function () {
        var arraythinkpad = [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6];
        var arraylenovo = [2.2, 2.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 5.5];
        var arraydell = [2.9, 2.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 6.0];
        var arrayacer = [2.3, 2.1, 3.1, 8.6, 12.5, 14.0, 17.3, 18.9, 12.3, 8.0, 3.9, 2.0];
        var arrayassus = [1.8, 1.9, 2.7, 8.2, 11.7, 13.0, 15.4, 17.9, 11.3, 8.4, 4.9, 3.0];
        var arrayhp = [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8];
        var arrayone = [1.7, 1.67, 3.2, 2.13, 1.66, 4.92, 0, 8.9, 11.2, 0, 17.9, 0, 5.1, 1, 7.6, 0, 5.7, 10.1, 0.2, 4, 0.5, 0, 0.3];
        var arraytwo = [1.7, 1.67, 3.2, 2.13, 0, 17.9, 0, 5.1, 1, 7.6, 1.66, 4.92, 0, 8.9, 11.2, 0, 5.7, 10.1, 0.2, 4, 0.5, 0, 0.2];
        var arraythree = [0, 17.9, 0, 5.1, 1, 7.6, 0, 5.7, 10.1, 0.2, 4, 0.5, 0, 1.7, 1.67, 3.2, 2.13, 1.66, 4.92, 0, 8.9, 11.2, 5];
        var arrayfour = [0, 17.9, 0, 0.2, 4, 0.5, 0, 1.7, 1.67, 3.2, 2.13, 1.66, 5.1, 1, 7.6, 0, 5.7, 10.1, 4.92, 0, 8.9, 11.2, 4];
        var arrayfive = [0, 17.9, 0, 0.2, 4, 0.5, 0, 1.7, 1, 7.6, 0, 5.7, 10.1, 4.92, 0, 1.67, 3.2, 2.13, 1.66, 5.1, 8.9, 11.2, 3];
        var arraysix = [10.1, 4.92, 0, 1.67, 3.2, 2.13, 1.66, 5.1, 8.9, 11.2, 0, 17.9, 0, 0.2, 4, 0.5, 0, 1.7, 1, 7.6, 0, 5.7, 2];
        $('#container').highcharts({
            title: {
                text: 'Different Price Range Sales Percent',
                x: -20 //center
            },
            subtitle: {
                text: 'Source: jingdong.com',
                x: -20
            },
            xAxis: {
                categories: ['三星', '海尔', 'Thinkpad', '东芝', '联想', 'Dell',
                    '苹果', '宏基', '富士通', '未来人类', 'Asus/华硕', '外星人', 
                    '清华同方', 'Gateway', '惠普', '雷蛇', '神舟', '七喜', 
                    '优派', '其他', '微星', '索尼', '技嘉']
            },
            yAxis: {
                title: {
                    text: 'Sales percent(%)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: ' %'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: '3000以下',
                data: [arrayone[0], arrayone[1], arrayone[2], arrayone[3], arrayone[4], arrayone[5], arrayone[6], arrayone[7], arrayone[8], arrayone[9], arrayone[10], arrayone[11], arrayone[12], arrayone[13], arrayone[14], arrayone[15], arrayone[16], arrayone[17], arrayone[18], arrayone[19], arrayone[20], arrayone[21], arrayone[22]]
            }, {
                name: '3000-5000',
                data: [arraytwo[0], arraytwo[1], arraytwo[2], arraytwo[3], arraytwo[4], arraytwo[5], arraytwo[6], arraytwo[7], arraytwo[8], arraytwo[9], arraytwo[10], arraytwo[11], arraytwo[12], arraytwo[13], arraytwo[14], arraytwo[15], arraytwo[16], arraytwo[17], arraytwo[18], arraytwo[19], arraytwo[20], arraytwo[21], arraytwo[22]]
            }, {
                name: '5000-8000',
                data: [arraythree[0], arraythree[1], arraythree[2], arraythree[3], arraythree[4], arraythree[5], arraythree[6], arraythree[7], arraythree[8], arraythree[9], arraythree[10], arraythree[11], arraythree[12], arraythree[13], arraythree[14], arraythree[15], arraythree[16], arraythree[17], arraythree[18], arraythree[19], arraythree[20], arraythree[21], arraythree[22]]
            }, {
                name: '8000-15000',
                data: [arrayfour[0], arrayfour[1], arrayfour[2], arrayfour[3], arrayfour[4], arrayfour[5], arrayfour[6], arrayfour[7], arrayfour[8], arrayfour[9], arrayfour[10], arrayfour[11], arrayfour[12], arrayfour[13], arrayfour[14], arrayfour[15], arrayfour[16], arrayfour[17], arrayfour[18], arrayfour[19], arrayfour[20], arrayfour[21], arrayfour[22]]
            }, {
                name: '15000-30000',
                data: [arrayfive[0], arrayfive[1], arrayfive[2], arrayfive[3], arrayfive[4], arrayfive[5], arrayfive[6], arrayfive[7], arrayfive[8], arrayfive[9], arrayfive[10], arrayfive[11], arrayfive[12], arrayfive[13], arrayfive[14], arrayfive[15], arrayfive[16], arrayfive[17], arrayfive[18], arrayfive[19], arrayfive[20], arrayfive[21], arrayfive[22]]
            }, {
                name: '30000以上',
                data: [arraysix[0], arraysix[1], arraysix[2], arraysix[3], arraysix[4], arraysix[5], arraysix[6], arraysix[7], arraysix[8], arraysix[9], arraysix[10], arraysix[11], arraysix[12], arraysix[13], arraysix[14], arraysix[15], arraysix[16], arraysix[17], arraysix[18], arraysix[19], arraysix[20], arraysix[21], arraysix[22]]
            }]
        });
    });

    </script>

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

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
                <li><a href="index.jsp">Home</a></li>
                <li class="dropdown active">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Analysis <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="statistics_base_brand_combo.jsp">All Brands Computer Sales Analysis Chart</a></li>
                    <li><a href="analysis_item_1.jsp">All Brands Computer Comments Analysis Chart</a></li>
                    <li><a href="analysis_item_2.jsp">Sales Percent Chart</a></li>
                    <li><a href="cpu_analysis_combo.jsp">CPU Analysis Chart</a></li>
                    <li><a href="size_analysis_combo.jsp">Size Analysis Chart</a></li>
                    <li><a href="analysis_item_3.jsp">Different Price Range Sales Percent</a></li>
                  </ul>
                </li>
                <li><a href="#about">About</a></li>
              </ul>
            </div>
          </div>
        </div>

      </div>
    </div>


    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Hello, visitor!</h1>
        <p>Here are the analysis result of computer sales in JD.com.</p>
        <p>Thanks for <a class="btn btn-primary" role="button" href="http://www.highcharts.com/">Highcharts</a></p>
      </div>
    </div>
    <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
    
    <div class="container">
      <!-- Example row of columns -->
      <!--
      <div class="row">
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
      </div>
      -->
      <hr>

      <footer>
        <p class="pull-right" style="position:relative;right:30px"><a class="btn btn-lg btn-primary" href="#" role="button" title="back to top">B</a></p>
        <p style="color:#333333;text-align:center;">&copy; 2013-2014 The 4th Group of Java Class</p>
      </footer>
    </div> <!-- /container -->



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="dist/js/bootstrap.min.js"></script>
    
  </body>
</html>
