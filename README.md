# Loan-Assignment
Code is on master branch

DB used:h2 in memory database
you can check the DB : 'http://localhost:8080/h2-console'
jdbc url:you can find it in startup logs when you run the project
username:sa
pass: 
(blank)
 
you can post the loan using : http://localhost:8080/loan
json body required (just an example):{
    "loanId":"L2",
    "customerId":"C1",
    "lenderId":"LEN2",
    "amount":"30000",
    "remainingAmount":"20000",
    "paymentDate":"05-06-2023",
    "interestPerDay":"1",
    "dueDate":"08-06-2023",
    "penaltyPerDay":"0.01"
}


group by lenderid(GET request):http://localhost:8080/loan/lenderid

group by customerid(GET request):http://localhost:8080/loan/customerid


group by interest(GET request):http://localhost:8080/loan/interest



You can check my junit files in src/test
