package com.company.hotel.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
@Getter
@Setter
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_number")
    private Long RoomNumber;

    @ManyToOne
    @JoinColumn(name="room_type_id")
    private RoomType roomType;

    @OneToMany(mappedBy="booking", cascade=CascadeType.ALL)
    private List<Booking> bookings;
}