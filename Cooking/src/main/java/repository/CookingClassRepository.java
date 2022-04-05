package repository;

import model.CookingClass;

import java.util.List;

public interface CookingClassRepository extends Repository<Integer, CookingClass> {

    List<CookingClass> findByParameter(String parameter);

}
