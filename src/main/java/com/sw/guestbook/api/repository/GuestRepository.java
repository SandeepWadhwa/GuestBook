package com.sw.guestbook.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sw.guestbook.api.entity.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long> {

    List<Guest> findByGuestName(String guestName);

}
