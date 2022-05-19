package com.co.indra.coinmarketcap.notifications.controllers;


import com.co.indra.coinmarketcap.notifications.model.entities.Notifications;
import com.co.indra.coinmarketcap.notifications.model.entities.UserNotificationsData;
import com.co.indra.coinmarketcap.notifications.model.requests.NotificationsDataRequest;
import com.co.indra.coinmarketcap.notifications.services.NotificationsService;
import com.co.indra.coinmarketcap.notifications.services.UserNotificationsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @Autowired
    private UserNotificationsDataService userNotificationsDataService;

    /********Comienzo de controladores para entidad Notifications*/

    //Crear nueva notificacion
    @PostMapping("/sendnotification")
    public void create(@RequestBody Notifications notifications){
        notificationsService.registerNotification(notifications);

    }

    //Obtener notificaciones por tipo de notificacion
    @GetMapping
    public List<Notifications> getNotificationsByType(@RequestParam(name = "searchnotification") String type){
        return notificationsService.getNotificationsByType(type);
    }

    //Obtener notificaciones por el id de la notificacion
    @GetMapping("/searchnotificationID")
    public List<Notifications> getNotificationsByIdNotifications(@RequestParam(name = "id") Long id_notifications){
        return notificationsService.getNotificationsByIdIdNotifications(id_notifications);

    }

    //Eliminar notificacion por medio del id
    @DeleteMapping
    public void remove(@RequestParam(name = "deletenotification") Long id_notifications){
        notificationsService.removeNotification(id_notifications);
    }
    
    


    /****************Comienzo de controladores para entidad UserNotificationData**/

    //Agregar a una notificacion sus datos de envio
    @PostMapping("/{id_notifications}/usernotificationsdata")
    public void createDataToNotification(@RequestBody NotificationsDataRequest request,
                                         @PathVariable("id_notifications") Long id_notifications){

        userNotificationsDataService.registerUserNotificationData(request.getMail(), request.getPhone_number(), id_notifications);

    }



    //Obtener los datos de envio segun el id de la notificacion suministrada por la URL
    @GetMapping ("/{id_notifications}/usernotificationsdata")
    public List<UserNotificationsData> getNotificationDataByIdNotification(
                                         @PathVariable("id_notifications") Long id_notifications){

        return userNotificationsDataService.getNotificationDataByIdNotification(id_notifications);

    }

    //Eliminar los datos de envio por medio del id Notifications FK
    @DeleteMapping ("/{id_notifications}/usernotificationsdata")
    public void removeUserDataByIdNotifications(@PathVariable("id_notifications") Long id_notifications){
        userNotificationsDataService.removeUserNotificationData(id_notifications);
    }


}
