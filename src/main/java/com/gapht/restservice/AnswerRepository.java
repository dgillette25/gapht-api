package com.gapht.restservice;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "answers", path = "answers")
public interface AnswerRepository extends PagingAndSortingRepository<Answer, Long>, CrudRepository<Answer, Long> {

  List<Answer> findById(@Param("id") long id);

}