package uk.ac.ucl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/renameNote.html")
public class RenameNoteServlet extends MyAbstractServlet
{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String noteName = (String) request.getSession().getAttribute("index");
    if (noteName == null)
    {
      request.getSession().setAttribute("msg", "Please choose a note (from the list) that you want to rename.");
      request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
      return;
    }

    File oldFile = new File(model.getPath(noteName));
    String newName;
    if ((newName = request.getParameter("newName")) != null && !"".equals(newName))
    {
      // guarantee the name of each note is unique
      if (model.noteReader.getIndexNamesInOrderAdded().contains(newName))
      {
        request.getSession().setAttribute("msg", "Note [" + newName + "] has already existed. Please change a name.");
        request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        return;
      }
      else
      {
        File newFile = new File(model.getPath(newName));
        model.noteEditor.renameFile(oldFile, newFile);
      }

    }

    doDispatch(request, response, "/renameNote.jsp");
  }
}
