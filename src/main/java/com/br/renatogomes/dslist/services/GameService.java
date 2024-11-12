package com.br.renatogomes.dslist.services;

import com.br.renatogomes.dslist.dto.GameMinDTO;
import com.br.renatogomes.dslist.entities.Game;
import com.br.renatogomes.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();

        return games.stream()
                .map(game -> new GameMinDTO(
                        game.getId(), game.getTitle(),
                        game.getYear(), game.getImgUrl(),
                        game.getShortDescription())).toList();
    }
}
