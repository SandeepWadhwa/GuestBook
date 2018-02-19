package com.sandeep.guestbook.api.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "guest")
@Access(value = AccessType.FIELD)
public class Guest {

    @Id
    @Column(name = "guest_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "guest_name")
    private String guestName;

    public Long getId() {
        return id;
    }

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

    public Date getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public void setId(Long id) {

        this.id = id;
    }

    @Column(name = "comments")
    private String comment;

    @Column(name = "creation_time")
    private Date creationDateTime;

}
