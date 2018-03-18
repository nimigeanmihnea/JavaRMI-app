package servlet;

import entity.Car;
import remote.ITaxService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@WebServlet("/TaxServlet")
public class TaxServlet extends HttpServlet {

    private static ITaxService lookUp;
    private Registry registry;

    public TaxServlet(){
        super();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        PrintWriter printWriter = null;

        int year = Integer.parseInt(request.getParameter("year"));
        int engineSize = Integer.parseInt(request.getParameter("size"));

        try {
            printWriter = response.getWriter();
            registry = LocateRegistry.getRegistry(9010);
            lookUp = (ITaxService) registry.lookup("TaxCalculator");
            printWriter.print("<br>Tax value: " + lookUp.tax(new Car(year, engineSize)) + "<br>");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }
}
