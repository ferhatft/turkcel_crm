package com.turkcell.pair6.customerservice.core.service.abstracts;

public interface MessageService {
    String getMessage(String key);
    String getMessageWithArgs(String key, Object... args);
}