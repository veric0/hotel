package com.company.hotel.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "booking")
@Getter
@Setter
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name="room_number", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column(name = "check_in", nullable = false)
    private Date check_in;

    @Column(name = "check_out", nullable = false)
    private Date check_out;

    @Column(name = "num_of_people", nullable = false)
    private Integer numOfPeople;

    @Column(name = "status", columnDefinition = "ENUM('EMPTY', 'RESERVED', 'PAID', 'CANCELED', 'EXPIRED')", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        EMPTY, RESERVED, PAID, CANCELED, EXPIRED
    }

}
