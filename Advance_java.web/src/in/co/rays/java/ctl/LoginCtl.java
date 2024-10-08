package in.co.rays.java.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import in.co.rays.java.bean.UserBean;
import in.co.rays.java.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		if (op != null && op.equals("logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
		}
		resp.sendRedirect("LoginView.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String op = req.getParameter("operation");
		
		HttpSession session = req.getSession();
		
		if(op.equals("SignIn")) {
		UserModel model = new UserModel();
		
		

		try {
			UserBean bean = model.Authenticate(loginId, password);
			if (bean != null) {
				session.setAttribute("user", bean);
				RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("msg", "loginId & password invalid");
				RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
		
		if(op.equals("SignUp")) {
			resp.sendRedirect("UserRegistrationCtl");
		}

	}

}
