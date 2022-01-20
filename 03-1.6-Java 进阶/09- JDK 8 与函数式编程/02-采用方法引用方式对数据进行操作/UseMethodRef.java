
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Teacher Tao
 */
public class UseMethodRef {
    public static void main(String[] args) {
        
        Integer[] intarray = {76, 1, 55, 17, 23, 99};
        Arrays.sort(intarray, Integer::compare);
        for (Integer integer : intarray) {
            System.out.println(integer);
        }

        String[] verse = {"天地玄黄", "宇宙洪荒", "日月盈昃", "辰宿列张", "寒来暑往", "秋收冬藏"};
        Arrays.asList(verse).forEach(System.out::println);

        INames names = ArrayList<String>::new;
        ArrayList<String> list = names.storeNames();
        list.add("张三");
        list.add("李四");
        list.add("小桃子");
        list.forEach(System.out::println);

    }
}

interface INames{
    ArrayList<String> storeNames();
}