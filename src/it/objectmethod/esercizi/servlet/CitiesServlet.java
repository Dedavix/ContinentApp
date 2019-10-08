package it.objectmethod.esercizi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.esercizi.dao.CityDao;
import it.objectmethod.esercizi.data.City;

public class CitiesServlet extends HttpServlet {

	private static final long serialVersionUID = -2483241600540286787L;

	protected void doGet(HttpServletRequest richiesta, HttpServletResponse risposta)
			throws ServletException, IOException {
		
		CityDao dao = new CityDao();
		String codice = null;

		List<City> citta = new ArrayList<City>();
		codice = richiesta.getParameter("code");
		citta = dao.getCities(codice);
		
		richiesta.setAttribute("listaCitta", citta);
		richiesta.getRequestDispatcher("/pages/ShowCities.jsp").forward(richiesta, risposta);
	}

}
