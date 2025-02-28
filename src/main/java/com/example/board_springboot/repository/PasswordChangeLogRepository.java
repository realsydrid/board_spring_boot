package com.example.board_springboot.repository;

import com.example.board_springboot.entity.PasswordChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordChangeLogRepository extends JpaRepository<PasswordChangeLog, Long> {
}
