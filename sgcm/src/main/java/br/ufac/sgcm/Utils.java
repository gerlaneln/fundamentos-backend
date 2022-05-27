package br.ufac.sgcm;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Utils {

    public static String getDataFormatada(Date data) {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        return formatoData.format(data);
    }
    
}
