package com.co.indra.coinmarketcap.notifications.services;


import com.co.indra.coinmarketcap.notifications.model.entities.Notifications;
import com.co.indra.coinmarketcap.notifications.repositories.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsService {

     @Autowired
    private NotificationsRepository notificationsRepository;



    public void registerNotification(Notifications notifications){

        notificationsRepository.createNotification(notifications);

    }

    public void removeNotification(Long id_notifications){
        notificationsRepository.deleteNotification(id_notifications);
    }



     public List<Notifications> getNotificationsByType(String type){

         return notificationsRepository.findByType(type);
     }


     public List<Notifications> getNotificationsByIdIdNotifications(Long id_notifications){

        return notificationsRepository.findByIdNotifications(id_notifications);
     }



}
