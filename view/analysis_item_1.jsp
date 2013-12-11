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
        var arraynum = [14.3,18.6,12.9,11.1,7.2,12.14];
        var colors = Highcharts.getOptions().colors,
            categories = ['Thinkpad', 'Lenovo', 'Dell', 'Acer', 'Assus', 'hp'],
            name = 'Computer brands',
            data = [{
                    y: arraynum[0],
                    color: colors[0],
                    drilldown: {
                        name: 'Thinkpad in different year',
                        categories: ['2010', '2011', '2012', '2013'],
                        data: [14.1, 12.2, 16.3, 14.3],
                        color: colors[0]
                    }
                }, {
                    y: arraynum[1],
                    color: colors[1],
                    drilldown: {
                        name: 'Lenovo in different year',
                        categories: ['2010', '2011', '2012', '2013'],
                        data: [12.20, 14.83, 18.58, 18.63],
                        color: colors[1]
                    }
                }, {
                    y: arraynum[2],
                    color: colors[2],
                    drilldown: {
                        name: 'Dell in different year',
                        categories: ['2010', '2011', '2012', '2013'],
                        data: [13.12, 13.19, 12.12, 12.96],
                        color: colors[2]
                    }
                }, {
                    y: arraynum[3],
                    color: colors[3],
                    drilldown: {
                        name: 'Acer in different year',
                        categories: ['2010', '2011', '2012', '2013'],
                        data: [7.55, 8.42, 8.23, 11.15],
                        color: colors[3]
                    }
                }, {
                    y: arraynum[4],
                    color: colors[4],
                    drilldown: {
                        name: 'Assus in different year',
                        categories: ['2010', '2011', '2012', '2013'],
                        data: [4.55, 5.42, 6.23, 7.15],
                        color: colors[4]
                    }
                }, {
                    y: arraynum[5],
                    color: colors[5],
                    drilldown: {
                        name: 'hp in different year',
                        categories: ['2010', '2011', '2012', '2013'],
                        data: [ 10.12, 10.37, 11.65, 12.14],
                        color: colors[5]
                    }
                }];
    
        function setChart(name, categories, data, color) {
      chart.xAxis[0].setCategories(categories, false);
      chart.series[0].remove(false);
      chart.addSeries({
        name: name,
        data: data,
        color: color || 'white'
      }, false);
      chart.redraw();
        }
    
        var chart = $('#container').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: 'Computer market share, 2013'
            },
            subtitle: {
                text: 'Click the columns to view years. Click again to view brands.'
            },
            xAxis: {
                categories: categories
            },
            yAxis: {
                title: {
                    text: 'Total sales number(million)'
                }
            },
            plotOptions: {
                column: {
                    cursor: 'pointer',
                    point: {
                        events: {
                            click: function() {
                                var drilldown = this.drilldown;
                                if (drilldown) { // drill down
                                    setChart(drilldown.name, drilldown.categories, drilldown.data, drilldown.color);
                                } else { // restore
                                    setChart(name, categories, data);
                                }
                            }
                        }
                    },
                    dataLabels: {
                        enabled: true,
                        color: colors[0],
                        style: {
                            fontWeight: 'bold'
                        },
                        formatter: function() {
                            return this.y;
                        }
                    }
                }
            },
            tooltip: {
                formatter: function() {
                    var point = this.point,
                        s = this.x +':<b>'+ this.y +' million computers were sold</b><br/>';
                    if (point.drilldown) {
                        s += 'Click to view '+ point.category +' years';
                    } else {
                        s += 'Click to return to browser brands';
                    }
                    return s;
                }
            },
            series: [{
                name: name,
                data: data,
                color: 'grey'
            }],
            exporting: {
                enabled: false
            }
        })
        .highcharts(); // return chart
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
                    <li><a href="analysis_item_1.jsp">Analysis Item 1</a></li>
                    <li><a href="analysis_item_2.jsp">Analysis Item 2</a></li>
                    <li><a href="analysis_item_3.jsp">Analysis Item 3</a></li>
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
