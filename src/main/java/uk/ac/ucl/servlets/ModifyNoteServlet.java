package uk.ac.ucl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/modifyNote.html")
public class ModifyNoteServlet extends MyAbstractServlet
{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String noteName = (String) request.getSession().getAttribute("index");
    if (noteName == null)
    {
      request.getSession().setAttribute("msg", "Please choose a note (from the list) that you want to modify.");
      request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
      return;
    }

    File file = new File(model.getPath(noteName));
    List<String> contents = model.noteReader.readTextFile(file);
    request.setAttribute(noteName, contents);

    String content;
    if ((content = request.getParameter("modifiedContent")) != null)
    {
      model.noteEditor.writeTextFile(file, content);
      contents = model.noteReader.readTextFile(file);
      request.setAttribute(noteName, contents);
    }

    doDispatch(request, response, "/modifyNote.jsp");
  }
}
