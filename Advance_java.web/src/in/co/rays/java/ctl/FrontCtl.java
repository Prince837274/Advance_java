package in.co.rays.java.ctl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(filterName = "FrontCtl", urlPatterns = {"*.do"})
public class FrontCtl implements Filter{


	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		
		System.out.println("uri =>" + uri);
		
		HttpSession session = req.getRequestURI()
	}


}
