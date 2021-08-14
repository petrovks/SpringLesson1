package ru.gb.webapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(new Product(i, "title" + i, i * 100));
        }
        resp.setContentType("text/html;charset:UTF-8");
        resp.getWriter().printf("<html><body>");
        for (Product p: list) {
            resp.getWriter().printf("<h1>%d %s %d</h1>", p.getId(), p.getTitle(), p.getCost());
        }
        resp.getWriter().printf("</html></body>");
    }
}
