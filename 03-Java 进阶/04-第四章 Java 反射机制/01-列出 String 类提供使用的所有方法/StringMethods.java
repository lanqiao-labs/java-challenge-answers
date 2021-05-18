/**
 * 
 */
package com.testjavase.javabase.chapter4;
import java.lang.reflect.Method;

/**
 * @author Teacher Tao
 *
 */
public class StringMethods {

	/**
	 * 获取 String 类中所有的方法
	 */
	public void getStringMethodInfos() {
		try {
			Class<?> c = Class.forName("java.lang.String");
			Method[] m = c.getDeclaredMethods();
			System.out.println("String 类中一共有 " + m.length + " 个方法");
			for (Method method : m) {
				System.out.println(method);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new StringMethods().getStringMethodInfos();
	}

}
