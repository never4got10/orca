package org.nettoall.orca.datarest.repository;

import org.nettoall.orca.datarest.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Spring MVC가 @RepositoryRestResource annotaion을 보고 endpoint /people 생성
 */
@RepositoryRestResource(collectionResourceRel = "people", path="people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, CrudRepository<Person, Long> {
    List<Person> findByLastName(@Param("name") String name);
}
