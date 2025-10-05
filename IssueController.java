package com.helpdesk.controller;

import com.helpdesk.model.Issue;
import com.helpdesk.model.User;
import com.helpdesk.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class IssueController {
    @Autowired
    private IssueRepository issueRepo;

    @GetMapping
    public List<Issue> getIssues(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user.getRole().equals("STAFF")) {
            return issueRepo.findByStatus("OPEN");
        } else if (user.getRole().equals("ADMIN")) {
            return issueRepo.findAll();
        } else {
            return issueRepo.findByUserId(user.getId());
        }
    }

    @PostMapping
    public Issue createIssue(@RequestBody Issue issue, HttpSession session) {
        User user = (User) session.getAttribute("user");
        issue.setUserId(user.getId());
        issue.setStatus("OPEN");
        return issueRepo.save(issue);
    }

    @PutMapping("/{id}/complete")
    public Issue completeIssue(@PathVariable Long id, HttpSession session) {
        Issue issue = issueRepo.findById(id).orElseThrow();
        User user = (User) session.getAttribute("user");
        if (user.getRole().equals("STAFF")) {
            issue.setStatus("CLOSED");
            issue.setAssignedStaffId(user.getId());
            return issueRepo.save(issue);
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }
}
