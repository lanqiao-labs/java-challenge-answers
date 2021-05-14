import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

/**
 * @author Teacher Tao
 */
public class SelectTxtFile {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        // 正确读取路径 home/project/files
        // 创建一个指定路径的文件对象
        System.out.println("请输入读取路径：");
        File path = new File(input.next()); 
		if (!path.exists() || !path.isDirectory()) {
			System.out.println("该目录不存在，或者它不是个目录");
            input.close();
            return;
		}
		// 匿名内部类的写法。通过文件名称过滤器FilenameFilter来筛选文件
		File[] txts = path.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
                // 文件扩展名为txt
				return name.toLowerCase().endsWith(".txt"); 
			}
        });
        // 打印所有文本文件的名称
        if (txts != null) { 
            for (File file : txts) {
                System.out.println(file.getName());
            }
        }
        input.close();
    }
}