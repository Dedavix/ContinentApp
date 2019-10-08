package it.objectmethod.esercizi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.objectmethod.esercizi.dao.CountryDao;
import it.objectmethod.esercizi.data.Country;

public class CountriesServlet extends HttpServlet {

	private static final long serialVersionUID = -8130210470244845978L;


	protected void doGet(HttpServletRequest richiesta, HttpServletResponse risposta)
			throws ServletException, IOException {

		List<Country> nazioni = new ArrayList<Country>();
		CountryDao dao = new CountryDao();
		String continente = null;
		if (richiesta.getParameter("continentSel") != null) {
			continente = richiesta.getParameter("continentSel");
		}else {
			continente = (String) richiesta.getSession().getAttribute("continentSes");
		}
		richiesta.getSession().setAttribute("continentSes", continente);
		nazioni = dao.getCountries(continente);
		richiesta.setAttribute("nazioni", nazioni);
		richiesta.getRequestDispatcher("/pages/ShowCountries.jsp").forward(richiesta, risposta);
	}
	
}
