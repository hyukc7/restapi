package com.hyuk.restapi.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "ContractJob")
@Table(name = "contract_job")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractJob {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "requirement")
    private String requirement;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "expiration_date")
    private Long expiration_date;

    @Column(name = "created_date")
    private Long created_date;

}