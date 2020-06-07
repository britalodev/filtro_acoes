package br.com.italo.service;

import br.com.italo.mapper.PapelMapper;
import br.com.italo.repository.Papel;
import br.com.italo.rest.response.PapelBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.italo.core.CrawlerPapelFundamentus.papeisMapeados;

@Service
@Slf4j
public class PapeisSmallsService {

    public PapelBean adicionar(String sigla) {
        Optional<Papel> papelLocalizado = papeisMapeados.stream().filter(papel -> papel.getSigla().equalsIgnoreCase(sigla)).findFirst();
        if (papelLocalizado.isPresent()) {
            return PapelMapper.INSTANCE.papelToPapelBean(papelLocalizado.get());
        }
        return new PapelBean();
    }

}
