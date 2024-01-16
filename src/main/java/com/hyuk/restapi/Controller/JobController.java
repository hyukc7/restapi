package com.hyuk.restapi.Controller;

import com.hyuk.restapi.Models.ContractJob;
import com.hyuk.restapi.Models.Employee;
import com.hyuk.restapi.Services.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobServiceImpl jobService;

    @GetMapping("/contractjob/active")
    public List<ContractJob> getTop10ActiveJobs() {
        return this.jobService.getActiveJobs(10);
    }

    @GetMapping("/contractjob/recent")
    public List<ContractJob> getTop10RecentJobs() {
        return this.jobService.getRecentJobs(10);
    }

    @PostMapping("/contractjob")
    public ContractJob newEmployee(@RequestBody ContractJob newEmployee) {
        return this.jobService.postJob(newEmployee);
    }


}