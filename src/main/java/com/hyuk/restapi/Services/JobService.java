package com.hyuk.restapi.Services;

import com.hyuk.restapi.Models.ContractJob;

import java.util.List;

public interface JobService {
    ContractJob postJob(ContractJob job);

    List<ContractJob> getRecentJobs(Integer count);

    List<ContractJob> getActiveJobs(Integer count);
}
