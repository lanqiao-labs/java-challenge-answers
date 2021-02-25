public abstract class MyHttpServlet {
    //定义doGet方法，该方法有两个参数request与response，参数类型分别为MyRequest ，MyResponse ,方法没有返回值
    public void doGet(MyRequest request, MyResponse response){};
    //定义doPost方法，该方法有两个参数request与response，参数类型分别为MyRequest ，MyResponse ,方法没有返回值
    public void doPost(MyRequest request, MyResponse response){};
    public void service(MyRequest request, MyResponse response){
        if(Constant.REQUEST_METHOD_GET.equals(request.getMethod())){
            //调用doGet()方法
            doGet(request,response);
        }else if(Constant.REQUEST_METHOD_POST.equals(request.getMethod())){
            //调用doPost()方法
            doPost(request,response);
        }
    }
}