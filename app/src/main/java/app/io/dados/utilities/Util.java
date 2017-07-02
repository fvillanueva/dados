package app.io.dados.utilities;

import android.os.Build;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by fidelvillanuevadelgado on 14/06/17.
 */

public final class Util {
    public final static String PLAYER_NAME = "name";
    public final static String PLAYER_SCORE = "score";
    public final static String PLAYER_DATE = "date";

    //Parsear la Fecha que retorna de la BD de SqLite
    public final static Date getFormatDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
        Date datetime = simpleDateFormat.parse(date);
        return datetime;
    }

    //Retorna sola la Fecha en String
    public final static String getStringFormatDate(Date date) {
        SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateFormat = dmyFormat.format(date);
        return dateFormat;
    }

    //Obtiene la hora y fecha del SmartPhone
    public final static String getDateTimeLocale() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
    public final static void getInfoDevice(TextView textView){
        String infoDevice= "Manafacture: "+Build.MANUFACTURER +"\n" +
                " Model: "+Build.MODEL +"\n"+
                "Device: "+Build.DEVICE +"\n"+
                "Board: "+Build.BOARD+"\n"+
                "Brand: "+Build.BRAND+"\n"+
                "ID: "+Build.ID+"\n"+
                "Display: "+Build.DISPLAY+"\n"+
                "Product: "+Build.PRODUCT+"\n"+
                "Serial: "+Build.SERIAL+"\n"+
                "User: "+Build.USER+"\n"+
                "Type: "+Build.TYPE+"\n"+
                "Hardware: "+Build.HARDWARE;
        textView.setText(infoDevice);
    }

}
