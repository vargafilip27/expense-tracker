package cz.filipvarga.tracker.service;

import cz.filipvarga.tracker.domain.Expense;
import cz.filipvarga.tracker.persistent.JPAEventRepository;
import cz.filipvarga.tracker.persistent.JPAExpenseRepository;
import cz.filipvarga.tracker.persistent.JPAPersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService implements ExpenseServiceInterface {

    private final JPAExpenseRepository expenseRepository;
    private final JPAEventRepository eventRepository;
    private final JPAPersonRepository personRepository;

    public ExpenseService(JPAExpenseRepository expenseRepository, JPAEventRepository eventRepository, JPAPersonRepository personRepository) {
        this.expenseRepository = expenseRepository;
        this.eventRepository = eventRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Expense createExpense(Expense expense) throws IllegalArgumentException {
        if (expenseRepository.existsById(expense.getId())){
            throw new IllegalArgumentException("Expense with id " + expense.getId() + " already exists");
        }

        if (eventRepository.existsById(expense.getEvent().getId())){
            throw new IllegalArgumentException("Event with id " + expense.getEvent().getId() + " already exists");
        }

        if (personRepository.existsById(expense.getPerson().getId())){
            throw new IllegalArgumentException("Person with id " + expense.getPerson().getId() + " already exists");
        }

        return expenseRepository.save(expense);
    }

    @Override
    public Expense getExpenseById(Long id) throws EntityNotFoundException {
        if (expenseRepository.existsById(id)){
            return expenseRepository.findById(id).get();
        }
        else throw new EntityNotFoundException("Expense with id " + id + " not found");
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense updateExpense(Expense expense) throws IllegalArgumentException {
        if (expenseRepository.existsById(expense.getId())){
            return expenseRepository.save(expense);
        }
        else throw new IllegalArgumentException("Expense with id " + expense.getId() + " does not exist");
    }

    @Override
    public void deleteExpense(Long id) throws EntityNotFoundException {
        if (expenseRepository.existsById(id)){
            expenseRepository.deleteById(id);
        }
        else throw new EntityNotFoundException("Expense with id " + id + " not found");
    }
}
