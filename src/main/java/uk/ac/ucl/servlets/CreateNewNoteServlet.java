package uk.ac.ucl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/newNote.html")
public class CreateNewNoteServlet extends MyAbstractServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    String noteName;
    if ((noteName = request.getParameter("noteName")) != null)
    {
      String content;

      // guarantee the name of each note is unique
      if (model.noteReader.getIndexNamesInOrderAdded().contains(noteName))
      {
        request.getSession().setAttribute("msg", "Note [" + noteName + "] has already existed. Please change a name.");
        request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        return;
      }

      // display name and content in the text area after saving the note
      if ((content = request.getParameter("noteContent")) != null)
      {
        File file = new File(model.getPath(noteName));
        model.noteEditor.writeTextFile(file, content);

        request.getSession().setAttribute("newIndex", noteName);
        List<String> contents = model.noteReader.readTextFile(file);
        request.setAttribute(noteName, contents);
      }

    }
    else
    {
      request.getSession().setAttribute("newIndex", "");
    }

    doDispatch(request, response, "/newNote.jsp");
  }
}
