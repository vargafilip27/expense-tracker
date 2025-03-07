package cz.filipvarga.tracker.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "bank_account", nullable = true)
    private String bankAccount;

    @ManyToMany(mappedBy = "persons")
    private List<Event> events;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Expense> expenses;
}
