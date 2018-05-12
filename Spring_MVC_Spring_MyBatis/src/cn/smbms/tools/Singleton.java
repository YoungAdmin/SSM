package cn.smbms.tools;

public class Singleton {
	
	private static Singleton singleton;
	
	private Singleton(){
		//在整个应用运行期间，只执行一次的业务代码操作(比如：读取配置文件的操作)
	}
	
	public static class SingletonHelper{
		private static final Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInstance(){
		return SingletonHelper.INSTANCE;
	}
	public static Singleton test(){
		return singleton;
	}
	
}
