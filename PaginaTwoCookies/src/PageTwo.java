import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageTwo
 */
@WebServlet("/PageTwo")
public class PageTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageTwo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		boolean hasVisitedPageOne = false;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if ((c.getName().equals("visitedPageOne"))
						&& (c.getValue().equals("yes"))) {
					hasVisitedPageOne = true;
					break;

				}
			}
		}
		if (!hasVisitedPageOne) {
			response.sendRedirect("PageOne");
		} else {
			String title = "Page Two";
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String docType =
					"<!DOCTYPE HTML PUBLIC \"\n";
			out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title
					+ "</TITLE></HEAD>\n" + "<BODY BGCOLOR=\"#FDF5E6\">\n"
					+ "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n"
					+ "</BODY></HTML>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
