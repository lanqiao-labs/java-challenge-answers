import java.util.Scanner;

/**
 * @author Teacher Tao
 */
public class CountDown implements Runnable{
	
	public void go() {
		new Thread(this).start();		
	}
	
	public static void main(String[] args) {
		new CountDown().go();
	}

	@Override
	public void run() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入倒计时秒数:");
		int i = input.nextInt();
		input.close();
		while(i != 0) {
			System.out.println(i);
			i--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);		
	}

}
