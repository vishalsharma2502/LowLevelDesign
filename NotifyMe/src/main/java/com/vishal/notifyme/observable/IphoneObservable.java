package com.vishal.notifyme.observable;

import com.vishal.notifyme.observer.INotificationAlertObserver;

import java.util.HashSet;
import java.util.Set;

public class IphoneObservable implements IStockObservable {

    private Set<INotificationAlertObserver> subscriberList = new HashSet<>();
    private int stock = 0;

    @Override
    public void add(INotificationAlertObserver obj) {
        subscriberList.add(obj);
    }

    @Override
    public void remove(INotificationAlertObserver obj) {
        subscriberList.remove(obj);

    }
    @Override
    public void notifySubsribers() {
        for(INotificationAlertObserver observer : subscriberList){
            observer.updateSubscriber();
        }
    }

    @Override
    public void updateData(int stock) {
        if(this.stock == 0){
            notifySubsribers();
        }
        this.stock += stock;
    }

    @Override
    public void resetStock() {
        this.stock = 0;
    }

    public int getStock(){
        return this.stock;
    }
}
