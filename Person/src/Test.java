
public class Test {

	public static void main(String[] args) {
		// インスタンス化　11ページ目
		Person taro = new Person();
		taro.name = "山田太郎";
		taro.age=20;
		taro.phoneNumber = "00000000";
		taro.address = "東京葛飾区奥戸2-2-2";
		taro.height = "177cm";
		taro.sex = "男";
		taro.prefecture = "東京都";
		
		

		System.out.println(taro.name);
		System.out.println(taro.age);
		System.out.println(taro.phoneNumber);
		System.out.println(taro.address);
		System.out.println(taro.sex);
		System.out.println(taro.height);


		Person ziro = new Person();
		ziro.name= "木村次郎";
		ziro.age=18;
		System.out.println(ziro.name);
		System.out.println(ziro.age);

		Person hanako = new Person();
		hanako.name = "鈴木花子";
		hanako.age=16;
		System.out.println(hanako.name);
		System.out.println(hanako.age);



		//自分の情報を出力
		Person keisuke = new Person();
		keisuke.name = "米山佳介";
		keisuke.age = 23;
		System.out.println(keisuke.name);
		System.out.println(keisuke.age + "歳");

		taro.talk();
		taro.walk();
		taro.run();

		//12ページ
		Robot aibo = new Robot();
		Robot asimo = new Robot();
		Robot pepper = new Robot();
		Robot doraemon = new Robot();
		
		asimo.name="アシモ";
		aibo.name="アイボ";
		pepper.name="ペッパー";
		doraemon.name="ドラえもん";
		
		aibo.walk();
		asimo.talk();
		pepper.run();
		doraemon.talk();
	}

}
