import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Teacher Tao
 */
public class DataShowIterator {
    public static void main(String[] args) {

    	// 程序代码
        Integer[] infos = {12,45,23,86,100,78,546,1,45,99,136,23};
		Set s = new TreeSet();
		for (Integer i : infos) {
			s.add(i);
		}
		
		// 使用迭代器遍历集合数据
		Iterator it = s.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
    }
}