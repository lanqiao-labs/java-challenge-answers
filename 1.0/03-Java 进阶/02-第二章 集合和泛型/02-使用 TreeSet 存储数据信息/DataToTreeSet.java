import java.util.TreeSet;
import java.util.Set;

/**
 * @author Teacher Tao
 */
public class DataToTreeSet {
    public static void main(String[] args) {

    	// 程序代码
        Integer[] infos = {12,45,23,86,100,78,546,1,45,99,136,23};
        Set s = new TreeSet();
		for (Integer i : infos) {
			s.add(i);
		}
		System.out.println(s);
    }
}