package com.helpdesk.repository;

import com.helpdesk.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByStatus(String status);

    List<Issue> findByUserId(Long userId);
}
