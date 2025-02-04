import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet_two")
public class Servlet_two extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servlet_two() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        // Retrieve existing session
        HttpSession session = request.getSession(false); // Prevents creating a new session

        pw.println("<html><head>");
        pw.println("<title>Session Details</title>");
        pw.println("<style>");
        pw.println("body { text-align: center; font-family: Arial, sans-serif; background: linear-gradient(to right, #00c6ff, #0072ff); color: white; padding-top: 50px; }");
        pw.println(".container { background: white; padding: 20px; border-radius: 10px; display: inline-block; color: black; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2); animation: fadeIn 1s ease-in-out; }");
        pw.println("@keyframes fadeIn { from { opacity: 0; transform: translateY(-20px); } to { opacity: 1; transform: translateY(0); } }");
        pw.println("a { text-decoration: none; color: #0072ff; font-weight: bold; }");
        pw.println("a:hover { color: #0056b3; }");
        pw.println("</style></head><body>");

        pw.println("<div class='container'>");

        if (session == null || session.getAttribute("uname") == null) {
            pw.println("<h2>Session Expired! ⏳</h2>");
            pw.println("<p>Your session has expired. Please register again.</p>");
            pw.println("<p><a href='Login.jsp'>Go to Register Page</a></p>");
        } else {
            // Retrieve session attributes
            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            String uname = (String) session.getAttribute("uname");

            pw.println("<h2>Registration Details 🎉</h2>");
            pw.println("<p><b>Name:</b> " + name + "</p>");
            pw.println("<p><b>Email:</b> " + email + "</p>");
            pw.println("<p><b>Username:</b> " + uname + "</p>");
            pw.println("<p><a href='Logout'>Logout</a></p>");
        }

        pw.println("</div>");
        pw.println("</body></html>");
    }
}
