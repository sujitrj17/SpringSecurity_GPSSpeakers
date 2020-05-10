package com.gps.speakers.GpsReport.service;

import com.gps.speakers.GpsReport.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}