/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homesideloandata.dao;

import homesideloandata.dto.Loan;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author BMMil
 */
public interface LoanDao {

    public Loan addLoan(Loan loan);

    public void removeLoan(Loan loan);

    public Loan getLoan(Loan loan);

    public Loan editLoan(Loan loan);

    public List<Loan> getAllLoans();

    public List<BigDecimal> getColumnContentByIndex(int columnIndex, String filename);

    public BigDecimal calculate(List<BigDecimal> loanAmts);

    public String getFileName(String fileName);

    public int getColumnIndex();

    public HashMap<String, ArrayList<BigDecimal>> putLoansWithBranch(String fileName);

    public void writeToFile() throws IOException;

}
