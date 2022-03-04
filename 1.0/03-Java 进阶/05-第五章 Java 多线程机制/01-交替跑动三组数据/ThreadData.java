/**
 * @author Teacher Tao
 */
public class ThreadData {

	public class MyThread implements Runnable{		
		@Override
		public void run() {
			for (int i = 1; i <= 30; i++) {
				System.out.println(Thread.currentThread().getName() + ": 数据为 " + i);
			}
		}
	}

	public static void main(String[] args) {
		MyThread mt = new ThreadData().new MyThread();
		new Thread(mt,"线程1").start();
		new Thread(mt,"线程2").start();
		new Thread(mt,"线程3").start();
	}

}
