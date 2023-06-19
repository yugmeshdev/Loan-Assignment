package com.yugmeshsonawane.loanassignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
    	
public class LoanCustomer {
	 private String customerid;
	  private double remainingAmount;
	  private double penaltyPerDay;
	  private double interestPerDay;

}
