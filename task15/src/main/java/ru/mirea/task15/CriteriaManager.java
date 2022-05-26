package ru.mirea.task15;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriteriaManager<T> {
    private CriteriaBuilder builder;
    private CriteriaQuery<T> criteriaQuery;
    private Root<T> root;
}
