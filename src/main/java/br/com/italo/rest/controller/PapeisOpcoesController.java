package br.com.italo.rest.controller;


import br.com.italo.rest.response.PapelBean;
import br.com.italo.service.PapeisOpcoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "opcoes")
@RestController
public class PapeisOpcoesController {

    @Autowired
    PapeisOpcoesService papeisOpcoesService;

    @PostMapping(path = "adicionar/{sigla}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PapelBean adicionarNovaAcaoOpcao(@PathVariable String sigla) {
        return papeisOpcoesService.adicionarOpcao(sigla);
    }

}
