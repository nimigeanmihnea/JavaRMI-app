import service.PriceServiceImplementation;
import service.TaxServiceImplementation;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.createRegistry(9010);
            registry.bind("PriceCalculator", new PriceServiceImplementation());
            registry.bind("TaxCalculator", new TaxServiceImplementation());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
