package br.com.stoom.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @GetMapping
    public ResponseEntity<String> teste(){
        return ResponseEntity.status(HttpStatus.OK).body("funcionado");
    }

    // @GetMapping
    // public String teste(){
    //     return "funcionado";
    // }
    
}
