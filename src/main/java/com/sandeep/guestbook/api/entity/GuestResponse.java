package com.sandeep.guestbook.api.entity;

/**
 * Created with IntelliJ IDEA.
 * User: swadhwa6
 * Date: 2/18/18
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class GuestResponse {

    private long guestId;

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    private String guestName;

    private String comment;

    private String createdDateTime;

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

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
