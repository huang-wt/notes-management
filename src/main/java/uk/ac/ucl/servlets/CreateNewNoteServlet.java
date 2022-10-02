package uk.ac.ucl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/newNoteServlet")
public class CreateNewNoteServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String noteName;
        if ((noteName = request.getParameter("noteName")) != null) {
            String content;

            // Guarantee the name of each note is unique
            if (model.getIndexNamesInOrderAdded().contains(noteName)) {
                request.getSession().setAttribute("msg", "Note [" + noteName + "] has already existed. Please change a name.");
                request.getRequestDispatcher("/pages/note/errorPage.jsp").forward(request, response);
                return;
            }

            // Display name and content in the text area after saving the note
            if ((content = request.getParameter("noteContent")) != null) {
                model.writeTextFile(noteName, content);

                request.getSession().setAttribute("newIndex", noteName);
                List<String> contents = model.readTextFile(noteName);
                request.setAttribute(noteName, contents);
            }

        } else {
            request.getSession().setAttribute("newIndex", "");
        }

        request.getRequestDispatcher("/pages/note/newNote.jsp").forward(request, response);
    }
}
