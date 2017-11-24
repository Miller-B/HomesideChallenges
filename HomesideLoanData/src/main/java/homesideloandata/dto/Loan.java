/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homesideloandata.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author BMMil
 */
public class Loan {
    
    private String branch;
    private Long loanNumber;
    private BigDecimal loanAmt;
    

    public Loan(){
        
    }
    
    public Loan(String branch, Long loanNumber, BigDecimal loanAmt){
        this.branch = branch;
        this.loanNumber = loanNumber;
        this.loanAmt = loanAmt;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Long getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(Long loanNumber) {
        this.loanNumber = loanNumber;
    }

    public BigDecimal getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(BigDecimal loanAmt) {
        this.loanAmt = loanAmt;
    }



    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.branch);
        hash = 37 * hash + Objects.hashCode(this.loanNumber);
        hash = 37 * hash + Objects.hashCode(this.loanAmt);
 
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Loan other = (Loan) obj;
        if (!Objects.equals(this.branch, other.branch)) {
            return false;
        }
        if (!Objects.equals(this.loanNumber, other.loanNumber)) {
            return false;
        }
        if (!Objects.equals(this.loanAmt, other.loanAmt)) {
            return false;
        
        }
        return true;
    }

    
    
    
}
