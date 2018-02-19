package com.sandeep.guestbook.api.repository;

import com.sandeep.guestbook.api.entity.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: swadhwa6
 * Date: 2/17/18
 * Time: 12:26 PM
 * To change this template use File | Settings | File Templates.
 */

public interface GuestRepository extends CrudRepository<Guest, Long> {

    List<Guest> findByGuestName(String guestName);

}
