package com.kcb.bank.kcb_branch_api_h2.service;

import com.kcb.bank.kcb_branch_api_h2.model.Branch;
import com.kcb.bank.kcb_branch_api_h2.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    public Branch getBranchByCode(String branchCode) {
        return branchRepository.findById(branchCode).orElse(null);
    }

    public Branch saveBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    public Branch updateBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    public void deleteBranch(String branchCode) {
        branchRepository.deleteById(branchCode);
    }
}
