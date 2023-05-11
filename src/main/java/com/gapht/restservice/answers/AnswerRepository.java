package com.gapht.restservice.answers;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "answers", path = "answers")
@CrossOrigin
public interface AnswerRepository extends PagingAndSortingRepository<Answer, Long>, CrudRepository<Answer, Long> {

  List<Answer> findByUuid(@Param("uuid") UUID uuid);

}