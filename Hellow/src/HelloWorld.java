import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloWorld {

	public static void main(String[] args)throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("インスタンス化を使ったStringの書き方");
		System.out.println("7page");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("入力してください");
		String s = "123";
		int i = Integer.parseInt(s);
		System.out.println(s);


	}

}
