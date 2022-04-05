package service;

import model.CookingClass;
import model.Subscription;
import repository.CookingClassRepository;
import repository.SubscriptionRepository;

import java.util.ArrayList;
import java.util.List;


public class Service {

    private CookingClassRepository c1Repo;
    private SubscriptionRepository c2Repo;

    public Service(CookingClassRepository c1Repo, SubscriptionRepository c2Repo) {

        this.c1Repo = c1Repo;
        this.c2Repo = c2Repo;

    }

    public CookingClass add1(CookingClass c) {
        return c1Repo.add(c);
    }

    public List<CookingClass> getAll1(){
        List<CookingClass> lc=new ArrayList<>();
        for(CookingClass c:c1Repo.findAll()){
            lc.add(c);
        }
        return lc;
    }

    public Subscription add2(Subscription c){return c2Repo.add(c);}

    public List<Subscription> getAll2(){
        List<Subscription> lc=new ArrayList<>();
        for(Subscription c:c2Repo.findAll()){
            lc.add(c);
        }
        return lc;
    }

    public CookingClass getInfo(String value){
        for (CookingClass p: c1Repo.findAll()){
            if (p.getDate().equals(value))
                return p;
        }
        return null;
    }

    public List<CookingClass> getByParameter(String parameter) {
        return c1Repo.findByParameter(parameter);
    }

    public List<Subscription> getReport1(String value){
        return c2Repo.filterByClass(value);
    }


}
