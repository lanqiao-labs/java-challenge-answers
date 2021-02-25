import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer {
    private static ServerSocket serverSocket;
    private static int port = 8080;
    private final static int POOL_SIZE = 8;
    private static ExecutorService executorService;

    public static void start(){
        try {
            serverSocket = new ServerSocket(port);
            Socket socket = null;
            System.out.println("服务器已启动, 初始化端口为:"+port);
            executorService = Executors.newFixedThreadPool(POOL_SIZE); //初始化线程池
            //开启循环，一直等待获取客户端请求
            while(true){
                socket = serverSocket.accept();  //等待获取客户端请求
                System.out.println("服务器已接收到请求");
                executorService.execute(new MyHandler(socket));  //分配线程处理请求,响应
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        start();
    }
}