package com.co.indra.coinmarketcap.notifications.repositories;


import com.co.indra.coinmarketcap.notifications.model.entities.UserNotificationsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


class UserNotificationsDataRowMapper implements RowMapper<UserNotificationsData> {

    @Override
    public UserNotificationsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserNotificationsData userNotificationsData = new UserNotificationsData();
        userNotificationsData.setId_user_notifications(rs.getLong("id_user_notifications"));
        userNotificationsData.setMail(rs.getString("mail"));
        userNotificationsData.setPhone_number(rs.getString("phone_number"));
        userNotificationsData.setId_notifications(rs.getLong("id_notifications"));
        return userNotificationsData;
    }
}




@Repository
public class UserNotificationsDataRepository {

    @Autowired
    private JdbcTemplate template;

    //Se crea un nuevo registro de los datos de envio de notificacion de un usuario
    public void createUserNotificationData(UserNotificationsData userNotificationsData) {

        template.update("INSERT INTO tbl_user_notifications_data (mail,phone_number,id_notifications) values(?,?,?)",

                userNotificationsData.getMail(), userNotificationsData.getPhone_number(), userNotificationsData.getId_notifications());

    }


    //Se buscan los datos de envio de  notificacion de un usuario por el id de notificacion
    //para saber a que datos se han enviado determinadas notificaciones
    public List<UserNotificationsData> findByIdNotifications(Long id_notifications) {

        return template.query(
                "SELECT id_user_notifications, mail, phone_number, id_notifications FROM tbl_user_notifications_data WHERE id_notifications =?",
                new UserNotificationsDataRowMapper(),
                id_notifications);


    }

    //Se eliminan los datos de envio segun el id Notifications
    public void deleteUserDataByIdNotification(Long id_notifications){

        template.update("DELETE FROM tbl_user_notifications_data WHERE id_notifications = ?",
                id_notifications);

    }





}