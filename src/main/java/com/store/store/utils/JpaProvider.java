package com.store.store.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

public class JpaProvider {
    @Getter
    private static final JpaProvider jpa = new JpaProvider();
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("shop-unit");

    private JpaProvider() {}

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
