package com.anbima.selic.predicate;

import com.anbima.selic.model.QSelic;
import com.querydsl.core.BooleanBuilder;

public class SelicPredicate {

    private BooleanBuilder builder;

    public SelicPredicate() {
        this.builder = new BooleanBuilder();
    }

    public BooleanBuilder build() {
        return builder;
    }

    public SelicPredicate comAno(Integer ano) {
        if (ano != null) {
            builder.and(QSelic.selic.ano.eq(ano));
        }
        return this;
    }

    public SelicPredicate comMes(Integer mes) {
        if (mes != null) {
            builder.and(QSelic.selic.mes.eq(mes));
        }
        return this;
    }
}
