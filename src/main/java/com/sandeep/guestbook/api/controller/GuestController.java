package com.sandeep.guestbook.api.controller;

import com.sandeep.guestbook.api.GuestBookErrorConst;
import com.sandeep.guestbook.api.GuestBookErrorType;
import com.sandeep.guestbook.api.entity.GuestCreationRequest;
import com.sandeep.guestbook.api.entity.GuestResponse;
import com.sandeep.guestbook.api.entity.GuestResponseWithError;
import com.sandeep.guestbook.api.exception.GuestAPIException;
import com.sandeep.guestbook.api.service.GuestService;
import com.sandeep.guestbook.api.util.GuestBookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: swadhwa6
 * Date: 2/17/18
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("guests")

public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping
    public ResponseEntity saveGuestInfo(@RequestBody GuestCreationRequest guestCreationRequest) throws GuestAPIException {
        if (!GuestBookUtil.isFilled(guestCreationRequest.getGuestName())) {
            List<String> errorMessages = new ArrayList<String>();
            errorMessages.add("Guest Name is missing");
            throw new GuestAPIException(HttpStatus.BAD_REQUEST, GuestBookErrorConst.GB_00001_GUEST_NAME_IS_MISSING, errorMessages, GuestBookErrorType.BUSINESS_ERRORS);
        }

        guestService.saveGuestInfo(guestCreationRequest);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /*@GetMapping
    public ResponseEntity<List<GuestResponse>> getGuestsList( @RequestParam(value = "guestName", required = false) String guestName ) throws GuestAPIException
    {
        List<GuestResponse> guestList = guestService.getGuestListByGuestName(guestName);
        HttpStatus httpStatus = HttpStatus.OK;
        if ( guestList == null || guestList.isEmpty() )
        {
            GuestResponse guestResponse = new GuestResponse();
            guestResponse.setGuestName(guestName);

            HashMap<String, String> errorResponse = new HashMap<String, String>();
            errorResponse.put( GuestBookErrorConst.NO_RECORDS_FOUND, GuestBookErrorConst.NO_GUESTS_FOUND );

            guestList.add( new GuestResponseWithError( errorResponse, guestResponse ) );
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<List<GuestResponse>>( guestList, httpStatus );
    }*/

    @GetMapping
    public ResponseEntity<List<GuestResponse>> getGuestsList() throws GuestAPIException {
        List<GuestResponse> guestList = guestService.getGuestList();

        HttpStatus httpStatus = HttpStatus.OK;
        if (guestList == null || guestList.isEmpty()) {
            GuestResponse guestResponse = new GuestResponse();

            HashMap<String, String> errorResponse = new HashMap<String, String>();
            errorResponse.put(GuestBookErrorConst.NO_RECORDS_FOUND, GuestBookErrorConst.NO_GUESTS_FOUND);

            guestList.add(new GuestResponseWithError(errorResponse, guestResponse));
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<List<GuestResponse>>(guestList, httpStatus);
    }

    /*@GetMapping
    public ResponseEntity<List<GuestResponse>> getGuestListByGuestName( @RequestParam(value = "guestName", required = true) String guestName) throws GuestAPIException
    {
        List<GuestResponse> guestList = guestService.getGuestListByGuestName(guestName);
        HttpStatus httpStatus = HttpStatus.OK;
        if ( guestList == null || guestList.isEmpty() )
        {
            GuestResponse guestResponse = new GuestResponse();

            HashMap<String, String> errorResponse = new HashMap<String, String>();
            errorResponse.put( GuestBookErrorConst.NO_RECORDS_FOUND, GuestBookErrorConst.NO_GUESTS_FOUND );

            guestList.add( new GuestResponseWithError( errorResponse, guestResponse ) );
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<List<GuestResponse>>( guestList, httpStatus );
    }*/

    @RequestMapping(value = "/{id}/", method = RequestMethod.GET)
    public ResponseEntity<List<GuestResponse>> getGuestInfoById(@PathVariable String guestResourceId) throws GuestAPIException {
        List<GuestResponse> guestList = guestService.getGuestInfoById(guestResourceId);
        HttpStatus httpStatus = HttpStatus.OK;
        if (guestList == null || guestList.isEmpty()) {
            GuestResponse guestResponse = new GuestResponse();

            HashMap<String, String> errorResponse = new HashMap<String, String>();
            errorResponse.put(GuestBookErrorConst.NO_RECORDS_FOUND, GuestBookErrorConst.NO_GUESTS_FOUND);

            guestList.add(new GuestResponseWithError(errorResponse, guestResponse));
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<List<GuestResponse>>(guestList, httpStatus);
    }

}
