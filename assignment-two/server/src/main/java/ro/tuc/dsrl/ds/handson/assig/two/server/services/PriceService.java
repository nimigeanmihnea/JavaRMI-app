package ro.tuc.dsrl.ds.handson.assig.two.server.services;

import ro.tuc.dsrl.ds.handson.assig.two.common.entities.Car;
import ro.tuc.dsrl.ds.handson.assig.two.common.serviceinterfaces.ISellPrice;

public class PriceService implements ISellPrice {

    @Override
    public double computeSellingPrice(Car c){
        return (c.getPurchasingPrice() - ((c.getPurchasingPrice()/7) * (2015 - c.getYear())));
    }
}
