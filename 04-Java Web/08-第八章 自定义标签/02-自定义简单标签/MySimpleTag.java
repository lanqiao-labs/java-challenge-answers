package org.lanqiao.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class MySimpleTag extends SimpleTagSupport {

    private String type ;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void doTag() throws JspException, IOException {
        // 得到代表jsp标签体的JspFragment
        JspFragment jspBody = super.getJspBody();
        StringWriter sw = new StringWriter();
        // 将标签体的内容写入到sw流中
        jspBody.invoke(sw);
        // 获取sw流缓冲区的内容
        String content = sw.getBuffer().toString();
        // 处理字符串时间，由于取出的字符串中存在换行和空格，我们需要将他们替换掉。并且将字符串格式改为规范格式为 yyyy年MM月dd日
        String s = content.replaceAll("\n", "");
        String strS = s.replaceAll(" ", "");
        String strDate = strS.substring(0,4)+"年"+strS.substring(4,6)+"月"+strS.substring(6)+"日";
        PageContext pageContext = (PageContext) this.getJspContext();
        // 将修改后的 content 输出到浏览器中
        pageContext.getOut().write(strDate);
    }
}