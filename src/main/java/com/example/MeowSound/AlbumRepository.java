package com.example.MeowSound;

import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Artist, Long> {

}