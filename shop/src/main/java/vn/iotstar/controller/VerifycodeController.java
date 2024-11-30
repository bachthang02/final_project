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

@WebServlet(urlPatterns = { "/VerifyCode" })
public class VerifycodeController extends HttpServlet {

	IUserService userService = new UserServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("views/User/verify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/hmtl;charset=UTF-8");
		try (PrintWriter out = resp.getWriter()) {

			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("account");

			String code = req.getParameter("authcode");

			if (code.equals(user.getSalt())) {
				user.setEmail(user.getEmail());
				;

				out.println("<div class=\"container\"><br/>\r\n" + "         <br/>\r\n"
						+ "       <br/> kich hoat tai khoan thanh cong!<br/>\r\n" + "     <br/>\r\n"
						+ "       <br/><div>");
			} else {
				out.println("<div class=\"container\"><br/>\r\n" + "         <br/>\r\n"
						+ "       <br/> sai ma kich hoat, vui long kiem tra lai<br/>\r\n" + "     <br/>\r\n"
						+ "       <br/><div>");
			}

		}

	}
}
