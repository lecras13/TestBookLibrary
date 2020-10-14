package com.epam.booklibrary.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Criteria {
    private Map<String, String> criteria = new HashMap<String, String>();

    public Criteria(){
    }

    public void add(String searchCriteria, String value){
        criteria.put(searchCriteria, value);
    }

    public Map<String, String> getCriteria(){
        return criteria;
    }

    public void setCriteria(Map<String, String> criteria){
        this.criteria = criteria;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (!(o instanceof Criteria)) {
            return false;
        }

        Criteria criteria1 = (Criteria) o;
        return Objects.equals(criteria, criteria1.criteria);
    }

    @Override
    public int hashCode(){
        return criteria != null ? criteria.hashCode() : 0;
    }

    @Override
    public String toString(){
        return "Criteria{" +
                "criteria=" + criteria +
                '}';
    }
}
