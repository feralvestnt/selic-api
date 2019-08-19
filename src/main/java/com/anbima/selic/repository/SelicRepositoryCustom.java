package com.anbima.selic.repository;

import com.anbima.selic.model.Selic;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface SelicRepositoryCustom {

    List<Selic> findByFilter(Predicate predicate);
}
