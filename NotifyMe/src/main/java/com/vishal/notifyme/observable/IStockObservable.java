package com.vishal.notifyme.observable;

import com.vishal.notifyme.observer.INotificationAlertObserver;

public interface IStockObservable {

    void add(INotificationAlertObserver observer);
    void remove(INotificationAlertObserver observer);
    void notifySubsribers();
    void updateData(int stock);
    void resetStock();


}
