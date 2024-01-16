package com.hyuk.restapi.Services.impl;

import com.hyuk.restapi.Models.Bid;
import com.hyuk.restapi.Models.ContractJob;
import com.hyuk.restapi.Models.JobBidCount;
import com.hyuk.restapi.Repositories.BidRepository;
import com.hyuk.restapi.Repositories.JobRepository;
import com.hyuk.restapi.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    BidRepository bidRrepository;

    @Override
    public ContractJob postJob(ContractJob job) {
        job.setCreated_date(System.currentTimeMillis());
        return jobRepository.save(job);
    }

    @Override
    public List<ContractJob> getRecentJobs(Integer count) {
        List<ContractJob> alljobs = jobRepository.findAll();
        return alljobs;
    }

    @Override
    public List<ContractJob> getActiveJobs(Integer count) {
        List<ContractJob> alljobs = jobRepository.findAll();
        // for now bruteforce.
        PriorityQueue<JobBidCount> cache = new PriorityQueue<>(
                Comparator.comparing(a -> a.count, Collections.reverseOrder())
        );
        for (ContractJob job : alljobs) {
            Long currentTime = System.currentTimeMillis();
            if (job.getExpiration_date() < currentTime) {
                continue;
            }
            List<Bid> result = bidRrepository.findAll();
            if (result != null && !result.isEmpty())
                cache.add(new JobBidCount(job, result.size()));
        }
        List<ContractJob> result = new ArrayList<>();
        while (!result.isEmpty() && count > 0) {
            result.add(cache.poll().job);
            count--;
        }
        return result;
    }


}
