package br.com.italo.rest.controller;


import br.com.italo.rest.response.PapelBean;
import br.com.italo.service.PapeisSmallsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "smalls")
@RestController
public class PapeisSmallsController {

    @Autowired
    PapeisSmallsService papeisSmallsService;

    @PostMapping(path = "adicionar/{sigla}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PapelBean adicionarSmalls(@PathVariable String sigla){
        return papeisSmallsService.adicionar(sigla);
    }

}
