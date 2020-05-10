package com.gps.speakers.GpsReport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gps.speakers.GpsReport.entity.Speakers;

@Repository
public interface GpsSpeakerRepository extends JpaRepository<Speakers, Integer>{

}
