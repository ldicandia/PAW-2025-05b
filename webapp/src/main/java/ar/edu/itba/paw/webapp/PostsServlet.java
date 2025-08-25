// src/main/java/webapp/MarketServlet.java
package ar.edu.itba.paw.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet(name="PostsServlet", urlPatterns={"/posts"})
public class PostsServlet extends HttpServlet {
    private VinylService service = new VinylService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        req.setAttribute("vinylList", service.listAll());
        req.getRequestDispatcher("/WEB-INF/jsp/helloworld/posts.jsp").forward(req, resp);
    }
}
