/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homesideloandata.controller;

import homesideloandata.dto.Loan;
import homesideloandata.service.LoanService;
import homesideloandata.ui.SalesDataView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static sun.security.jca.ProviderList.newList;

/**
 *
 * @author BMMil
 */
public class SalesDataController {

    private final LoanService loanService;
    private final SalesDataView view;

    public SalesDataController(LoanService loanService, SalesDataView view) {
        this.loanService = loanService;
        this.view = view;
    }

    public void run() {
        
        String fileName;
        fileName = view.getUserFileName();
        List<BigDecimal> loanAmts = loanService.getColumnContentByIndex(2, "salesData.xlsx");
  
        try {
            loanService.writeToFile();
        } catch (IOException ex) {
            Logger.getLogger(SalesDataController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
        
    
}
