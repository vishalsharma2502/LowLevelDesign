package com.vishal.notifyme;

import com.vishal.notifyme.observable.IStockObservable;
import com.vishal.notifyme.observable.IphoneObservable;
import com.vishal.notifyme.observer.EmailNotificationAlertObserverImpl;
import com.vishal.notifyme.observer.INotificationAlertObserver;
import com.vishal.notifyme.observer.SMSNotificationAlertObserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class NotifyMeApplication {

    public static void main(String[] args) {
        //SpringApplication.run(NotifyMeApplication.class, args);


        IStockObservable iphoneStockObservable = new IphoneObservable();

        INotificationAlertObserver observer1 = new EmailNotificationAlertObserverImpl("abc@gmail.com", iphoneStockObservable);
        INotificationAlertObserver observer2 = new EmailNotificationAlertObserverImpl("abc@gmail.com", iphoneStockObservable);
        INotificationAlertObserver observer3 = new SMSNotificationAlertObserver("9891000000", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.updateData(10);
    }



}
