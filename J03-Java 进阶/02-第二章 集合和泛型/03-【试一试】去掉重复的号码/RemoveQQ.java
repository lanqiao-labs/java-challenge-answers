
package org.lanqiao.main;
import java.util.ArrayList;

public class RemoveQQ {

    public static void main(String[] args) {
        // 将文档中准备的 QQ 号创建成数组
        String[] nums = {"1231561","89571806","151235","76824338","89571806","121311","89571806","13211","76824338","123456","76824338","123456","89571806","12344","76824338","12344","76824338","112345","123456","1123344","7677471","89571806","1475639","76824338","89571806","1805385443","18117197","774768204","76824338","89571806","76824338","10172214","1345759","75776909","757747069"};
        // 创建集合
        ArrayList<String> list = new ArrayList<String>();
        // 复制数组内的元素到集合中
        for(String i : nums){
            list.add(i);
        }
        // 调用 repeat 方法进行去重并获取去重后的集合
        new RemoveQQ().repeat(list);
        // 输出去重后的集合
        System.out.println(list);
    }

    public void repeat(ArrayList<String> list){
        // 使用循环遍历集合
        for(int i = 0;i<list.size();i++){
            // 使用循环遍历集合中下标 i 之后的元素
            for(int j = i+1;j<list.size();j++){
                // 如果找到和下标 i 元素相同的字符串，则将其移除
                if(list.get(i).equals(list.get(j))){
                    list.remove(j);
                }
            }
        }
    }
}
