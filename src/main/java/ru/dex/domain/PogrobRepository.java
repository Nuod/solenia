package ru.dex.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PogrobRepository extends JpaRepository<Pogreb, Integer> {
}
