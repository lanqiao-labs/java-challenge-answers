import java.util.Arrays;
import java.util.List;

/**
 * @author Teacher Tao
 */
public class UseStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-1, -3, 0, 7, 9, -1);
        
        System.out.println("集合数据转换为流对象");
        numbers.stream().forEach(System.out::println);

        System.out.println("集合数据过滤后的数据个数为" + numbers.parallelStream().filter(i -> i>0).count());

        System.out.println("集合数据进行绝对值运算生成新的流对象");
        numbers.stream().map(Math::abs).forEach(System.out::println);

        System.out.println("集合数据转换为流对象进行限流操作");
        numbers.stream().limit(2).forEach(System.out::println);
    }
}