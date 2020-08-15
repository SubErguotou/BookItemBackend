package com.erguotou.interceptor;

import com.erguotou.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//写一个拦截器自定义拦截规则，写完之后把它加入WebConfigurer
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
//    这个方法是一个拦截链
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        获取项目路径
        HttpSession session = request.getSession();
        String contextPath=session.getServletContext().getContextPath();
        String[] requireAuthPages = new String[]{
                "index",
        };


//        获取请求的URI
        String uri = request.getRequestURI();
        System.out.println("uri:======>"+uri);
        System.out.println("contextPath==========>"+contextPath);

//        使用remove方法移除项目路径中的匹配uri，比如：http://localhost:8080/testproject/test 就移除/testproject/test
        uri = StringUtils.remove(uri, contextPath+"/");
        String page = uri;

        if(begingWith(page, requireAuthPages)){
//           查看session里是否存储了用户信息
            User user = (User) session.getAttribute("user");
//            用户信息为空则重定向到login
            if(user == null){
                response.sendRedirect("login");
                return false;
            }
        }

        return true;
    }


    private boolean begingWith(String page, String[] requiredAuthPages){
        boolean result = false;
//        判断requiredAuthPages里requiredAuthPage为前缀的page
        for(String requiredAuthPage : requiredAuthPages){ // 作用是判断数组里是否有与之匹配的uri
            if(StringUtils.startsWith(page, requiredAuthPage)){
                result = true;
                break;
            }
        }
        return result;
    }
}
