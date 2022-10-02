package uk.ac.ucl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/renameNoteServlet")
public class RenameNoteServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String noteName = (String) request.getSession().getAttribute("index");
        if (noteName == null) {
            request.getSession().setAttribute("msg", "Please choose a note (from the list) that you want to rename.");
            request.getRequestDispatcher("/pages/note/errorPage.jsp").forward(request, response);
            return;
        }
        String newName;
        if ((newName = request.getParameter("newName")) != null && !"".equals(newName)) {
            // guarantee the name of each note is unique
            if (model.getIndexNamesInOrderAdded().contains(newName)) {
                request.getSession().setAttribute("msg", "Note [" + newName + "] has already existed. Please change a name.");
                request.getRequestDispatcher("/pages/note/errorPage.jsp").forward(request, response);
                return;
            }
            else {
                model.renameFile(noteName, newName);
            }

        }

        request.getRequestDispatcher("/pages/note/renameNote.jsp").forward(request, response);
    }
}
