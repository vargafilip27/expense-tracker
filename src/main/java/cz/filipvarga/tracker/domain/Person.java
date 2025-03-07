package cz.filipvarga.tracker.domain;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_person")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String bankAccount;

    @ManyToMany
    private ArrayList<Event> events;

    @OneToMany
    private ArrayList<Expense> expenses;
}
