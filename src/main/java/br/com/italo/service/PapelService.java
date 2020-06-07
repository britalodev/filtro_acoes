package br.com.italo.service;


import br.com.italo.mapper.PapelMapper;
import br.com.italo.rest.response.PapelBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.italo.core.CrawlerPapelFundamentus.papeisMapeados;


@Service
@Slf4j
public class PapelService {


    public List<PapelBean> papeisAbaixoDe(float preco) {

        List<PapelBean> papeisFiltrados = new ArrayList<>();

        papeisMapeados.stream().filter(papel -> papel.getCotacao() <= formataValorDaURL(preco)).collect(Collectors.toList())
        .forEach(papel -> papeisFiltrados.add(PapelMapper.INSTANCE.papelToPapelBean(papel)));

        return papeisFiltrados;
    }

    public List<PapelBean> papeisAcimaDe(float preco) {

        List<PapelBean> papeisFiltrados = new ArrayList<>();

        papeisMapeados.stream().filter(papel -> papel.getCotacao() >= formataValorDaURL(preco)).collect(Collectors.toList())
                .forEach(papel -> papeisFiltrados.add(PapelMapper.INSTANCE.papelToPapelBean(papel)));

        return papeisFiltrados;
    }

    public List<PapelBean> papeisEntre(float menor, float maior) {

        List<PapelBean> papeisFiltrados = new ArrayList<>();

        papeisMapeados.stream().filter(papel -> papel.getCotacao() <= formataValorDaURL(maior) && papel.getCotacao() >= formataValorDaURL(menor)).collect(Collectors.toList())
                .forEach(papel -> papeisFiltrados.add(PapelMapper.INSTANCE.papelToPapelBean(papel)));

        return papeisFiltrados;
    }


    private float formataValorDaURL(float valor){
        return valor/100;
    }
}
