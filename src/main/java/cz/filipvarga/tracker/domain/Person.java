package cz.filipvarga.tracker.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column
    private String password;

    @Column
    private String googleId;

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;

    @Column(name = "bank_account", nullable = true)
    private String bankAccount;

    @ManyToMany(mappedBy = "persons")
    private List<Event> events;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Expense> expenses;
}
