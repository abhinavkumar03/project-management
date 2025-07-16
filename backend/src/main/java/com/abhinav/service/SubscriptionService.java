package com.abhinav.service;

import com.abhinav.domain.PlanType;
import com.abhinav.model.Subscription;
import com.abhinav.model.User;

public interface SubscriptionService {
    Subscription createSubscription(User user);
    Subscription getUserSubscription(Long userId) throws Exception;
    Subscription upgradeSubscription(Long userId, PlanType planType);

    boolean isValid(Subscription subscription);
}
