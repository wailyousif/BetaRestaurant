package com.restx.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by wailm.yousif on 3/28/17.
 */

@Service
public class CronJobs
{


    @Autowired
    JMail jMail;

    private static final String mailBodyFormat = "Hello %s," + "" +
            "<br />" + "" +
            "<br />" +
            "HomeFinder found the home of your dream. " +
            "<a href=\"http://localhost:8080/finder.jsp?%s\">%s</a> " +
            "is one gorgeous property that matches your saved search with us. " +
            "Please, click on <a href=\"http://localhost:8080/finder.jsp?%s\">here</a> to have more information." +
            "<br />" +
            "<br />" +
            "<div style=\"text-align:center\"><img src=\"cid:image\" /></div>" +
            "<br />" +
            "<br />" +
            "<br />" +
            "To stop receiving emails from HomeFinder, you can click <a href=\"http://localhost:8080/mvc/user/emailunsub?id=%d\">here</a>." +
            "<br />" +
            "<br />" +
            "You can save your search again at any time from our home page." + "" +
            "<br />" +
            "Thanks!";



    @Scheduled(initialDelay = 7000, fixedRate = 15000)
    public void automatedEmail()
    {
        /*
        String mailBody = String.format(mailBodyFormat, customerName,
                            queryString, propName, queryString, ss.getId());

        String imgPath = "u" + updatedProperty.getProperty().getAppUser().getId() +
                            "/" + updatedProperty.getProperty().getPic();

        jMail.sendMail(ss.getAppUser().getEmail(), mailSubject, mailBody, imgPath);
        */
    }
}
