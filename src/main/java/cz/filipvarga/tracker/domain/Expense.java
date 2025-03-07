package cz.filipvarga.tracker.domain;

import jakarta.persistence.*;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_expense")
    private Long id;

    @Column(nullable = false)
    private double amount;

    @ManyToOne
    private Event event;

    @ManyToOne
    private Person person;
}
