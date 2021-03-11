package com.sw.guestbook.api.service;

import java.util.List;

import com.sw.guestbook.api.entity.GuestCreationRequest;
import com.sw.guestbook.api.entity.GuestResponse;

public interface GuestService {

    public void saveGuestInfo(GuestCreationRequest guestCreationRequest);

    public List<GuestResponse> getGuestList();

    public List<GuestResponse> getGuestListByGuestName(String guestName);

    public GuestResponse getGuestInfoById(long guestResourceId);

    public void deleteGuestInfoById(long guestResourceId);

    public void updateGuestInfo(GuestCreationRequest guestCreationRequest, long guestResourceId);
}

