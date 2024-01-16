package com.hyuk.restapi.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Bid")
@Table(name = "bid")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "job_id")
    private Long job_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "bid_amount")
    private Long bid_amount;


}