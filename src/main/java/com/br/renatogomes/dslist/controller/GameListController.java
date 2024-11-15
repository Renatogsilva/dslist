package com.br.renatogomes.dslist.controller;

import com.br.renatogomes.dslist.dto.GameListDTO;
import com.br.renatogomes.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameListDTO> findAll(){
        return this.gameListService.findAll();
    }
}
