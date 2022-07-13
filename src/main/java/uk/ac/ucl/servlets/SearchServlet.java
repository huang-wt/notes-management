package uk.ac.ucl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/runsearch.html")
public class SearchServlet extends MyAbstractServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    List<String> searchResult = model.searcher.searchFor(request.getParameter("searchstring"));
    request.setAttribute("result", searchResult);

    doDispatch(request, response, "/searchResult.jsp");
  }
}
