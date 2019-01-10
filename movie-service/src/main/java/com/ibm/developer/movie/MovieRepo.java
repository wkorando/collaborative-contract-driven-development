package com.ibm.developer.movie;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movie, Long> {

}
