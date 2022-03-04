public class Test {
    public void test(){
        /**
        * 解析请求信息
        */
        while(true){
            String msg = reader.readLine();
            //空缺处：删除字符串msg的头尾空白符
            if(msg == null || "".equals(msg.trim())){
                break;
            }
            //空缺处：将字符串msg按空格切割
            String[] msgs = msg.split(" ");
            //空缺处：比较字符串是否相同，忽略大小写
            if(msgs.length == 3 && msgs[2].equalsIgnoreCase("HTTP/1.1")){
            //设置请求方式
            request.setMethod(msgs[0]);
            //设置请求参数
            String[] pathAndParams = msgs[1].split("\\?");
            HashMap<String, Object> requestParams = new HashMap<String, Object>();
            if(pathAndParams.length == 2){
                String[] params = pathAndParams[1].split("&");
                for (String param: params) {
                    //空缺处：将param按等号切割，取等号前的部分
                    String key = param.split("=")[0];
                    //空缺处：将param按等号切割，取等号后的部分
                    String value = param.split("=")[1];
                    requestParams.put(key,value);
                }
            }
            request.setParameter(requestParams);
            //设置请求路径
            request.setPath(pathAndParams[0]);
            break;
        }

    }

}