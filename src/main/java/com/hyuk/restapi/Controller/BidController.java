package com.hyuk.restapi.Controller;

import com.hyuk.restapi.Models.Bid;
import com.hyuk.restapi.Services.impl.BidServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BidController {

    @Autowired
    BidServiceImpl bidService;

    @PostMapping("/bid")
    public Bid postBid(@RequestBody Bid newBid) {
        return this.bidService.postBid(newBid);
    }

    @GetMapping("/bid/all")
    public List<Bid> getAll() {
        return this.bidService.getAll();
    }

}