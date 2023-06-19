package com.yugmeshsonawane.loanassignment.controller;

import com.yugmeshsonawane.loanassignment.model.Loan;
import com.yugmeshsonawane.loanassignment.service.LoanService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import com.yugmeshsonawane.loanassignment.model.Loan;
import org.springframework.http.MediaType;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.time.LocalDate;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import org.springframework.beans.factory.annotation.Autowired;
@WebMvcTest(LoanController.class)
public class LoanControllerTest {

    @InjectMocks
    private LoanController loanController;

    @MockBean
    private LoanService loanService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreatePost() throws Exception {
        Loan loan = new Loan();
        loan.setLoanId("L1");
        loan.setCustomerId("C1");
        loan.setLenderId("LEN1");
        loan.setAmount(10000);
        loan.setRemainingAmount(10000);
        loan.setPaymentDate(LocalDate.parse("2023-07-05"));
        loan.setInterestPerDay(0.01);
        loan.setDueDate(LocalDate.parse("2023-08-05"));
        loan.setPenaltyPerDay(0.01);

        doNothing().when(loanService).save(loan);

        mockMvc.perform(MockMvcRequestBuilders.post("/loan")
                .content("{\"loanId\": \"L1\", \"customerId\": \"C1\", \"lenderId\": \"LEN1\", \"amount\": \"10000\", \"remainingAmount\":\"10000\", \"paymentDate\": \"05-07-2023\", \"interestPerDay\": \"0.01\",\"penaltyPerDay\":\"0.01\", \"dueDate\": \"05-08-2023\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        verify(loanService).save(loan);
    }
}
