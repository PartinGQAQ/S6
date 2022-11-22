package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "FirstFilter",urlPatterns = "/*",initParams = {
        @WebInitParam(name = "ok",value = "initParam1"),
        @WebInitParam(name = "error",value = "initParam2")
})
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String p1 = filterConfig.getInitParameter("ok");
        String p2 = filterConfig.getInitParameter("error");
        System.out.println(p1 + "=====" + p2);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("到这里");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("回来");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
