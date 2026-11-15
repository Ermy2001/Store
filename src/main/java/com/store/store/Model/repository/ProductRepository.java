package com.store.store.Model.repository;

import com.store.store.Model.entity.Product;
import com.store.store.utils.JpaProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ProductRepository implements AutoCloseable {
    private EntityManager entityManager = JpaProvider.getJpa().getEntityManager();

    public void save(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();
    }

    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public void close() throws Exception {

    }
}
