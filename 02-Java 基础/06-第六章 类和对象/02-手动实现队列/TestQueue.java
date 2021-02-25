public class TestQueue {

    public static void main(String[] args) {
        // 创建队列
        Queue queue = new Queue();
        // 存 0-20 共 21 个数字
        for(int i = 0 ; i <= 20 ; i++){
            queue.enqueue(i);
        }
        // 取出所有元素
       while (!queue.empty()){
           System.out.println(queue.dequeue());
       }
    }
}