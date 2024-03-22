package org.lanqiao.entity;

/**
 * 手动实现队列
 * @author lanqiao
 */
public class Queue {
    // 底层容器
    private int[] element;
    // 容器容量
    private int size = 0;

    /**
     *  默认构造方法，初始化底层容器，容量为8
     */
    public Queue() {
        this.element = new int[8];
    }

    /**
     *  元素入队，size作为下标
     * @param v 元素
     */
    public void enqueue(int v){
        // 判断容量+1 是否超过容器容量，如果是则需要扩充容器容量，不是则正常存储
        if(this.size+1>this.element.length){
            // 创建新数组，长度为旧数组的 2 倍
            int[] newElement = new int[this.element.length*2];
            // 循环将原数组的元素赋值到新数组中
            for(int i = 0;i<this.element.length;i++){
                newElement[i] = this.element[i];
            }
            // 将新数组替换原数组
            this.element = newElement;
            // 将新的元素存入数组
            this.element[size] = v;
            // 容量增加1
            this.size++;
        }else{
            this.element[this.size] = v;
            this.size++;
        }
    }

    /**
     * 元素出队，后面元素往前位移 1 位，size减一
     * @return 出队的元素
     */
    public int dequeue(){
        int ele = this.element[0];
        for(int i = 1 ; i < this.element.length ; i++){
            this.element[i-1] = this.element[i];
        }
        this.size--;
        return ele;
    }

    /**
     * 通过 size 判断队列是否为空，若 size 为 0 返回 true ，反之返回 false
     * @return
     */
    public boolean empty(){
       return this.size==0;
    }

    /**
     * 返回队列的大小
     * @return 队列的大小
     */
    public int getSize(){
        return this.size;
    }
}
