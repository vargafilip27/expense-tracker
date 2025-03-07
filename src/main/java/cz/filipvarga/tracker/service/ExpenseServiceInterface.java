package cz.filipvarga.tracker.service;

import cz.filipvarga.tracker.domain.Expense;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface ExpenseServiceInterface {

    Expense createExpense(Expense expense) throws IllegalArgumentException; // CREATE
    Expense getExpenseById(Long id) throws EntityNotFoundException;         // READ
    List<Expense> getAllExpenses();
    Expense updateExpense(Expense expense) throws IllegalArgumentException; // UPDATE
    void deleteExpense(Long id) throws EntityNotFoundException;             // DELETE
}
