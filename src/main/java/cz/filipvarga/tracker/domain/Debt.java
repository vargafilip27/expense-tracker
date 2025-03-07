package cz.filipvarga.tracker.domain;

import jakarta.persistence.*;

@Entity
public class Debt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_debt")
    private Long id;
}
