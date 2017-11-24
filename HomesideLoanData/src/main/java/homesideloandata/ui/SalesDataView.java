/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homesideloandata.ui;

import homesideloandata.dto.Loan;
import java.util.List;

/**
 *
 * @author BMMil
 */
public class SalesDataView {
    
    private final UserIO io;
    
    public SalesDataView(UserIO io){
        this.io = io;
    }
    
 public String getUserFileName() {
     return io.readString("PLEASE ENTER FILE PATH IN \".xlsx\" FORMAT THEN PRESS [ENTER]: ");
 }
    
}
