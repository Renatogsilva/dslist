package com.br.renatogomes.dslist.services;

import com.br.renatogomes.dslist.dto.GameDTO;
import com.br.renatogomes.dslist.dto.GameMinDTO;
import com.br.renatogomes.dslist.entities.Game;
import com.br.renatogomes.dslist.projections.GameMinProjection;
import com.br.renatogomes.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id).get();

        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();

        return games.stream()
                .map(game -> new GameMinDTO(
                        game.getId(), game.getTitle(),
                        game.getYear(), game.getImgUrl(),
                        game.getShortDescription())).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> listGameMinProjection = this.gameRepository.searchByList(listId);

        return listGameMinProjection.stream().map(gameMin -> new GameMinDTO(gameMin.getId(), gameMin.getTitle(),
                gameMin.getYear(), gameMin.getImgUrl(),
                gameMin.getShortDescription())).toList();
    }
}
