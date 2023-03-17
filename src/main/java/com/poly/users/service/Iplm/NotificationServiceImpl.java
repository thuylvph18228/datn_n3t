package com.poly.users.service.Iplm;

import com.poly.users.entity.Notification;
import com.poly.users.service.NotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Override
    @Transactional
    public List<Notification> getAll() {
        return null;
    }

    @Override
    @Transactional
    public Notification save(Notification notification) {
        return null;
    }

    @Override
    @Transactional
    public Notification update(Notification notification) {
        return null;
    }

    @Override
    @Transactional
    public Notification delete(int id) {
        return null;
    }
}
