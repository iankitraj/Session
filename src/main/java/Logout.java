import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Logout() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        // Retrieve session if exists
        HttpSession session = request.getSession(false); // Don't create new session

        pw.println("<html><head>");
        pw.println("<title>Logout</title>");
        pw.println("<style>");
        pw.println("body { text-align: center; font-family: Arial, sans-serif; background: linear-gradient(to right, #ff416c, #ff4b2b); color: white; padding-top: 50px; }");
        pw.println(".container { background: white; padding: 20px; border-radius: 10px; display: inline-block; color: black; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2); animation: fadeIn 1s ease-in-out; }");
        pw.println("@keyframes fadeIn { from { opacity: 0; transform: translateY(-20px); } to { opacity: 1; transform: translateY(0); } }");
        pw.println("a { text-decoration: none; color: #ff4b2b; font-weight: bold; }");
        pw.println("a:hover { color: #c72d1f; }");
        pw.println("</style></head><body>");

        pw.println("<div class='container'>");

        if (session != null) {
            session.invalidate(); // Destroy session
            pw.println("<h2>Logged Out Successfully! ✅</h2>");
            pw.println("<p>You have been successfully logged out.</p>");
        } else {
            pw.println("<h2>No Active Session Found ⏳</h2>");
            pw.println("<p>You were not logged in, or your session has already expired.</p>");
        }

        pw.println("<p><a href='Login.jsp'>Go to Registration Page</a></p>");
        pw.println("</div>");
        pw.println("</body></html>");
    }
}
