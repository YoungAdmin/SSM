package cn.smbms.tools;

public class TestSingleton {
	public static void main(String[] args) {
		System.out.println("Singleton.test()-----> " 
				+ Singleton.test());
		
		System.out.println("Singleton.getInstance()-----> " 
						+ Singleton.getInstance());
	}
}
