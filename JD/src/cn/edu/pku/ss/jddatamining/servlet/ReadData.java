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
		String line;
		FileWriter writer=new FileWriter("D:/result/statistics_base_brand.txt");
		
		try {
			if (type.equals("cpu_analysis_combo")) {
				file = new Scanner(
						new File(request.getRealPath("\\data\\statistics_base_CPU.txt")));
				ArrayList<String> cpu_type = new ArrayList();
				ArrayList<Integer> cpu_num = new ArrayList();
				ArrayList<Integer> sale_num = new ArrayList();
				ArrayList<Double> average_price = new ArrayList();
				file.nextLine();
				while (file.hasNext()) {
					line = file.nextLine();
					String[] words = line.split(",");
					
					cpu_type.add(words[0]);
					cpu_num.add(Integer.parseInt(words[1]));
					sale_num.add(Integer.parseInt(words[2]));
					average_price.add(Double.parseDouble(words[3]));
				}
				request.setAttribute("cpu_type", cpu_type);
				request.setAttribute("cpu_num", cpu_num);
				request.setAttribute("sale_num", sale_num);
				request.setAttribute("average_price", average_price);
				request.getRequestDispatcher("cpu_analysis_combo.jsp").forward(
						request, response);
			}else if(type.equals("statistics_base_brand_combo")){//TXT换行有问题
				String path = request.getRealPath("\\data\\statistics_base_brand.txt");
				file = new Scanner(
						new File(path));
				ArrayList<String> brand_name = new ArrayList();
				ArrayList<Integer> sale_num = new ArrayList();
				ArrayList<Double> average_price = new ArrayList();
				ArrayList<Double> comment_pencentage = new ArrayList();
				file.nextLine();
				while (file.hasNext()) {
					line = file.nextLine();
					String[] words = line.split(",");
					
					brand_name.add(words[0]);
					average_price.add(Double.parseDouble(words[2]));
					sale_num.add(Integer.parseInt(words[3]));
					comment_pencentage.add(Double.parseDouble(words[5]));
				}
				request.setAttribute("brand_name", brand_name);
				request.setAttribute("average_price", average_price);
				request.setAttribute("sale_num", sale_num);
				request.setAttribute("comment_pencentage", comment_pencentage);
				request.getRequestDispatcher("statistics_base_brand_combo.jsp").forward(
						request, response);
			}else if(type.equals("size_analysis_combo")){
				String path = request.getRealPath("\\data\\statistics_base_size.txt");
				file = new Scanner(
						new File(path));
				ArrayList<String> size_name = new ArrayList();
				ArrayList<Integer> sale_num = new ArrayList();
				ArrayList<Integer> type_num = new ArrayList();
				ArrayList<Double> average_price = new ArrayList();
				file.nextLine();
				while (file.hasNext()) {
					line = file.nextLine();
					String[] words = line.split(",");
					
					size_name.add(words[0]);
					type_num.add(Integer.parseInt(words[1]));
					sale_num.add(Integer.parseInt(words[2]));
					average_price.add(Double.parseDouble(words[4]));
				}
				request.setAttribute("size_name", size_name);
				request.setAttribute("type_num", type_num);
				request.setAttribute("sale_num", sale_num);
				request.setAttribute("average_price", average_price);
				request.getRequestDispatcher("size_analysis_combo.jsp").forward(
						request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}finally{
			
		}

	}

}
