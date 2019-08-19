package com.anbima.selic.repository;

import com.anbima.selic.model.Selic;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

import static com.anbima.selic.model.QSelic.selic;

public class SelicRepositoryImpl {

    @Autowired
    EntityManager entityManager;

    public List<Selic> findByFilter(Predicate predicate) {
        return new JPAQueryFactory(entityManager)
                .select(selic)
                .from(selic)
                .where(predicate)
                .fetch();
    }
}
