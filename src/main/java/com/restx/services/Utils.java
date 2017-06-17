package com.restx.services;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wailm.yousif on 3/5/17.
 */
public class Utils
{
    public static final String TENANT_HEADER = "x-tenantid";
    public static final String emptyString = "";
    public static DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    public static boolean isBrowser(HttpServletRequest request)
    {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.contains("MSIE") || userAgent.contains("Firefox") || userAgent.contains("Chrome") ||
                userAgent.contains("Opera") || userAgent.contains("Safari"))
        {
            return true;
        }
        return false;
    }


    public static String ConvertEpochToDateString(Long epochTime)
    {
        Date currentTime = new Date(epochTime * 1000);
        return currentTime.toString();
    }

    public static String ConvertToWeekDay(Long epochTime)
    {
        Date currentTime = new Date(epochTime * 1000);
        DateFormat dateFormat = new SimpleDateFormat("EEEE");
        String weekDay = dateFormat.format(currentTime);
        return weekDay;
    }
}
