/**
 * @author Teacher Tao
 *
 */
public class UseClass {

	public static void main(String[] args) {
		Class<?> c1 = new Student().getClass();
		System.out.println("当前类:" + c1.getName());
		System.out.println("父类:" + c1.getSuperclass().getName());
		
		Class<?> c2 = Teacher.class;
		System.out.println("当前类:" + c2.getName());
		
		try {
			Class<?> c3 = Class.forName("Person");
			System.out.println("当前类:" + c3.getName());
			System.out.println("父类:" + c3.getSuperclass().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}

}