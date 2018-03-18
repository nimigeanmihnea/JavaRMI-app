package remote;

import entity.Car;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPriceService extends Remote {

    double price(Car car) throws RemoteException;
}
