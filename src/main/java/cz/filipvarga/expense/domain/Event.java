package cz.filipvarga.expense.domain;

import jakarta.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_event")
    private Long id;

    @Column(nullable = false)
    private String name;
}
