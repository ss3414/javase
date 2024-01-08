package mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    /*
     * （下一个拦截器/Controller）处理请求前调用，第三个参数o为（下一个拦截器/Controller）
     * 返回true继续流程（下一个拦截器/Controller）
     * 返回false中断流程，不会调用下一个拦截器/Controller（此时需要通过response告知用户）
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) {

//        getIP(httpServletRequest);
//        judgeMobile(httpServletRequest);
        return true;
    }

    /*
     * （上一个拦截器/Controller）处理请求后调用
     * 第三个参数o为（下一个拦截器/Controller），modelAndView为上一个处理后的结果
     * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) {

    }

    /*
     * 在DispatcherServlet完全处理完，即视图渲染完后调用
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {

    }

    /************************************************************分割线************************************************************/

    /* 获取请求IP（包括反向代理后真实IP） */
    private void getIP(HttpServletRequest request) {

        String IP = request.getHeader("x-forwarded-for");
        if (IP == null || IP.length() == 0 || "unknown".equalsIgnoreCase(IP)) {
            IP = request.getHeader("Proxy-Client-IP");
        }
        if (IP == null || IP.length() == 0 || "unknown".equalsIgnoreCase(IP)) {
            IP = request.getHeader("WL-Proxy-Client-IP");
        }
        if (IP == null || IP.length() == 0 || "unknown".equalsIgnoreCase(IP)) {
            IP = request.getRemoteAddr();
        }
        System.out.println(IP);
    }

    /* 根据UA判断是否为移动端 */
    private void judgeMobile(HttpServletRequest request) {

        boolean flag = false;
        String[] mobileAgents = {"android", "iphone"};
        String agent = request.getHeader("User-Agent");

        if (agent != null) {
            for (String mobile : mobileAgents) {
                if (agent.toLowerCase().contains(mobile)
                        && !agent.toLowerCase().contains("windows nt")
                        && !agent.toLowerCase().contains("macintosh")) {
                    flag = true;
                    break;
                }
            }
        }
        System.out.println(flag);
    }

}
