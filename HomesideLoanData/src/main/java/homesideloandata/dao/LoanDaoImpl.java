/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homesideloandata.dao;

import homesideloandata.dto.Loan;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author BMMil
 */
public class LoanDaoImpl implements LoanDao {

    private final Map<Integer, Loan> loanMap = new HashMap<>();
    private final HashMap<String, ArrayList<BigDecimal>> loanList = new HashMap<>();
    private final ArrayList<Loan> arrList = new ArrayList<>();
    private final List<BigDecimal> columnData = new ArrayList<>();
    private String fileName = "salesData.xlsx";
    private int columnIndex;
    private BigDecimal sum;
    public static final String DELIMITER = "|";

    public LoanDaoImpl() {

    }
    
    
    @Override
    public Loan addLoan(Loan loan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void removeLoan(Loan loan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Loan getLoan(Loan loan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Loan editLoan(Loan loan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Loan> getAllLoans() {
        return new ArrayList(loanMap.values());
    }

    
    
    @Override
    public List<BigDecimal> getColumnContentByIndex(int columnIndex, String filename) {
        //List<BigDecimal> columnData = new ArrayList<>();
        try {
            File f = new File(fileName);
            FileInputStream ios = new FileInputStream(f);
            XSSFWorkbook workbook = new XSSFWorkbook(ios);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    if (row.getRowNum() > 0) { //To filter column headings
                        if (cell.getColumnIndex() == columnIndex) {// To match column index

                            String stringAmt = cell.getStringCellValue();
                            String numToAdd = stringAmt.replace("$", "");
                            columnData.add(new BigDecimal(numToAdd));
                        }
                    }
                }
            }
            ios.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columnData;
    }

    @Override
    public String getFileName(String fileName) {
        return fileName;
    }

    @Override
    public int getColumnIndex() {
        return columnIndex;
    }

    @Override
    public HashMap<String, ArrayList<BigDecimal>> putLoansWithBranch(String fileName) {
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
                Loan loan = new Loan();
                Row row = sheet.getRow(i);

                for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);

                    if (j == 0) {
                        loan.setBranch(cell.getStringCellValue());
                    }

                    if (j == 2) {
                        String stringAmt = cell.getStringCellValue();
                        String amtToAdd = stringAmt.replace("$", "");
                        loan.setLoanAmt(new BigDecimal(amtToAdd));
                    }
                }
                arrList.add(loan);

            }
            for (Loan loan : arrList) {
                String branch = loan.getBranch();

                if (!loanList.containsKey(branch)) {
                    BigDecimal amnt = loan.getLoanAmt();
                    ArrayList<BigDecimal> amounts = new ArrayList<>();
                    amounts.add(amnt);
                    loanList.put(branch, amounts);
                } else {
                    BigDecimal amnt = loan.getLoanAmt();
                    loanList.get(branch).add(amnt);
                }
            }
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return loanList;
    }

    @Override
    public BigDecimal calculate(List<BigDecimal> loanAmts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void writeToFile() throws IOException {
        
        PrintWriter writerOut;
        writerOut = new PrintWriter(new FileWriter("salesData.csv", true));
        
        int totalUnits = columnData.size();
        BigDecimal sum = columnData.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        writerOut.println("Total Production| "+ totalUnits +" |$"+ sum);
            
        
        
        writerOut.flush();
        writerOut.close();
    }
    


 

}
