import java.util.*;
import java.util.stream.Stream;
import java.util.function.Predicate;
public class LambdaTest {
    public static void main(String[] args){
        LambdaTest lt=new LambdaTest();
        lt.Test();
    }
    public void Test(){
        List<String> languages = Arrays.asList("Java","Python","C++","JavaScript","TypeScript");
 
        System.out.print("J开头的语言有：");
        filter(languages,(str) -> str.startsWith("J"));
 
        System.out.print("t结束的语言有：");
        filter(languages,(str) -> str.endsWith("t"));
 
        System.out.print("所有语言：");
        filter(languages,(str) -> true);
 
        System.out.print("名字长度大于4的语言：");
        filter(languages,(str) -> str.length() > 4);
    }
    public void filter(List<String> names ,Predicate<String> predicate){
        for (String name : names){
            if (predicate.test(name)){
                System.out.print(name + " ");
            }
            
        }
        System.out.println();
    }
    }