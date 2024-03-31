import java.io.*;
public class FileCopy {

    /**
     * 实现图片拷贝
     * @param srcfile 被拷贝的文件
     * @param descfile 拷贝后新的文件
     * @return 拷贝是否成功 true - 成功 false - 失败
     */
    public boolean copyImage(String srcfile, String descfile) throws IOException {
        File sourceFile = new File(srcfile);
        File targetFile = new File(descfile);

        if (!sourceFile.exists()) {
            throw new FileNotFoundException("源图片文件不存在: " + srcfile);
        }

        // 创建目标目录（如果尚不存在）
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }

        try (InputStream in = new FileInputStream(sourceFile);
                OutputStream out = new FileOutputStream(targetFile)) {

            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
        return true;
    }

    // 示例如何使用此方法
    public static void main(String[] args) {
        String sourceImagePath = "2.jpg";
        String targetDirectory = "img/image.jpg";

        try {
            if (new FileCopy().copyImage(sourceImagePath, targetDirectory)) {
                System.out.println("拷贝成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
