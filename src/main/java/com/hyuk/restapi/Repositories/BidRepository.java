package com.hyuk.restapi.Repositories;

import com.hyuk.restapi.Models.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

}