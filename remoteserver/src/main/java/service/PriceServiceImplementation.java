package service;

import entity.Car;
import remote.IPriceService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

public class PriceServiceImplementation extends UnicastRemoteObject implements IPriceService {

    private static final long serialVersionUID = 1L;

    public PriceServiceImplementation() throws RemoteException {}

    @Override
    public double price(Car car) throws RemoteException{

        if(car.getYear() >= 2017)
            throw new IllegalArgumentException("Fabrication year can't be larger than current year!");

        return (car.getPrice() - ((car.getPrice()/7)) * (Calendar.getInstance().get(Calendar.YEAR) - car.getYear()));
    }
}
