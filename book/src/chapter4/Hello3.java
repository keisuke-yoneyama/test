package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//webアノテーションは今回使用しない,webxmlを使用
public class Hello3 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");// 4
		PrintWriter out = response.getWriter();// サーバーコンテナは4の出力ストリームが取得される(応答)

		out.println("<!DOCTYPE html>");// printwriterクラスが提供するprintlnメソッド
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet/JSP Sample Programs</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<p>Hello!</p>");
		out.println("<p>こんにちは！</p>");
		out.println("<p>" + new java.util.Date() + "</p>");

		out.println("</body>");
		out.println("</html>");
	}

}
