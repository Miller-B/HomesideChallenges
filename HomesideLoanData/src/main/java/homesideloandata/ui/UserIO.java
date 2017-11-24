/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homesideloandata.ui;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author BMMil
 */
public interface UserIO {
    
    public void print(String msg);

    public double readDouble(String prompt);
    
    public double readDouble(String prompt, boolean acceptsNullInput); 

    public double readDoubleBetween(String prompt, double min, double max);

    public float readFloat(String prompt);

    public float readFloatBetween(String prompt, float min, float max);

    public int readInt(String prompt);

    public int readIntBetween(String prompt, int min, int max);

    public long readLong(String prompt);

    public long readLongBetween(String prompt, long min, long max);

    public String readString(String prompt);

    public BigDecimal readBigDecimal(String prompt);

    public void println(String string);
    
    public LocalDate readLocalDate(String prompt, String format);

}
