package com.hyuk.restapi.Repositories;

import com.hyuk.restapi.Models.ContractJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends JpaRepository<ContractJob, Long> {

}