package com.sandeep.guestbook.api.entity;

/**
 * Created with IntelliJ IDEA.
 * User: swadhwa6
 * Date: 2/17/18
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuestCreationRequest {

    private String guestName;

    private String comment;

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
