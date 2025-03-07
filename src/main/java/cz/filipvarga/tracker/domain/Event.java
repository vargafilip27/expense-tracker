package cz.filipvarga.tracker.domain;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_event")
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    private ArrayList<Person> persons;

    @OneToMany
    private ArrayList<Expense> expenses;
}
