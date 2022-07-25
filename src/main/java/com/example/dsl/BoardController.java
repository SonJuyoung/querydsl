package com.example.dsl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping(value = {"/{title}/{id}/{ctnt}", "/{title}/{id}"})
    public List<BoardEntity> test(@PathVariable String title, @PathVariable int id, @PathVariable(required = false) String ctnt) {
        System.out.println(ctnt);
        return boardRepository.aaa(title, id, ctnt);
    }
}
