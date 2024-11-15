package com.br.renatogomes.dslist.repositories;

import com.br.renatogomes.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}