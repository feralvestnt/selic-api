package com.anbima.selic.repository;

import com.anbima.selic.model.Selic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SelicRepository extends CrudRepository<Selic, Integer>, SelicRepositoryCustom {

    Selic findByDataReferencia(LocalDate date);
}
