package com.br.renatogomes.dslist.controller;

import com.br.renatogomes.dslist.dto.GameDTO;
import com.br.renatogomes.dslist.dto.GameMinDTO;
import com.br.renatogomes.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameDTO findById(@PathVariable Long id) {
        return this.gameService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameMinDTO> findAll(){
        return this.gameService.findAll();
    }
}
