
public class Person {

	public String name = null;
	public int age = 0;

	public Person(){} //コンストラクタ1

	public Person(String name,int age){
		this.name = name;
		this.age = age; //コンストラクタ２ 名前と年齢
	}

	public Person(String name){
		this.name = name;
		this.age = 0;  //コンストラクタ３ 名前のみ
	}

	public Person(int age){
		this.name = "名前なし";
		this.age = age; //コンストラクタ４ 年齢のみ
	}

	public Person(int age,String name){
		this.name = name;
		this.age= age;
	}//コンストラクタ２の逆バージョン

}
