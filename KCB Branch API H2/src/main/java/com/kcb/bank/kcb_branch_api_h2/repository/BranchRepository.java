package com.kcb.bank.kcb_branch_api_h2.repository;

import com.kcb.bank.kcb_branch_api_h2.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, String> {
}
