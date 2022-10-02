package uk.ac.ucl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/modifyNoteServlet")
public class ModifyNoteServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String noteName = (String) request.getSession().getAttribute("index");
        if (noteName == null) {
            request.getSession().setAttribute("msg", "Please choose a note (from the list) that you want to modify.");
            request.getRequestDispatcher("/pages/note/errorPage.jsp").forward(request, response);
            return;
        }

        List<String> contents = model.readTextFile(noteName);
        request.setAttribute(noteName, contents);

        String content;
        if ((content = request.getParameter("modifiedContent")) != null) {
            model.writeTextFile(noteName, content);
            contents = model.readTextFile(noteName);
            request.setAttribute(noteName, contents);
        }

        request.getRequestDispatcher("/pages/note/modifyNote.jsp").forward(request, response);
    }
}
