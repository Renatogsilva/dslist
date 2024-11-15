package com.br.renatogomes.dslist.controller;

import com.br.renatogomes.dslist.dto.GameListDTO;
import com.br.renatogomes.dslist.dto.GameMinDTO;
import com.br.renatogomes.dslist.dto.ReplacementDTO;
import com.br.renatogomes.dslist.services.GameListService;
import com.br.renatogomes.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameListDTO> findAll(){
        return this.gameListService.findAll();
    }

    @GetMapping("/{listId}/games")
    @ResponseStatus(HttpStatus.OK)
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return this.gameService.findByList(listId);
    }

    @PostMapping("/{listId}/replacement")
    @ResponseStatus(HttpStatus.OK)
    public void findByList(@PathVariable Long listId, @RequestBody ReplacementDTO replacementDTO){
        this.gameListService.move(listId, replacementDTO.getSourceIndex(), replacementDTO.getDestinationIndex());
    }
}
