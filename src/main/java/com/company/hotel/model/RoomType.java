package com.company.hotel.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room_type")
@Getter
@Setter
@ToString
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_id", nullable = false)
    private Long roomTypeId;

    @Column(name = "type_name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @OneToMany(mappedBy="room", cascade=CascadeType.ALL)
    private List<Room> rooms;

}
