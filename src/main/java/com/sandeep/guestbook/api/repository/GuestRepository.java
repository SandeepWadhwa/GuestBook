package com.sandeep.guestbook.api.repository;

import com.sandeep.guestbook.api.entity.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuestRepository extends CrudRepository<Guest, Long> {

    List<Guest> findByGuestName(String guestName);

}
