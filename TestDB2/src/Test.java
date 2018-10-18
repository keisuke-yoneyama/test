
public class Test {

	public static void main(String[] args) {
		TestUserDAO dao = new TestUserDAO();
		dao.select("taro", "123");
		dao.selectAll();
		dao.selectByname("taro");
		dao.selectByPassword("123");
		dao.updateUserNameByUserName("taro", "saburo");
		dao.insert(4, "shiro", "012");
		dao.delete("shiro");// database setsuzoku ~13p
	}
}
