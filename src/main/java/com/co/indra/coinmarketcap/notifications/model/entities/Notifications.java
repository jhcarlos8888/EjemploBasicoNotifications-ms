package com.co.indra.coinmarketcap.notifications.model.entities;




import java.io.Serializable;
import java.util.Date;

public class Notifications implements Serializable {


    private Long id_notifications;

    private String type;

    private String message;

    private Date sent_at;

    private Long id_user;


    public Notifications() {
    }

    //Constructor with attributes
    public Notifications(String type, String message, Long id_user) {
        this.type = type;
        this.message = message;
        this.id_user = id_user;
    }

    //Getters and Setters
    public Long getId_notifications() {
        return id_notifications;
    }

    public void setId_notifications(Long id_notifications) {
        this.id_notifications = id_notifications;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSent_at() {
        return sent_at;
    }

    public void setSent_at(Date sent_at) {
        this.sent_at = sent_at;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }
}