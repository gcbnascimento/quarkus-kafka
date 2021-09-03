package br.gov.caixa.sidpn.api.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;

public class DatePatterns {

    private DatePatterns() {
        throw new IllegalStateException("Utility class");
    }

    public static final String YYYY_MM_DDTHH_MM_SS_Z = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String T_Z = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static String getFormatedDate(String format, Date data) {
        var sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(data);
    }
    
    public static String getCurrentDate() {
    	return LocalDate.now().toString();
    }
    
}