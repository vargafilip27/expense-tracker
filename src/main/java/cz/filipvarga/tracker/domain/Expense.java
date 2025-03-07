package cz.filipvarga.tracker.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_expense")
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount; // Use BigDecimal for accuracy

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_event", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person", nullable = false)
    private Person person;
}
