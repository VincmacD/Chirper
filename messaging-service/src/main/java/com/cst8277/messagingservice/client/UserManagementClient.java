package com.cst8277.messagingservice.client;

import com.cst8277.usermanagementservice.entity.UserRole;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;


import java.util.List;
import java.util.UUID;

@HttpExchange
public interface UserManagementClient {
    @GetExchange("/ums/user-roles/id2/{user_id}")
    public List<UserRole> findByIdCustom(@PathVariable("user_id") UUID user_id);
}
