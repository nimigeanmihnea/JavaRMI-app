package service;

import entity.Car;
import remote.ITaxService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TaxServiceImplementation extends UnicastRemoteObject implements ITaxService {

    private static final long serialVersionUID = 1L;

    public TaxServiceImplementation() throws RemoteException {}

    @Override
    public double tax(Car car) throws RemoteException {
        if (car.getEngineSize() <= 0) {
            throw new IllegalArgumentException("Engine capacity must be positive.");
        }
        int sum = 8;

        if(car.getEngineSize() > 1601) sum = 18;
        if(car.getEngineSize() > 2001) sum = 72;
        if(car.getEngineSize() > 2601) sum = 144;
        if(car.getEngineSize() > 3001) sum = 290;

        return car.getEngineSize() / 200.0 * sum;
    }

    public static void configure(){
        try{
            Registry registry = LocateRegistry.createRegistry(4447);
            registry.rebind("TaxCalculator", new TaxServiceImplementation());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
