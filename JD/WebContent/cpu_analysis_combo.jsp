<%@ page language="java" import="cn.edu.pku.ss.jddatamining.servlet.*,java.util.ArrayList" pageEncoding="utf-8"%>
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
	<%
	int num;
	ArrayList<String> cpu_type = new ArrayList();
	ArrayList<Integer> cpu_num = new ArrayList();
	ArrayList<Integer> sale_num = new ArrayList();
	ArrayList<Double> average_price = new ArrayList();
	if(request.getAttribute("cpu_type")!=null){
		cpu_type      = (ArrayList<String>)request.getAttribute("cpu_type");
		cpu_num       = (ArrayList<Integer>)request.getAttribute("cpu_num");
		sale_num      = (ArrayList<Integer>)request.getAttribute("sale_num");
		average_price = (ArrayList<Double>)request.getAttribute("average_price");
	}
	%>
        var type = [<% 	num = cpu_type.size();
                    	for( int i=0;i<num;i++)
                    	{
                    		String display = cpu_type.get(i);
                    		%>'<%=display %>'
                    		<%if(i+1<num)
                    		{
                    			%>,<%
                    		}
                    	}
                    %>];
        var typenum = [<% 	num = cpu_num.size();
    	for( int i=0;i<num;i++)
    	{
    		int display = cpu_num.get(i);
    		%><%=display%>
    		<%if(i+1<num)
    		{
    			%>,<%
    		}
    	}
    %>];
        var num = [<% 	num = sale_num.size();
    	for( int i=0;i<num;i++)
    	{
    		int display = sale_num.get(i);
    		%><%=display%>
    		<%if(i+1<num)
    		{
    			%>,<%
    		}
    	}
    %>];
        var price = [<% 	num = average_price.size();
    	for( int i=0;i<num;i++)
    	{
    		int display = average_price.get(i).intValue();
    		%><%=display%>
    		<%if(i+1<num)
    		{
    			%>,<%
    		}
    	}
    %>];
        $('#container').highcharts({
            chart: {
            },
            title: {
                text: 'CPU Analysis Chart'
            },
            xAxis: {
                categories: [<% 	num = cpu_type.size();
            	for( int i=0;i<num;i++)
            	{
            		%>type[<%=i%>]
            		<%if(i+1<num)
            		{
            			%>,<%
            		}
            	}
            %>]
            },
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
                    text: ' ',
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
                        return this.value +' 件';
                    },
                    style: {
                        color: '#4572A7'
                    }
                }
    
            }, { // Tertiary yAxis
                gridLineWidth: 0,
                title: {
                    text: 'Average Price',
                    style: {
                        color: '#AA4643'
                    }
                },
                labels: {
                    formatter: function() {
                        return this.value +' yuan';
                    },
                    style: {
                        color: '#AA4643'
                    }
                },
                opposite: true
            }],
            tooltip: {
                formatter: function() {
                    var s;
                    if (this.point.name) { // the pie chart
                        s = ''+
                            this.point.name +': '+ this.y +' types of computer use';
                    }
                    else {
                        s = ''+
                            this.x  +': '+ this.y;
                    }
                    return s;
                }
            },
            labels: {
                items: [{
                    html: 'Different Types of CPU Comparision',
                    style: {
                        left: '40px',
                        top: '8px',
                        color: 'black'
                    }
                }]
            },
            series: [{
                type: 'column',
                name: 'Sales Number',
                yAxis: 1,
                data: [<% 	num = cpu_type.size();
        	for( int i=0;i<num;i++)
        	{
        		%>num[<%=i%>]
        		<%if(i+1<num)
        		{
        			%>,<%
        		}
        	}
        %>]
            
            }, {
                type: 'spline',
                name: 'Price',
                yAxis: 2,
                data: [<% 	num = cpu_type.size();
            	for( int i=0;i<num;i++)
            	{
            		%>price[<%=i%>]
            		<%if(i+1<num)
            		{
            			%>,<%
            		}
            	}
            %>],
                marker: {
                    lineWidth: 2,
                    lineColor: Highcharts.getOptions().colors[3],
                    fillColor: 'white'
                }
            }, {
                type: 'pie',
                name: 'Numbers of Computers use',
                data: [ <% 	num = cpu_type.size();
            	for( int i=0;i<num;i++)
            	{
            		%>
            		{
                        name: type[<%=i%>],
                        y: typenum[<%=i%>],
                        color: Highcharts.getOptions().colors[<%=i%>]
                    }
            		<%if(i+1<num)
            		{
            			%>,<%
            		}
            	}
            %>],
        <!--        
                
            -->
           
                center: [100, 80],
                size: 100,
                showInLegend: false,
                dataLabels: {
                    enabled: false
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


    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
   <!--      <h1>Hello, visitor!</h1>-->
        <p>Here are the analysis result of computer sales in JD.com.</p>
   <!--      <p>Thanks for <a class="btn btn-primary" role="button" href="http://www.highcharts.com/">Highcharts</a></p>-->
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
        <p style="color:#333333;text-align:center;">&copy; The 4th Group of Java Class, School of Software & Microelectronics, Peking University.</p>
      </footer>
    </div> <!-- /container -->



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="dist/js/bootstrap.min.js"></script>
    
  </body>
</html>
