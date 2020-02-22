import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ThisFilter")
public class ThisFilter implements Filter {
    private FilterConfig filterConfig;

    public void destroy() {
        filterConfig = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String action = request.getParameter("thisAction");
        ServletContext servletContext = filterConfig.getServletContext();

        if (action != null && !"".equals(action)) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

}
