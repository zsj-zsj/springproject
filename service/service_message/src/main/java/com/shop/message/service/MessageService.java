package com.shop.message.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface MessageService {

    Boolean sendMessage(Map<String, Object> code, String mobile);
}
