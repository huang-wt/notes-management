package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

abstract public class MyAbstractServlet extends HttpServlet
{
  protected Model model = ModelFactory.getModel();

  // Invoke the JSP page.
  protected void doDispatch(HttpServletRequest request, HttpServletResponse response, String jspName) throws ServletException, IOException {
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher(jspName);
    dispatch.forward(request, response);
  }
}
