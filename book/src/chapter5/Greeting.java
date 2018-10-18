package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns = { "/chapter5/greeting" })
public class Greeting extends HttpServlet {
	public void doGet(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		response.setContentType("text/html,charset=UTF-8");
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");

		Page.header(out);
		out.println("<p>こんにちは！" + user + "さん！</p>");
		Page.footer(out);
	}
}
