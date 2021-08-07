package com.urlcurtas.repository;
import com.urlcurtas.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {

    Link findById(long id);

}
