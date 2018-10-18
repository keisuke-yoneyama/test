package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns = { "/chapter4/hello4" })
public class Hello4 extends HttpServlet {// 親クラスのhttpsurvletクラスのdoGetメソッドを再定義して上書き
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		Page.header(out);

		out.println("<p>hello!</p>");
		out.println("<p>こんにちは！</p>");
		out.println("<p>" + new java.util.Date() + "</p>");

		Page.footer(out);
	}

}
