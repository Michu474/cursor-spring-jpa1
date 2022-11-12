package com.example.cursorspringjpa.repository;

import com.example.cursorspringjpa.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class HibernateRepository  extends RepositoryBase{

    @PersistenceContext
    EntityManager manager;

    @Transactional
    public List<Product> selectProductsHib(){
        Query selectAll = manager.createQuery("select p from Product p");
        System.out.println(selectAll.getResultList().toString());
        return selectAll.getResultList();
    }

}
