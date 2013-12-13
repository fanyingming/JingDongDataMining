package cn.edu.pku.ss.jddatamining.servlet;

import java.io.File;
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

		try {
			if (type.equals("cpu_analysis_combo")) {
				// request.getRealPath(arg0);
				Scanner file = new Scanner(
						new File(request.getRealPath("\\data\\statistics_base_CPU.txt")));
				String line;
				ArrayList<String> cpu_type = new ArrayList();
				ArrayList<Integer> cpu_num = new ArrayList();
				ArrayList<Integer> sale_num = new ArrayList();
				ArrayList<Double> average_price = new ArrayList();
				
				file.nextLine();
				while (file.hasNext()) {
					line = file.nextLine();
					String[] words = line.split(",");
					cpu_type.add(words[0] + " " + words[1]);
					cpu_num.add(Integer.parseInt(words[2]));
					sale_num.add(Integer.parseInt(words[3]));
					average_price.add(Double.parseDouble(words[4]));
				}
				
				request.setAttribute("cpu_type", cpu_type);
				request.setAttribute("cpu_num", cpu_num);
				request.setAttribute("sale_num", sale_num);
				request.setAttribute("average_price", average_price);
				request.getRequestDispatcher("cpu_analysis_combo.jsp").forward(
						request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}

	}

}
