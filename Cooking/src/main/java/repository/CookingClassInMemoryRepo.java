package repository;

import model.CookingClass;

import java.util.List;
import java.util.stream.Collectors;

public class CookingClassInMemoryRepo extends AbstractRepository<Integer, CookingClass> implements CookingClassRepository {

    public CookingClassInMemoryRepo() {
    }

    @Override
    public List<CookingClass> findByParameter(String parameter) {

        return getAll().stream().filter(x -> x.getDate().toLowerCase().contains(parameter.toLowerCase())).collect(Collectors.toList());

    }

}
