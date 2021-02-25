public class MyHttpServlet {
    public void doGet(MyRequest request, MyResponse response){ }
    public void doPost(MyRequest request, MyResponse response){ }
    public void service(MyRequest request, MyResponse response){
        //判断请求方式，如果是GET请求，执行doGet方法，否则执行doPost方法
        if(Constant.REQUEST_METHOD_GET.equals(request.getMethod())){
            doGet(request,response);
        }else(Constant.REQUEST_METHOD_POST.equals(request.getMethod())){
            doPost(request,response);
        }
    }
}