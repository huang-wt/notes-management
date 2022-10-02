package uk.ac.ucl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteNoteServlet")
public class DeleteNoteServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String noteName = (String) request.getSession().getAttribute("index");
        if (noteName == null) {
            request.getSession().setAttribute("msg", "Please choose a note (from the list) that you want to delete.");
            request.getRequestDispatcher("/pages/note/errorPage.jsp").forward(request, response);
            return;
        }

        if ("yes".equals(request.getParameter("option"))) {
            model.deleteFile(noteName);
        }

        request.getRequestDispatcher("/pages/note/deleteNote.jsp").forward(request, response);
    }
}
