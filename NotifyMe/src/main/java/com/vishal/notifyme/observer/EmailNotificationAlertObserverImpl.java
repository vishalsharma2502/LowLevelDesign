package com.vishal.notifyme.observer;

import com.vishal.notifyme.observable.IStockObservable;
import com.vishal.notifyme.observable.IphoneObservable;

public class EmailNotificationAlertObserverImpl implements INotificationAlertObserver {

    private String email;
    private IStockObservable observable;

    public EmailNotificationAlertObserverImpl(String email, IStockObservable observable) {
        this.email = email;
        this.observable = observable;
    }


    @Override
    public void updateSubscriber() {

        sendMail(email, "Product is in stock, hurry up!!!");
    }

    private void sendMail(String email, String msg){
        System.out.println("Email sent to "+email + " "+msg);
    }
}
