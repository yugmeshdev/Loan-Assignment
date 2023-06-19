package com.yugmeshsonawane.loanassignment.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yugmeshsonawane.loanassignment.model.Loan;
import com.yugmeshsonawane.loanassignment.model.LoanLender;
import com.yugmeshsonawane.loanassignment.model.LoanCustomer;
import com.yugmeshsonawane.loanassignment.repo.LoanRepository;
import org.springframework.jdbc.core.JdbcTemplate;


@Service

public class LoanService {
	@Autowired
	private LoanRepository loanRepository;
	private final Logger LOGGER =
            LoggerFactory.getLogger(LoanService.class);
	public void save(Loan loan) throws Exception{
//		try {
//		loan.validatePaymentDate();
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
	
		loan.validatePaymentDate();
		String s=loan.validateDate();
		LOGGER.info(s);
		loanRepository.save(loan);
	}
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<LoanLender> groupbylenderid() {
		// TODO Auto-generated method stub
	//	List<LoanLender> ll=loanRepository.groupbylenderid();
		//return ll;
		String sql = "SELECT LENDER_ID,SUM(REMAINING_AMOUNT) AS REMAINING_AMOUNT,INTEREST_PER_DAY,PENALTY_PER_DAY FROM LOAN GROUP BY LENDER_ID";
	  
	    
	    return jdbcTemplate.query(sql,  (rs, rowNum) -> {
	        LoanLender obj = new LoanLender();
	        obj.setLenderid(rs.getString("LENDER_ID"));
	        obj.setRemainingAmount(rs.getDouble("REMAINING_AMOUNT"));
	        obj.setInterestPerDay(rs.getDouble("INTEREST_PER_DAY"));
	        obj.setPenaltyPerDay(rs.getDouble("PENALTY_PER_DAY"));
	        return obj;
	    });
	}
	public List<LoanLender> groupbyinterest() {
		// TODO Auto-generated method stub
	//	List<LoanLender> ll=loanRepository.groupbylenderid();
		//return ll;
		String sql = "SELECT LENDER_ID,SUM(REMAINING_AMOUNT) AS REMAINING_AMOUNT,INTEREST_PER_DAY,PENALTY_PER_DAY FROM LOAN GROUP BY INTEREST_PER_DAY";
	  
	    
	    return jdbcTemplate.query(sql,  (rs, rowNum) -> {
	        LoanLender obj = new LoanLender();
	        obj.setLenderid(rs.getString("LENDER_ID"));
	        obj.setRemainingAmount(rs.getDouble("REMAINING_AMOUNT"));
	        obj.setInterestPerDay(rs.getDouble("INTEREST_PER_DAY"));
	        obj.setPenaltyPerDay(rs.getDouble("PENALTY_PER_DAY"));
	        return obj;
	    });
	}
	public List<LoanCustomer> groupbycustomerid() {
		// TODO Auto-generated method stub
	//	List<LoanLender> ll=loanRepository.groupbylenderid();
		//return ll;
		String sql = "SELECT CUSTOMER_ID,SUM(REMAINING_AMOUNT) AS REMAINING_AMOUNT,INTEREST_PER_DAY,PENALTY_PER_DAY FROM LOAN GROUP BY CUSTOMER_ID";
	  
	    
	    return jdbcTemplate.query(sql,  (rs, rowNum) -> {
	        LoanCustomer obj = new LoanCustomer();
	        obj.setCustomerid(rs.getString("CUSTOMER_ID"));
	        obj.setRemainingAmount(rs.getDouble("REMAINING_AMOUNT"));
	        obj.setInterestPerDay(rs.getDouble("INTEREST_PER_DAY"));
	        obj.setPenaltyPerDay(rs.getDouble("PENALTY_PER_DAY"));
	        return obj;
	    });
	}
	
}
