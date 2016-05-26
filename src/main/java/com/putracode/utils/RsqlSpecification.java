package com.putracode.utils;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by KrisnaPutra on 5/23/2016.
 */
public class RsqlSpecification {
    public static <T> Specification<T> rsql(final String rsqlQuery) {
        return new Specification<T>() {
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
               if(StringUtils.isNotBlank(rsqlQuery)){
                   Node rsql =new RSQLParser().parse(rsqlQuery);
                   return rsql.accept(new JPARsqlConverter(cb), root);
               }else
                   return null;
            }
        };
    }
}
