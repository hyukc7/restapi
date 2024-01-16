package com.hyuk.restapi.Models;

public class JobBidCount {
    public ContractJob job;
    public Integer count;

    public JobBidCount(ContractJob job, int count) {
        this.job = job;
        this.count = count;
    }
}
