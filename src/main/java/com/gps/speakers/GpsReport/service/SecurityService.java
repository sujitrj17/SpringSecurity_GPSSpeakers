package com.gps.speakers.GpsReport.service;

public interface SecurityService {
	 String findLoggedInUsername();

	    void autoLogin(String username, String password);
}
