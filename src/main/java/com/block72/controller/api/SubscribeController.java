package com.block72.controller.api;

import com.block72.common.ErrorCode;
import com.block72.common.JsonResponse;
import com.block72.common.ServiceException;
import com.block72.model.Subscriber;
import com.block72.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jiateng on 11/1/18.
 */
@RestController

public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;

    @PostMapping
    @RequestMapping(value = "/api/subscribe", produces = "application/json")
    public JsonResponse subscribe(@RequestBody Subscriber subscriber) throws ServiceException {
        if (subscribeService.getSubscriberByEmail(subscriber.getEmail()) != null)
            throw new ServiceException(ErrorCode.FAIL.getCode(), "Email = " + subscriber.getEmail() + "exists");
        subscriber = subscribeService.subscribe(subscriber);
        return new JsonResponse(subscriber);
    }
}
