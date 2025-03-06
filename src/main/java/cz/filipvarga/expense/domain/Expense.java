package cz.filipvarga.expense.domain;

import jakarta.persistence.*;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_expense")
    private Long id;

    private double amount;
}
