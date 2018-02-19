package com.sandeep.guestbook.api.entity;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: swadhwa6
 * Date: 2/18/18
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuestResponseWithError extends GuestResponse {

    private HashMap<String, String> responseError;

    public GuestResponseWithError() {
    }

    public GuestResponseWithError(HashMap<String, String> responseError, GuestResponse guestResponse) {
        this.responseError = responseError;
        setGuestId(guestResponse.getGuestId());
        setGuestName(guestResponse.getGuestName());
        setComment(guestResponse.getComment());
        setCreatedDateTime(guestResponse.getCreatedDateTime());
    }

    public HashMap<String, String> getResponseError() {
        return responseError;
    }

    public void setResponseError(HashMap<String, String> aResponseError) {
        responseError = aResponseError;
    }
}
