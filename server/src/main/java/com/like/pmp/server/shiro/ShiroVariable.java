package com.like.pmp.server.shiro;/**
 * Created by Administrator on 2019/8/4.
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

/**
 * 推送给前端使用的shiro对象变量
 * @Author:debug (SteadyJack)
 * @Date: 2019/8/4 22:29
 **/
@Component
public class ShiroVariable {

    /**
     * 判断当前登录用户（主体）是否有 指定的权限
     * @param permission 指定的权限
     * @return
     */
    public Boolean hasPermission(String permission){
        Subject subject=SecurityUtils.getSubject();
        /*if (subject!=null && subject.isPermitted(permission)){
            return true;
        }
        return false;*/

        return (subject!=null && subject.isPermitted(permission))? true : false;
    }

}


























