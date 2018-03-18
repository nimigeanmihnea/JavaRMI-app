package servlet;

import entity.Car;
import remote.IPriceService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@WebServlet("/PriceServlet")
public class PriceServlet extends HttpServlet {

    private static IPriceService lookUp;
    private Registry registry;

    public PriceServlet(){
        super();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        PrintWriter printWriter = null;

        int year = Integer.parseInt(request.getParameter("year"));
        double price = Double.parseDouble(request.getParameter("price"));

        try {
            printWriter = response.getWriter();
            registry = LocateRegistry.getRegistry(9010);
            lookUp = (IPriceService) registry.lookup("PriceCalculator");
            printWriter.print("<br>Price value: " + lookUp.price(new Car(year, price)) + "<br>");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }
}
