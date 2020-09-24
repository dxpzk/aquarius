package com.aquarius.api;

import com.aquarius.api.service.UserApi;
import org.springframework.stereotype.Service;

/**
 * @author zk
 * @since 2020-03-15
 */
@Service("userApi")
public class UserServiceImpl implements UserApi {
    @Override
    public String query() {
        return "111222333";
    }

    @Override
    public String getName() {
        return "做法是根据";
    }
}
