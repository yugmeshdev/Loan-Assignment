package com.yugmeshsonawane.loanassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yugmeshsonawane.loanassignment.model.Loan;
import com.yugmeshsonawane.loanassignment.service.LoanService;
import com.yugmeshsonawane.loanassignment.model.LoanLender;
import com.yugmeshsonawane.loanassignment.model.LoanCustomer;
@RestController
public class LoanController {
	@Autowired
	private LoanService loanService;
	@PostMapping("/loan")
	 public ResponseEntity<Void> createPost(@RequestBody Loan loan) throws Exception {
        loanService.save(loan);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	@GetMapping("/loan/lenderid")
	public List<LoanLender> groupbylenderid() {
		return loanService.groupbylenderid();
	}
	@GetMapping("/loan/interest")
	public List<LoanLender> groupbyinterest(){
		return loanService.groupbyinterest();
	}
	@GetMapping("/loan/customerid")
	public List<LoanCustomer> groupbycustomerid(){
		return loanService.groupbycustomerid();
	}
}
