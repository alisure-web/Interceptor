package test.spring.Interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ALISURE on 2017/3/17.
 */
public class SpringInterceptor extends HandlerInterceptorAdapter{

    private List<String> excludedUrls;
    public List<String> getExcludedUrls() {
        return excludedUrls;
    }
    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...");

        String  requestUrl=request.getServletPath().toString();
        for (String url : excludedUrls) {
            if (requestUrl.equals(url)){
                System.out.println("this URL 不检查"+requestUrl);
                return true;
            }
        }

        /*在此执行检查*/
        System.out.println("执行检查中..."+requestUrl);

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");

        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");

        super.afterCompletion(request, response, handler, ex);
    }
}
