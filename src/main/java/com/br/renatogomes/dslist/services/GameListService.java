package com.br.renatogomes.dslist.services;

import com.br.renatogomes.dslist.dto.GameListDTO;
import com.br.renatogomes.dslist.entities.GameList;
import com.br.renatogomes.dslist.projections.GameMinProjection;
import com.br.renatogomes.dslist.repositories.GameListRepository;
import com.br.renatogomes.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> games = gameListRepository.findAll();

        return games.stream()
                .map(game -> new GameListDTO(
                        game.getId(), game.getName())).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = this.gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}