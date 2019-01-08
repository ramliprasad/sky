package com.bskyb.internettv.parental_control_service;

public interface ParentalControlService {
    boolean canWatchMovie(String customerParentalControlLevel, String movieId) throws Exception;
}
