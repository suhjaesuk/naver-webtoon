package com.naver.webtoon.webtoon.repository;

import com.naver.webtoon.webtoon.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByName(String name);
}
