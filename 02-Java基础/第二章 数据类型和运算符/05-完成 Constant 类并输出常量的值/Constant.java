public class Constant {
  //定义常量REQUEST_METHOD_GET 与 REQUEST_METHOD_POST
  public final static String REQUEST_METHOD_GET ="GET";
  public final static String REQUEST_METHOD_POST ="POST";

  public static void main(String[] args) {
      //对常量值进行非空判断并输出
      if(REQUEST_METHOD_GET != null && REQUEST_METHOD_POST != null){
      	System.out.println(REQUEST_METHOD_GET);
      	System.out.println(REQUEST_METHOD_POST);
      }
  }
}