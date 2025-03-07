package cz.filipvarga.tracker.controller.converter;

import cz.filipvarga.tracker.controller.dto.ExpenseDTO;
import cz.filipvarga.tracker.domain.Expense;
import org.springframework.stereotype.Component;

@Component
public class ExpenseDTOConverter implements DTOConverter<ExpenseDTO, Expense> {
}
