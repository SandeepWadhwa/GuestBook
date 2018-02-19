package com.sandeep.guestbook.api.service;

import com.sandeep.guestbook.api.entity.Guest;
import com.sandeep.guestbook.api.entity.GuestCreationRequest;
import com.sandeep.guestbook.api.entity.GuestResponse;
import com.sandeep.guestbook.api.repository.GuestRepository;
import com.sandeep.guestbook.api.util.GuestBookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: swadhwa6
 * Date: 2/17/18
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public void saveGuestInfo(GuestCreationRequest guestCreationRequest) {

        Guest guest = new Guest();
        guest.setGuestName(guestCreationRequest.getGuestName());
        guest.setComment(guestCreationRequest.getComment());
        guest.setCreationDateTime(GuestBookUtil.getTimeInUTC());

        guestRepository.save(guest);

    }

    public List<GuestResponse> getGuestList() {
        List<GuestResponse> guestList = new ArrayList<GuestResponse>();
        for (Guest guest : guestRepository.findAll()) {
            GuestResponse guestResponse = new GuestResponse();
            guestResponse.setGuestName(guest.getGuestName());
            guestResponse.setGuestId(guest.getId());
            guestResponse.setComment(guest.getComment());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(guest.getCreationDateTime());
            guestResponse.setCreatedDateTime(strDate);
            guestList.add(guestResponse);
        }
        return guestList;

    }

    public List<GuestResponse> getGuestListByGuestName(String guestName) {
        List<GuestResponse> guestList = new ArrayList<GuestResponse>();
        for (Guest guest : guestRepository.findByGuestName(guestName)) {
            GuestResponse guestResponse = new GuestResponse();
            guestResponse.setGuestName(guest.getGuestName());
            guestResponse.setGuestId(guest.getId());
            guestResponse.setComment(guest.getComment());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(guest.getCreationDateTime());
            guestResponse.setCreatedDateTime(strDate);
            guestList.add(guestResponse);
        }
        return guestList;

    }

    public List<GuestResponse> getGuestInfoById(String guestResourceId) {
        List<GuestResponse> guestList = new ArrayList<GuestResponse>();
        // There could be exception if string cannot be converted to Long ..
        // should be catched
        Long resourceId = new Long(guestResourceId);
        Guest guest = guestRepository.findOne(resourceId);
        GuestResponse guestResponse = new GuestResponse();
        guestResponse.setGuestName(guest.getGuestName());
        guestResponse.setGuestId(guest.getId());
        guestResponse.setComment(guest.getComment());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(guest.getCreationDateTime());
        guestResponse.setCreatedDateTime(strDate);
        guestList.add(guestResponse);

        return guestList;

    }
}
