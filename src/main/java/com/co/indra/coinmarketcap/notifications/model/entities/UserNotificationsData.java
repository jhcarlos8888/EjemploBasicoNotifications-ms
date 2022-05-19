package com.co.indra.coinmarketcap.notifications.model.entities;


import java.io.Serializable;



public class UserNotificationsData implements Serializable {

    private Long id_user_notifications;

    private String mail;

    private String phone_number;

    private Long id_notifications;



    //Constructor empty
    public UserNotificationsData() {
    }

    //constructor with attributes
    public UserNotificationsData(String mail, String phone_number, Long id_notifications) {
        this.mail = mail;
        this.phone_number = phone_number;
        this.id_notifications = id_notifications;
    }

    //Getters and Setters
    public Long getId_user_notifications() {
        return id_user_notifications;
    }

    public void setId_user_notifications(Long id_user_notifications) {
        this.id_user_notifications = id_user_notifications;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Long getId_notifications() {
        return id_notifications;
    }
    
    public void setId_notifications(Long id_notifications) {
        this.id_notifications = id_notifications;
    }

   
}
