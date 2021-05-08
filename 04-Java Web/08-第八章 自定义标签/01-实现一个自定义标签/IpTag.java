package org.lanqiao.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class IpTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        // 获取 ip 地址
        String ip = pageContext.getRequest().getRemoteAddr();
        // 组成标签的输出内容
        String content = "访问用户的IP地址为："+ip;
        try {
            // 将 ip 地址输出到页面中
            pageContext.getOut().write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
}