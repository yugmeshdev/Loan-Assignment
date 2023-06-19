package com.yugmeshsonawane.loanassignment.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Loan {
	@Id
    @GeneratedValue(strategy = IDENTITY)
	private Long id;
	 private String loanId;
     private String customerId;
     private String lenderId;
     private double amount;
     private double remainingAmount;

     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
     private LocalDate paymentDate;


    
     private double interestPerDay;

     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
     private LocalDate dueDate;
     private double penaltyPerDay;
     LocalDate today = LocalDate.now();
     
     public void validatePaymentDate() throws Exception {
    	 if(dueDate.isBefore(paymentDate)) {
    		 throw new Exception("Payment date cannot be greater than the due date.");
         }
     }
    public String validateDate() {
    	if(dueDate.isBefore(today)) {
    		String s="Loan crossed due date";
    		return s;
    	}
    	return "";
    }
     
}
     
