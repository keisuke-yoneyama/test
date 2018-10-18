package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/chapter4/hello2" }) // サーブレットURLを開く1
// 2サーバサイドへリクエスト➁
public class Hello2 extends HttpServlet {// 3httpサーブレットクラスのdoGetメソッドをオーバーライド
	public void doGet(HttpServletRequest request, HttpServletResponse response// レスポンスの内容を設定する処理
	) throws ServletException, IOException { // ここまで③
		response.setContentType("text/plain;charset=UTF-8");

		PrintWriter out = response.getWriter();// 出力を生成4
		out.println("Hello!");
		out.println("あくしろよ！");
		out.println(new java.util.Date());
	}
}
