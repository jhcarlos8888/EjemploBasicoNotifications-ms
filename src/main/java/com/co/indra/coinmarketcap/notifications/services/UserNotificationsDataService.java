package com.co.indra.coinmarketcap.notifications.services;


import com.co.indra.coinmarketcap.notifications.model.entities.UserNotificationsData;
import com.co.indra.coinmarketcap.notifications.repositories.UserNotificationsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserNotificationsDataService {

    @Autowired
    private UserNotificationsDataRepository userNotificationsDataRepository;

    public void registerUserNotificationData(String mail, String phone_number, Long id_notifications){

        if(mail == null || phone_number == null){
            throw new RuntimeException("Dates Empty");
        }

        userNotificationsDataRepository.createUserNotificationData(new UserNotificationsData(mail,phone_number,id_notifications));

    }


    public void removeUserNotificationData(Long id_notifications){
        userNotificationsDataRepository.deleteUserDataByIdNotification(id_notifications);
    }


    public List<UserNotificationsData> getNotificationDataByIdNotification(Long id_notifications){

        return userNotificationsDataRepository.findByIdNotifications(id_notifications);
    }








}
