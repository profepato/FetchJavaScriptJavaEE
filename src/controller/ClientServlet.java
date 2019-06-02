package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Client;
import model.ClientDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@WebServlet(name = "ClientServlet", urlPatterns = {"/clients.do", "/otro.do"})
public class ClientServlet extends HttpServlet {

    private Gson gson;
    private ClientDaoImpl clientDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        gson = new Gson();
        clientDao = new ClientDaoImpl();

        // Recibir el name por get
        String name = request.getParameter("clientName");

        // llamar a la función readBy(name)ç
        List<Client> clients = clientDao.readBy(name);

        // transformar esa lista java en una json con la ayuda de GSon
        Type listType = new TypeToken<List<Client>>() {}.getType();
        String jsonResponse = gson.toJson(clients, listType);

        // imprimir ese objeto PrintWriter de response
        response.getWriter().println(jsonResponse);
    }
}
