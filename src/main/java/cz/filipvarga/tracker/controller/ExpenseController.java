package cz.filipvarga.tracker.controller;

import cz.filipvarga.tracker.controller.dto.ExpenseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @PostMapping
    public String addExpense(ExpenseDTO expense) {}
}
