package org.mimo.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by Mirsad on 22.02.2015.
 */
@Entity
public class ChatMessage {
    @Id
    @GeneratedValue
    Long id;

    @OneToOne
    Person sender;

    @OneToOne
    Person receiver;

    String text;

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getReceiver() {
        return receiver;
    }

    public void setReceiver(Person receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

