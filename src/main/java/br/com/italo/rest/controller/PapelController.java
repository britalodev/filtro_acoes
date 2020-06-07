package br.com.italo.rest.controller;


import br.com.italo.rest.response.PapelBean;
import br.com.italo.service.PapelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spi.service.contexts.PathContext;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@RequestMapping(path = "acoes")
@RestController
public class PapelController {

    PapelService papelService;

    @Autowired
    public PapelController(PapelService papelService) {
        this.papelService = papelService;
    }

    @GetMapping(path = "/abaixo/{preco}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PapelBean> papeisAbaixoDe(@PathVariable float preco){
        return papelService.papeisAbaixoDe(preco);
    }

    @GetMapping(path = "/acima/{preco}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PapelBean> papeisAcimaDe(@PathVariable float preco){
        return papelService.papeisAcimaDe(preco);
    }

    @GetMapping(path = "/entre/{menor}/e/{maior}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PapelBean> papeisEntre(@PathVariable float menor, @PathVariable float maior){
        return papelService.papeisEntre(menor,maior);
    }
}