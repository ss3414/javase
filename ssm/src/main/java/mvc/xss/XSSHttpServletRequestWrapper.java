package mvc.xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XSSHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public XSSHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    /* getParameterValues（拦截多个参数） */
    @Override
    public String[] getParameterValues(String name) {
        String[] before = super.getParameterValues(name);
        String[] after = new String[before.length];
        /* 正则过滤</> */
        for (int i = 0; i < before.length; i++) {
            after[i] = before[i].replaceAll("<", "").replaceAll(">", "");
        }
        return after;
//        return super.getParameterValues(name);
    }

}
