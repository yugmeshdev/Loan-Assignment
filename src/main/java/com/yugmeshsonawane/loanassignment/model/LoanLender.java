package com.yugmeshsonawane.loanassignment.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
    	
public class LoanLender {
	 private String lenderid;
	  private double remainingAmount;
	  private double penaltyPerDay;
	  private double interestPerDay;

	 

}
