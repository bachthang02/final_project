package vn.iotstar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.User;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.Impl.UserServiceImpl;
import vn.iotstar.utils.Email;

@WebServlet(urlPatterns = { "/register" })
public class Register extends HttpServlet{

	IUserService userService = new UserServiceImpl();
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/User/register.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			// lay tham so tu form
			String phone = req.getParameter("phone");
			String hashed_password = req.getParameter("hashed_password");
			String email = req.getParameter("email");
			String lastname = req.getParameter("lastname");
			String firstname= req.getParameter("firstname");
			
	
			String alertMsg = "";
	
			if (userService.checkExistEmail(email)) {
				alertMsg = "Email da ton tai";
				req.setAttribute("error", alertMsg);
				req.getRequestDispatcher("/views/User/register.jsp").forward(req, resp);
	
			} else if (userService.checkExistPhone(phone)) {
				alertMsg = "tai khoan da ton tai";
				req.setAttribute("error", alertMsg);
				req.getRequestDispatcher("/views/User/register.jsp").forward(req, resp);
	
			} else {
	
				Email sm = new Email();
				// get the 6-digit code
				String salt = sm.getRandom();
	
				// create new user using all information
				User user = new User(lastname, email, phone, salt);
	
				boolean test = sm.sendEmail(user);
	
				if (test) {
					// tao session
					HttpSession session = req.getSession();
					session.setAttribute("account", user);
	
					boolean isSuccess = userService.register(firstname, lastname, email, phone, salt, hashed_password);
	
					if (isSuccess) {
	
						resp.sendRedirect(req.getContextPath() + "/VerifyCode");
	
					} else {
						alertMsg = "loi he thong";
						req.setAttribute("error", alertMsg);
						req.getRequestDispatcher("/views/User/register.jsp").forward(req, resp);
					}
	
				} else {
					PrintWriter out = resp.getWriter();
					out.print("loi khi gui mail !!!!");
				}
			}

	}
}
