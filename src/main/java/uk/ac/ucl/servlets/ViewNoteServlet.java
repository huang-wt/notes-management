package uk.ac.ucl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewNoteServlet")
public class ViewNoteServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<String> noteNames = model.getIndexNamesInOrderAdded();
        request.getSession().setAttribute("index", null);

        if ("sorted".equals(request.getParameter("order"))) {
            noteNames = model.getIndexNamesInSortedOrder();
        }
        request.setAttribute("noteNames", noteNames);

        String noteName;
        if ((noteName = request.getParameter("index")) != null) {
            List<String> contents = model.readTextFile(noteName);
            request.setAttribute(noteName, contents);

            // Set the current note name in the higher Scope
            request.getSession().setAttribute("index", noteName);
        }

        request.getRequestDispatcher("/pages/note/viewNote.jsp").forward(request, response);
    }
}