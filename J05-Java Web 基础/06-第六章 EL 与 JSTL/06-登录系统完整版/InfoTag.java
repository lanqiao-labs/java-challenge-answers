package org.lanqiao.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class InfoTag extends BodyTagSupport {

  @Override
  public int doEndTag() throws JspException {
//      获取标签体内容
      String info = getBodyContent().getString();
//      将 json 字符串中的特殊符号去掉
      info = info.replace("}","");
      info = info.replace("\"","");
//      字符串转为数组
      String[] split = info.split(",");
//      新建一个二维数组，将上面数组中的内容再次进行分割
      String[][] infos = new String[split.length][2];
//      循环遍历分割上述字符
      for(int i = 0 ; i < split.length ; i++){
          infos[i] = split[i].split(":");
      }
//      拼接字符串并输出到页面
      info = "<p>ID："+infos[0][1]+"</p><p>用户名："+infos[1][1]+"</p><p>密码："+infos[2][1]+"</p><p>昵称："+infos[3][1]+"</p><p>电话："+infos[4][1]+"</p><p>真实姓名："+infos[5][1]+"</p>";
      try {
          bodyContent.getEnclosingWriter().write(info);
      } catch (IOException e) {
          e.printStackTrace();
      }
      return super.doEndTag();
  }
}
 