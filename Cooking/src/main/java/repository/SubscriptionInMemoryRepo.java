package repository;

import model.Subscription;

import java.util.List;
import java.util.stream.Collectors;

public class SubscriptionInMemoryRepo extends AbstractRepository<Integer, Subscription> implements SubscriptionRepository {

    public SubscriptionInMemoryRepo() {
    }

    @Override
    public List filterByClass(String cookingClass) {

        return getAll().stream().filter(x -> x.getCookingClass().equals((cookingClass))).collect((Collectors.toList()));

    }

}
