package it.objectmethod.esercizi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.esercizi.dao.CountryDao;

public class ContinentiServlet extends HttpServlet {

	private static final long serialVersionUID = 3843200224539693449L;
	
	protected void doGet(HttpServletRequest richiesta, HttpServletResponse risposta)
			throws ServletException, IOException {
		
		CountryDao dao = new CountryDao();

		List<String> listaContinenti = dao.getContinents();

		richiesta.setAttribute("continenti", listaContinenti);
		richiesta.getRequestDispatcher("/pages/ShowContinents.jsp").forward(richiesta, risposta);
	}

}
