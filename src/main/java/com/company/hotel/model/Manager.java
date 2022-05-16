package com.company.hotel.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "manager")
@Getter
@Setter
@ToString
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "passphrase", nullable = false)
    private String passphrase;
}
