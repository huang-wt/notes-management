package uk.ac.ucl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/deleteNote.html")
public class DeleteNoteServlet extends MyAbstractServlet
{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String noteName = (String) request.getSession().getAttribute("index");
    if (noteName == null)
    {
      request.getSession().setAttribute("msg", "Please choose a note (from the list) that you want to delete.");
      request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
      return;
    }

    File file = new File(model.getPath(noteName));
    if ("yes".equals(request.getParameter("option")))
    {
      model.noteEditor.deleteFile(file);
    }

    doDispatch(request, response, "/deleteNote.jsp");
  }
}
