package com.kcb.bank.kcb_branch_api_h2.controller;

import com.kcb.bank.kcb_branch_api_h2.model.Branch;
import com.kcb.bank.kcb_branch_api_h2.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping
    public List<Branch> getAllBranches() {
        return branchService.getAllBranches();
    }

    @GetMapping("/{branchCode}")
    public Branch getBranchByCode(@PathVariable("branchCode") String branchCode) {
        return branchService.getBranchByCode(branchCode);
    }

    @PostMapping
    public Branch saveBranch(@RequestBody Branch branch) {
        return branchService.saveBranch(branch);
    }

    @PutMapping("/{branchCode}")
    public Branch updateBranch(@PathVariable("branchCode") String branchCode, @RequestBody Branch branch) {
        branch.setBranchCode(branchCode);
        return branchService.updateBranch(branch);
    }

    @DeleteMapping("/{branchCode}")
    public void deleteBranch(@PathVariable("branchCode") String branchCode) {
        branchService.deleteBranch(branchCode);
    }
}
