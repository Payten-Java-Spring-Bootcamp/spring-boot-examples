package com.ibrahim.events.event;

import org.springframework.context.ApplicationEvent;

//service bunu firlatir
//event listener bunu dinler
public class ReservationCreatedEvent extends ApplicationEvent {

    public ReservationCreatedEvent(Object source) {
        super(source);
    }
}
