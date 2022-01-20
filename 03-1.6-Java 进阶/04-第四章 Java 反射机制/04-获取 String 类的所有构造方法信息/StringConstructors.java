import java.lang.reflect.Constructor;

/**
 * @author Teacher Tao
 *
 */
public class StringConstructors {

	/**
	 * 获取所有String类中构造方法
	 */
	public void getConstructorInfos() {

		try {
			Class<?> c = Class.forName("java.lang.String");
			Constructor<?>[] cs = c.getDeclaredConstructors();
			System.out.println("构造方法总数:" + cs.length);
			
			for (Constructor<?> constructor : cs) {
				System.out.println("构造方法名称:" + constructor.getName());
				Class<?>[] params = constructor.getParameterTypes();
				System.out.println(params.length==0?"构造方法无参数":"构造方法参数：");
				for (Class<?> param : params) {
					System.out.print(param+"  |  ");
				}
				System.out.println();
				Class<?>[] exceptions = constructor.getExceptionTypes();
				System.out.println(exceptions.length==0?"无抛出异常":"抛出异常：");
				for (Class<?> e: exceptions) {
					System.out.print(e);
				}
				System.out.println();
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new StringConstructors().getConstructorInfos();
	}

}
