package com.sandeep.guestbook.api.service;

import com.sandeep.guestbook.api.entity.GuestCreationRequest;
import com.sandeep.guestbook.api.entity.GuestResponse;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: swadhwa6
 * Date: 2/17/18
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface GuestService {

    public void saveGuestInfo(GuestCreationRequest guestCreationRequest);

    public List<GuestResponse> getGuestList();

    public List<GuestResponse> getGuestListByGuestName(String guestName);

    public List<GuestResponse> getGuestInfoById(String guestResourceId);
}

