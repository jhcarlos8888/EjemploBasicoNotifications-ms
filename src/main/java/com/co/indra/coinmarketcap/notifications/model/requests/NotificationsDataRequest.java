package com.co.indra.coinmarketcap.notifications.model.requests;



public class NotificationsDataRequest {

    private String mail;

    private String phone_number;


    public NotificationsDataRequest() {
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

}
