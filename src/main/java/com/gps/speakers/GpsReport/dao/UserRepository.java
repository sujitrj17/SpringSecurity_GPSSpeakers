package com.gps.speakers.GpsReport.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gps.speakers.GpsReport.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
