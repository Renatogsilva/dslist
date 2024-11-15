package com.br.renatogomes.dslist.services;

import com.br.renatogomes.dslist.dto.GameListDTO;
import com.br.renatogomes.dslist.entities.GameList;
import com.br.renatogomes.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> games = gameListRepository.findAll();

        return games.stream()
                .map(game -> new GameListDTO(
                        game.getId(), game.getName())).toList();
    }
}