package uk.ac.ucl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewNote.html")
public class ViewNoteServlet extends MyAbstractServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    List<String> noteNames = model.noteReader.getIndexNamesInOrderAdded();
    request.getSession().setAttribute("index", null);

    if ("sorted".equals(request.getParameter("order")))
    {
      noteNames = model.noteReader.getIndexNamesInSortedOrder();
    }
    request.setAttribute("noteNames", noteNames);

    String noteName;
    if ((noteName = request.getParameter("index")) != null)
    {
      File file = new File(model.getPath(noteName));
      List<String> contents = model.noteReader.readTextFile(file);
      request.setAttribute(noteName, contents);

      // set the current note name in the higher level
      request.getSession().setAttribute("index", noteName);
    }

    doDispatch(request, response, "/viewNote.jsp");
  }
}