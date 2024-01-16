package com.hyuk.restapi.Services;

import com.hyuk.restapi.Models.Bid;

import java.util.List;

public interface BidService {
    Bid postBid(Bid newBid);

    List<Bid> getAll();
}
