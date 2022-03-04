import java.util.Arrays;

/**
 * @author Teacher Tao
 */
public class UseLambda {
    public static void main(String[] args) {

    	// 通过Lambda表达式完成整型数组以降序方式排序操作
        Integer[] intarray = {76, 1, 55, 17, 23, 99};
        Arrays.sort(intarray, (o1, o2) -> Integer.compare(o2, o1));
        for (Integer integer : intarray) {
            System.out.println(integer);
        }

        // 使用Lambda表达式遍历集合中的数据
        String[] verse = {"天地玄黄", "宇宙洪荒", "日月盈昃", "辰宿列张", "寒来暑往", "秋收冬藏"};
        Arrays.asList(verse).forEach(name -> System.out.println(name));

    }
}