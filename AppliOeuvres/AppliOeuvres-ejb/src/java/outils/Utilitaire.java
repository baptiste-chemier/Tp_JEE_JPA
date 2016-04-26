/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author alain
 */
public class Utilitaire {

    public Utilitaire() {
    }

    /**
     * Transforme une chaîne en date selon le format passé en paramètre
     * @param strDate Chaîne contenant la date
     * @param formatDate Chaîne contenant le format
     * @return Date
     * @throws Exception
     */
    public static java.util.Date StrToDate(String strDate, String formatDate) throws Exception {
        java.util.Date date_retour = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatDate);
            date_retour = format.parse(strDate);
        } catch (Exception e) {
        }
        return date_retour;
    }

    /**
     * Transforme une Date en chaîne
     * @param uneDate Date à transformer
     * @param formatDate Format de la date
     * @return Chaine correpondant à la date
     * @throws Exception
     */
    public static String DateToStr(java.util.Date uneDate, String formatDate) throws Exception {
        String date_retour = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatDate);
            date_retour = format.format(uneDate);
        } catch (Exception e) {
        }
        return date_retour;
    }
    
    public static String getExceptionCause(Exception e) {
        Throwable origine = (Throwable) e;
        Throwable src = origine.getCause();
        
        while(src != null) {
            origine = src;
            src = origine.getCause();
        }
        
        return origine.getMessage();
    }
}
