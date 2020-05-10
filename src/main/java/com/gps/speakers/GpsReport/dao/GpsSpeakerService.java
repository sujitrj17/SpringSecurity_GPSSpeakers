package com.gps.speakers.GpsReport.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gps.speakers.GpsReport.entity.Speakers;

@Service
public class GpsSpeakerService {
	
	@Autowired
	GpsSpeakerRepository repository;
	
    public List<Speakers> getData() {

        return (List<Speakers>) repository.findAll();

    }
}
