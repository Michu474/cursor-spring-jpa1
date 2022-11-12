package com.example.cursorspringjpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class RepositoryBase {
    @PersistenceContext
    EntityManager manager;

}
