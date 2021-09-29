package com.ibrahim.events.event.listener;

import com.ibrahim.events.event.ReservationCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationEventListener {

    @EventListener
    public void reservationEventHandler(ReservationCreatedEvent reservationCreatedEvent) throws InterruptedException { //parametre tipinden yakalayacagi event i anliyor
        Thread.sleep(5000); //request geldikten 5 saniye sonra handle ettigini varsayalim
        System.out.println("EventListener -> " + reservationCreatedEvent.getSource().toString());
    }
}
