/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ryank
 */
public class DateUtils {

    public static Date stringToDate(String date) {

        //  Date dateResult=new SimpleDateFormat("dd-MM-yyyy").parse(date); 
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateResult = null;
        try {
            dateResult = formatter.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.sql.Date sql = new java.sql.Date(dateResult.getTime());
        return sql;

    }

    public static Date convertMillisToDate(Date date) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return stringToDate(strDate);

    }
}
