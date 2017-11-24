/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homesideloandata.service;

import homesideloandata.dao.LoanDao;
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
public class LoanServiceImpl implements LoanService {

    private LoanDao loanDao;

    public LoanServiceImpl(LoanDao loanDao) {
        this.loanDao = loanDao;
    }

    @Override
    public Loan addLoan(Loan loan) {
        return loanDao.addLoan(loan);
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
        return loanDao.getAllLoans();
    }


    @Override
    public BigDecimal calculate(List<BigDecimal> loanAmts) {
        return loanDao.calculate(loanAmts);
    }

    @Override
    public String getFileName(String fileName) {
        return loanDao.getFileName(fileName);
    }


    @Override
    public HashMap<String, ArrayList<BigDecimal>> putLoansWithBranch(String fileName) {
        return loanDao.putLoansWithBranch(fileName);
    }

    @Override
    public List<BigDecimal> getColumnContentByIndex(int columnIndex, String fileName) {
        return loanDao.getColumnContentByIndex(columnIndex, fileName);
    }

    @Override
    public void writeToFile() throws IOException {
       loanDao.writeToFile();
    }
    

}
