package net.itinajero.dto;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
     String user = request.getParameter("username");
     String pass = request.getParameter("password");
     String url = "login.jsp";
     if (user.equals("admin") && pass.equals("mypass")){
        HttpSession session = request.getSession();
        Usuario u = new Usuario(1);
        u.setUsername(user);
        u.setPassword(pass);
        session.setAttribute("user", u);
        url="/cliente.xhtml";
     }
     RequestDispatcher rd = request.getRequestDispatcher(url);
     rd.forward(request, response);
   }
}
