package com.yugmeshsonawane.loanassignment.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.yugmeshsonawane.loanassignment.model.Loan;
import com.yugmeshsonawane.loanassignment.model.LoanLender;

@Repository

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
