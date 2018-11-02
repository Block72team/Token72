package com.block72.service.impl;

import com.block72.mapper.SubscriberMapper;
import com.block72.model.Subscriber;
import com.block72.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Jiateng on 11/1/18.
 */
@Service
public class SubscribeServiceImpl implements SubscribeService {

    @Autowired
    private SubscriberMapper subscriberMapper;

    @Override
    public Subscriber subscribe(Subscriber subscriber) {
        subscriber.setCreateTime(new Timestamp(System.currentTimeMillis()));
        subscriber.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        int res = subscriberMapper.insert(subscriber);

        return res == 1 ? subscriber : null;
    }

    @Override
    public Subscriber getSubscriberById(long id) {
        return subscriberMapper.selectByPrimaryKey(id);
    }

    @Override
    public Subscriber getSubscriberByName(String firstName, String lastName) {
        Example example = Example.builder(Subscriber.class).
                where(Sqls.custom().
                        andEqualTo("first_name", firstName).
                        andEqualTo("last_name", lastName)).build();
        List<Subscriber> subscribers = subscriberMapper.selectByExample(example);
        return subscribers.size() == 0 ? null : subscribers.get(0);
    }

    @Override
    public Subscriber getSubscriberByEmail(String email) {
        Example example = Example.builder(Subscriber.class).
                where(Sqls.custom().
                        andEqualTo("email", email)).build();
        List<Subscriber> subscribers = subscriberMapper.selectByExample(example);
        return subscribers.size() == 0 ? null : subscribers.get(0);
    }
}
