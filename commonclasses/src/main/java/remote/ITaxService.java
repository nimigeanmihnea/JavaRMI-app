package remote;

import entity.Car;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITaxService extends Remote {

    double tax(Car car) throws RemoteException;
}
