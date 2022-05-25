package util;

import java.text.DecimalFormat;

public class NumberFormat {
    static java.text.NumberFormat formatValue  = new DecimalFormat("R$ #,##0.00");

    public static String doubleToString(Double number){
        return formatValue.format(number);
    }
}
