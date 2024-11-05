package com.easybytes.cards.repository;

import com.easybytes.cards.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IcardsRepository extends JpaRepository<Cards, Long> {
}
