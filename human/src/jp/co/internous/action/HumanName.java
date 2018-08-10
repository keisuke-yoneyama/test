package jp.co.internous.action;

public class HumanName {

	public String lastName;
	private String firstName;
	public String getName(){
	   firstName="YAMADA";
	   lastName="taro";

	   String myName=firstName+lastName;
	   return myName;
   }
}
