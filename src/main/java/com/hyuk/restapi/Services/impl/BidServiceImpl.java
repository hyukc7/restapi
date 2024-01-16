package com.hyuk.restapi.Services.impl;

import com.hyuk.restapi.Models.Bid;
import com.hyuk.restapi.Repositories.BidRepository;
import com.hyuk.restapi.Services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {
    @Autowired
    BidRepository bidRrepository;

    @Override
    public Bid postBid(Bid newBid) {
//        List<Bid> bidsForJob = bidRrepository.findAllBidByJobId(newBid.getJob_id());
//        Long minBidAmount = getMinBidsForJob(bidsForJob);
//        if(newBid.getBid_amount() < minBidAmount){
//            raise BidLowerThanMinimum();
//        }
        return bidRrepository.save(newBid);
    }

    @Override
    public List<Bid> getAll() {
        return bidRrepository.findAll();
    }


}
