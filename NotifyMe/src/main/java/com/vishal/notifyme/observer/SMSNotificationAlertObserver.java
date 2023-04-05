package com.vishal.notifyme.observer;

import com.vishal.notifyme.observable.IStockObservable;
import com.vishal.notifyme.observable.IphoneObservable;
import com.vishal.notifyme.observer.INotificationAlertObserver;

public class SMSNotificationAlertObserver implements INotificationAlertObserver {

    private String mobileNo;
    private IStockObservable obj;

    public SMSNotificationAlertObserver(String mobileNo, IStockObservable obj) {
        this.mobileNo = mobileNo;
        this.obj = obj;
    }

    @Override
    public void updateSubscriber() {
        sendSMS(mobileNo, "Product is in stock, hurry up!!!");
    }

    private void sendSMS(String email, String msg){
        System.out.println("SMS sent to mobile no. "+mobileNo + " "+msg);
    }
}
