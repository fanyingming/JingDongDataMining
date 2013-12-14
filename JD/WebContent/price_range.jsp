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
	ArrayList<String> range_name      = new ArrayList();
	ArrayList<Integer> range_sale_num = new ArrayList();
	String[][] brand_name      = new String[50][50];
	double[][] brand_share     = new double[50][50];
	int list_num =0;
	int brand_num=0;
	if(request.getAttribute("cpu_type")!=null){
		list_num       = (Integer)request.getAttribute("list_num");
		brand_num      = (Integer)request.getAttribute("brand_num");
		range_name     = (ArrayList<String>)request.getAttribute("range_name");
		range_sale_num = (ArrayList<Integer>)request.getAttribute("range_sale_num");
		brand_name     = (String[][])request.getAttribute("brand_name");
		brand_share = (double[][])request.getAttribute("brand_share");
	}
	%>
	<!--
        var array1 = [1.7, 1.67, 3.2, 2.13, 1.66, 4.92, 0, 8.9, 11.2, 0, 17.9, 0, 5.1, 1, 7.6, 0, 5.7, 10.1, 0.2, 4, 0.5, 0, 0.3];
        var array2 = [1.7, 1.67, 3.2, 2.13, 0, 17.9, 0, 5.1, 1, 7.6, 1.66, 4.92, 0, 8.9, 11.2, 0, 5.7, 10.1, 0.2, 4, 0.5, 0, 0.2];
        var array3 = [0, 17.9, 0, 5.1, 1, 7.6, 0, 5.7, 10.1, 0.2, 4, 0.5, 0, 1.7, 1.67, 3.2, 2.13, 1.66, 4.92, 0, 8.9, 11.2, 5];
        var array4 = [0, 17.9, 0, 0.2, 4, 0.5, 0, 1.7, 1.67, 3.2, 2.13, 1.66, 5.1, 1, 7.6, 0, 5.7, 10.1, 4.92, 0, 8.9, 11.2, 4];
        var array5 = [0, 17.9, 0, 0.2, 4, 0.5, 0, 1.7, 1, 7.6, 0, 5.7, 10.1, 4.92, 0, 1.67, 3.2, 2.13, 1.66, 5.1, 8.9, 11.2, 3];
        var array6 = [10.1, 4.92, 0, 1.67, 3.2, 2.13, 1.66, 5.1, 8.9, 11.2, 0, 17.9, 0, 0.2, 4, 0.5, 0, 1.7, 1, 7.6, 0, 5.7, 2];
      -->
        <% 	
    	for( int i=0;i<list_num;i++)
    	{
    		%>var array<%=i+1%> =[
    		                      <%
    		                      	for(int j=0;j<brand_num;j++){
    		                      		double number = brand_share[i][j];
    		                      		%><%=number%>
    		                      				<%if(j+1<brand_num)
    		                            		{
    		                            			%>,<%
    		                            		}	
    		                      	}
    		                      %>
    		                      ];<%
    	}
    %>
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
            	
                categories: ['ä¸æ', 'æµ·å°', 'Thinkpad', 'ä¸è', 'èæ³', 'Dell',
                    'è¹æ', 'å®åº', 'å¯å£«é', 'æªæ¥äººç±»', 'Asus/åç¡', 'å¤æäºº', 
                    'æ¸ååæ¹', 'Gateway', 'æ æ®', 'é·è', 'ç¥è', 'ä¸å', 
                    'ä¼æ´¾', 'å¶ä»', 'å¾®æ', 'ç´¢å°¼', 'æå']
            <!--
            	categories: [<% 
            	for( int i=0;i<brand_num;i++)
            	{
            		String display = brand_name[0][i];
            		%>'<%=display %>'
            		<%if(i+1<brand_num)
            		{
            			%>,<%
            		}
            	}
            %>]
                -->
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
                name: '3000ä»¥ä¸',
                data: [array1[0], array1[1], array1[2], array1[3], array1[4], array1[5], array1[6], array1[7], array1[8], array1[9], array1[10], array1[11], array1[12], array1[13], array1[14], array1[15], array1[16], array1[17], array1[18], array1[19], array1[20], array1[21], array1[22]]
            }, {
                name: '3000-5000',
                data: [array2[0], array2[1], array2[2], array2[3], array2[4], array2[5], array2[6], array2[7], array2[8], array2[9], array2[10], array2[11], array2[12], array2[13], array2[14], array2[15], array2[16], array2[17], array2[18], array2[19], array2[20], array2[21], array2[22]]
            }, {
                name: '5000-8000',
                data: [array3[0], array3[1], array3[2], array3[3], array3[4], array3[5], array3[6], array3[7], array3[8], array3[9], array3[10], array3[11], array3[12], array3[13], array3[14], array3[15], array3[16], array3[17], array3[18], array3[19], array3[20], array3[21], array3[22]]
            }, {
                name: '8000-15000',
                data: [array4[0], array4[1], array4[2], array4[3], array4[4], array4[5], array4[6], array4[7], array4[8], array4[9], array4[10], array4[11], array4[12], array4[13], array4[14], array4[15], array4[16], array4[17], array4[18], array4[19], array4[20], array4[21], array4[22]]
            }, {
                name: '15000-30000',
                data: [array5[0], array5[1], array5[2], array5[3], array5[4], array5[5], array5[6], array5[7], array5[8], array5[9], array5[10], array5[11], array5[12], array5[13], array5[14], array5[15], array5[16], array5[17], array5[18], array5[19], array5[20], array5[21], array5[22]]
            }, {
                name: '30000ä»¥ä¸',
                data: [array6[0], array6[1], array6[2], array6[3], array6[4], array6[5], array6[6], array6[7], array6[8], array6[9], array6[10], array6[11], array6[12], array6[13], array6[14], array6[15], array6[16], array6[17], array6[18], array6[19], array6[20], array6[21], array6[22]]
            }]
            <!--
            series: [<% 	
                 	for( int i=0;i<list_num;i++)
                	{
                		%>
                		{
                			name: '<%=range_name.get(i)%>',
                			data: [<%
    		                      	for(int j=0;j<brand_num;j++){
    		                      		%>array<%=i+1%>[<%=j%>]
    		                      				<%if(j+1<brand_num)
    		                            		{
    		                            			%>,<%
    		                            		}	
    		                      	}
    		                      %>]}
                		<%
                			if(i+1<list_num)
                			{
                				%>,<%
                			}
                		%>
                		<%
                	}
                %>]
            -->
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
          <p>D1c id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. D1c sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>D1c id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. D1c sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>D1c sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
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
