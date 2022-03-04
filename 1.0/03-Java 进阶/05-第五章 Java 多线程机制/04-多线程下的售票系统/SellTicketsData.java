/**
 * @author Teacher Tao
 */
public class SellTicketsData {
    public static void main(String[] args) {
		
		SellThread st = new SellThread();
		new Thread(st, "售票窗口1").start();
		new Thread(st, "售票窗口2").start();
		new Thread(st, "售票窗口3").start();
		new Thread(st, "售票窗口4").start();
			
	}
}

class SellThread implements Runnable{
	
	int tickets = 100;
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if(tickets > 0) {
				System.out.println(Thread.currentThread().getName() +" 票号:" + tickets);
				tickets--;
			}					
		}
	}
	
}