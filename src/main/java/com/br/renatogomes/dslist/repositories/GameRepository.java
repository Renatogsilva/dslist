package com.br.renatogomes.dslist.repositories;

import com.br.renatogomes.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
