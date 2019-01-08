package com.bskyb.internettv.thirdparty;

public interface MovieService {
        String getParentalControlLevel(String titleId) throws TitleNotFoundException, TechnicalFailureException;
}
