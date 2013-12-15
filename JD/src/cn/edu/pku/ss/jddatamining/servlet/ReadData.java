package cn.edu.pku.ss.jddatamining.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadData
 */
@WebServlet("/ReadData")
public class ReadData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		Scanner file;
		String lines;
		int item_count = 0;
		
		try {
			if (type.equals("cpu_analysis_combo")) {
				file = new Scanner(
						new File(request.getRealPath("\\data\\statistics_base_CPU.txt")));
				ArrayList<String> cpu_type = new ArrayList();
				ArrayList<Integer> cpu_num = new ArrayList();
				ArrayList<Integer> sale_num = new ArrayList();
				ArrayList<Double> average_price = new ArrayList();
				while (file.hasNext()) {
					String[] line;
					lines = file.nextLine();
					line = lines.split(";");
					for (int i = 0; i < line.length; i++) {
						String[] words = line[i].split(",");
						item_count++;
						if(item_count==1)
							continue;//跳过第一行的汉字描述部分。
						cpu_type.add(words[0]);
						cpu_num.add(Integer.parseInt(words[1]));
						sale_num.add(Integer.parseInt(words[2]));
						average_price.add(Double.parseDouble(words[3]));
					}
				}
				request.setAttribute("cpu_type", cpu_type);
				request.setAttribute("cpu_num", cpu_num);
				request.setAttribute("sale_num", sale_num);
				request.setAttribute("average_price", average_price);
				request.getRequestDispatcher("cpu_analysis_combo.jsp").forward(
						request, response);
			}else if(type.equals("statistics_base_brand_combo")|| type.equals("sale_share")){//TXT换行有问题
				String path = request.getRealPath("\\data\\statistics_base_brand.txt");
				file = new Scanner(new File(path));
				ArrayList<String> brand_name = new ArrayList();
				ArrayList<Integer> sale_num = new ArrayList();
				ArrayList<Double> average_price = new ArrayList();
				ArrayList<Double> sale_share = new ArrayList();
				ArrayList<Double> comment_pencentage = new ArrayList();
				while (file.hasNext()) {
					String[] line;
					lines = file.nextLine();
					line = lines.split(";");
					for (int i = 0; i < line.length; i++) {
						String[] words = line[i].split(",");
						item_count++;
						if(item_count==1)
							continue;//跳过第一行的汉字描述部分。
						brand_name.add(words[0]);
						average_price.add(Double.parseDouble(words[2]));
						sale_num.add(Integer.parseInt(words[3]));
						sale_share.add(Double.parseDouble(words[4]));
						comment_pencentage.add(Double.parseDouble(words[5])*100);
					}
				}
				request.setAttribute("brand_name", brand_name);
				request.setAttribute("average_price", average_price);
				request.setAttribute("sale_share", sale_share);
				request.setAttribute("sale_num", sale_num);
				request.setAttribute("comment_pencentage", comment_pencentage);
				if (type.equals("statistics_base_brand_combo")){
					request.getRequestDispatcher("statistics_base_brand_combo.jsp").forward(
							request, response);
				}
				else{
					request.getRequestDispatcher("sale_share.jsp").forward(
							request, response);
				}
					
			}else if(type.equals("price_range")){
				String path = request.getRealPath("\\data\\statistics_base_price.txt");
				file = new Scanner(new File(path));
				ArrayList<String> range_name      = new ArrayList();
				ArrayList<Integer> range_sale_num = new ArrayList();
				String[][] brand_name      = new String[50][50];
				double[][] brand_share     = new double[50][50];
				int list_num =0;
				double brand_num=0;
				while (file.hasNext()) {
					String[] line;
					lines = file.nextLine();
					line = lines.split(";");
					for (int i = 0; i < line.length; i++) {
						String[] words = line[i].split(",");
						item_count++;
						if(item_count==1)
							continue;//跳过第一行的汉字描述部分。
						range_name.add(words[0]);
						range_sale_num.add(Integer.parseInt(words[1]));
						for(int j=2,count=0;j<words.length;j+=2,count++){
							brand_name[list_num][count]  = words[j];
							brand_share[list_num][count] = Double.parseDouble(words[j+1])*100;
							brand_num++;//品牌数，会重复行数的倍数
						}
						list_num++;//行数
					}
				}
				double temp = brand_num/list_num;
				int intt = (int)temp;
				request.setAttribute("brand_num", intt);
				request.setAttribute("list_num", list_num);
				request.setAttribute("range_name", range_name);
				request.setAttribute("range_sale_num", range_sale_num);
				request.setAttribute("brand_name", brand_name);
				request.setAttribute("brand_share", brand_share);
				request.getRequestDispatcher("price_range.jsp").forward(
						request, response);
			}else if(type.equals("size_analysis_combo")){
				String path = request.getRealPath("\\data\\statistics_base_size.txt");
				file = new Scanner(
						new File(path));
				ArrayList<String> size_name = new ArrayList();
				ArrayList<Integer> sale_num = new ArrayList();
				ArrayList<Integer> type_num = new ArrayList();
				ArrayList<Double> average_price = new ArrayList();
				
				while (file.hasNext()) {
					String[] line;
					lines = file.nextLine();
					line = lines.split(";");
					for (int i = 0; i < line.length; i++) {
						String[] words = line[i].split(",");
						item_count++;
						if(item_count==1)
							continue;//跳过第一行的汉字描述部分。
						size_name.add(words[0]);
						type_num.add(Integer.parseInt(words[1]));
						sale_num.add(Integer.parseInt(words[2]));
						average_price.add(Double.parseDouble(words[4]));
					}
				}
				request.setAttribute("size_name", size_name);
				request.setAttribute("type_num", type_num);
				request.setAttribute("sale_num", sale_num);
				request.setAttribute("average_price", average_price);
				request.getRequestDispatcher("size_analysis_combo.jsp").forward(
						request, response);
			}else if(type.equals("comment_analyse")){
				
				request.getRequestDispatcher("analysis_item_1.jsp").forward(
						request, response);
			}else{
					String error_contant="Your input type is not correct.";
					request.setAttribute("error_contant", error_contant);
					request.getRequestDispatcher("error.jsp").forward(
							request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String error_contant="The format of the data may not correct, please check your input format again.";
			request.setAttribute("error_contant", error_contant);
			request.getRequestDispatcher("error.jsp").forward(
					request, response);
		}finally{
			
		}

	}

}
