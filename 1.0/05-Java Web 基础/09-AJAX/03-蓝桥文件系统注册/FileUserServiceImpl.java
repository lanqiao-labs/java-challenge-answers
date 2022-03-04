package org.lanqiao.service.impl;

import com.mysql.jdbc.StringUtils;
import org.lanqiao.dao.FileUserDao;
import org.lanqiao.dao.impl.FileUserDaoImpl;
import org.lanqiao.entity.FileUser;
import org.lanqiao.service.FileUserService;
import org.lanqiao.util.ResponseMessage;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUserServiceImpl implements FileUserService {
   private FileUserDao fileUserDao = new FileUserDaoImpl();

    @Override
    public ResponseMessage registUser(FileUser fileUser, ResponseMessage rm) {
        String userName = fileUser.getUserName();
        String userPass = fileUser.getUserPass();
        String userEmail = fileUser.getUserEmail();

        if(StringUtils.isNullOrEmpty(userName)){
            rm.setMsg("用户名不能为空！");
            rm.setStatus(ResponseMessage.STATUS_ERROR);
            return rm;
        }

        if(StringUtils.isNullOrEmpty(userPass)){
            rm.setMsg("密码不能为空！");
            rm.setStatus(ResponseMessage.STATUS_ERROR);
            return rm;
        }

        if(StringUtils.isNullOrEmpty(userEmail)){
            rm.setStatus(ResponseMessage.STATUS_ERROR);
            rm.setMsg("邮箱不能为空！");
            return rm;
        }
        //检查是否为邮箱
        if(!checkEmail(userEmail)){
            rm.setStatus(ResponseMessage.STATUS_ERROR);
            rm.setMsg("请输入正确的邮箱！");
            return rm;
        }

        fileUser.setCreateTime( new Timestamp(System.currentTimeMillis()));
        //判断用户是否注册
        FileUser oldUser  = fileUserDao.findUserByUserName(fileUser.getUserName());
        if(oldUser!=null){
            rm.setMsg("用户名已存在！");
            rm.setStatus(ResponseMessage.STATUS_ERROR);
            return rm;
        }

        Boolean isSuccess  =fileUserDao.saveUser(fileUser);
        if(!isSuccess){
            rm.setMsg("保存失败");
            rm.setStatus(ResponseMessage.STATUS_ERROR);
            return rm;
        }
        rm.setMsg("保存成功请登录");
        rm.setStatus(ResponseMessage.STATUS_OK);
        return rm;
    }

    @Override
    public ResponseMessage loginUser(FileUser fileUser, ResponseMessage rm) {
        String userName = fileUser.getUserName();
        String userPass = fileUser.getUserPass();

        if(StringUtils.isNullOrEmpty(userName)){
            rm.setMsg("用户名不能为空！");
            rm.setStatus(ResponseMessage.STATUS_ERROR);
            return rm;
        }

        if(StringUtils.isNullOrEmpty(userPass)){
            rm.setMsg("密码不能为空！");
            rm.setStatus(ResponseMessage.STATUS_ERROR);
            return rm;
        }
        //判断用户是否注册
        FileUser user  = fileUserDao.findUserByUserName(fileUser.getUserName());
        if(user==null){
            rm.setMsg("用户名不存在，请先注册！");
            rm.setStatus(ResponseMessage.STATUS_ERROR);
            return rm;
        }else if(user.getUserName().equals(userName) && user.getUserPass().equals(userPass)){
            rm.setStatus(ResponseMessage.STATUS_OK);
            return rm;
        }else{
            rm.setMsg("用户或密码不正确！");
            rm.setStatus(ResponseMessage.STATUS_ERROR);
            return rm;
        }
    }

    /**
     * 检查邮箱是否正确
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(email);
        if (m.matches()){
            return true;
        }
        return false;
    }
}