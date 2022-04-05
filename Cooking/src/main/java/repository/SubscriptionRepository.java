package repository;

import model.Subscription;

import java.util.List;

public interface SubscriptionRepository extends Repository<Integer, Subscription> {

    List filterByClass(String cookingClass);

}
