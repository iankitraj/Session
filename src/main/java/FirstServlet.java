import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FirstServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        // Get parameters from form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String uname = request.getParameter("uname");

        // Create session and store user data
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("uname", uname);
        session.setMaxInactiveInterval(300); // 5-minute session timeout

        // Response with styled HTML
        pw.println("<html><head>");
        pw.println("<title>Registration Success</title>");
        pw.println("<style>");
        pw.println("body { text-align: center; font-family: Arial, sans-serif; background: linear-gradient(to right, #00c6ff, #0072ff); color: white; margin-top: 100px; }");
        pw.println(".container { background: white; padding: 20px; border-radius: 8px; display: inline-block; color: black; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2); }");
        pw.println("a { text-decoration: none; color: #0072ff; font-weight: bold; }");
        pw.println("a:hover { color: #0056b3; }");
        pw.println("</style></head><body>");

        pw.println("<div class='container'>");
        pw.println("<h2>Registration Successful! 🎉</h2>");
        pw.println("<p>Welcome, <b>" + name + "</b>! Your session is valid for 5 minutes.</p>");
        pw.println("<p><a href='Servlet_two'>Click here to view details</a></p>");
        pw.println("</div>");

        pw.println("</body></html>");
    }
}
