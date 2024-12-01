package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.User;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.Impl.UserServiceImpl;
import vn.iotstar.utils.Email;

@WebServlet(urlPatterns = { "/forgotpass" })
public class ForgotPassword extends HttpServlet {

	IUserService userService = new UserServiceImpl();
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/User/forgotpassword.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
	
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			User user = userService.findByPhone(phone);
			
			if (user.getEmail().equals(email) && user.getPhone().equals(phone)) {
				Email sm = new Email();
				
				boolean test =sm.EmailSend(user);
				
				if (test) {
					
					req.setAttribute("alert", "chung toi da gui lai mat khau qua email cua ban. Hay kiem tra nhe!");
					
				}else {
					req.setAttribute("error", "loi gui mail");
				}
			}else {
				req.setAttribute("error", "user hoac email khong ton tai tren he thong");
				req.getRequestDispatcher("/views/User/forgotpassword.jsp").forward(req, resp);
				return;
			}
			
			req.getRequestDispatcher("/views/User/login.jsp").forward(req, resp);
			
		}
	
	
	
	}

