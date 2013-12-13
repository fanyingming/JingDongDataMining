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
        var price = [5383,3112,6948,5313,4047,5102,10391,4362,6619,17434,4151,22465,4586,3665,5269,18999,5420,2067,2499,7162,11794,5899,5199];
        var num = [1307,2744,23378,5375,21739,11276,5248,13516,1689,714,31603,132,2014,50,22268,191,8576,819,45,1081,2196,6473,151];
        var eval = [89.06,90.2,91.97,89.04,91.52,89.8,96.57,90.35,91.77,92.99,91.45,93.94,90.76,90,91.07,92.67,88.20,82.66,82.22,91.21,92.03,90.33,90.07];
        $('#container').highcharts({
            chart: {
                zoomType: 'xy'
            },
            title: {
                text: 'All Brands Computer Sales Analysis Chart'
            },
            subtitle: {
                text: 'Source: Jingdong.com'
            },
            xAxis: [{
                categories: ['三星', '海尔', 'Thinkpad', '东芝', '联想', 'Dell',
                    '苹果', '宏基', '富士通', '未来人类', '华硕', '外星人', 
                    '清华同方', 'Gateway', '惠普', '雷蛇', '神舟', '七喜', 
                    '优派', '其他', '微星', '索尼', '技嘉']
            }],
            yAxis: [{ // Primary yAxis
                labels: {
                    formatter: function() {
                        return '￥'+ this.value;
                    },
                    style: {
                        color: '#89A54E'
                    }
                },
                title: {
                    text: 'Average Price',
                    style: {
                        color: '#89A54E'
                    }
                },
                opposite: true
    
            }, { // Secondary yAxis
                gridLineWidth: 0,
                title: {
                    text: 'Total Sales Num',
                    style: {
                        color: '#4572A7'
                    }
                },
                labels: {
                    formatter: function() {
                        return this.value +' 台';
                    },
                    style: {
                        color: '#4572A7'
                    }
                }
    
            }, { // Tertiary yAxis
                gridLineWidth: 0,
                title: {
                    text: 'Favourable Comment',
                    style: {
                        color: '#AA4643'
                    }
                },
                labels: {
                    formatter: function() {
                        return this.value +' %';
                    },
                    style: {
                        color: '#AA4643'
                    }
                },
                opposite: true
            }],
            tooltip: {
                shared: true
            },
            legend: {
                layout: 'vertical',
                align: 'left',
                x: 120,
                verticalAlign: 'top',
                y: 80,
                floating: true,
                backgroundColor: '#FFFFFF'
            },
            series: [{
                name: 'Total Sales Num',
                color: '#4572A7',
                type: 'column',
                yAxis: 1,
                data: [num[0], num[1], num[2], num[3], num[4], num[5], num[6], num[7], num[8], num[9], num[10], num[11], num[12], num[13], num[14], num[15], num[16], num[17], num[18], num[19], num[20], num[21], num[22]],
                tooltip: {
                    valueSuffix: ' '
                }
    
            }, {
                name: 'Favourable Comment',
                type: 'spline',
                color: '#AA4643',
                yAxis: 2,
                data: [eval[0], eval[1], eval[2], eval[3], eval[4], eval[5], eval[6], eval[7], eval[8], eval[9], eval[10], eval[11], eval[12], eval[13], eval[14], eval[15], eval[16], eval[17], eval[18], eval[19], eval[20], eval[21], eval[22]],
                marker: {
                    enabled: false
                },
                dashStyle: 'shortdot',
                tooltip: {
                    valueSuffix: ' %'
                }
    
            }, {
                name: 'Average Price',
                color: '#89A54E',
                type: 'spline',
                data: [price[0], price[1], price[2], price[3], price[4], price[5], price[6], price[7], price[8], price[9], price[10], price[11], price[12], price[13], price[14], price[15], price[16], price[17], price[18], price[19], price[20], price[21], price[22]],
                tooltip: {
                    valueSuffix: ' yuan'
                }
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
