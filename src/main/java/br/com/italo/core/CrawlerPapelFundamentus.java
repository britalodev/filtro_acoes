package br.com.italo.core;


import br.com.italo.repository.Papel;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static br.com.italo.core.CrawlerPapelGrafBolsa.siglas;
import static br.com.italo.utils.CasaDecimalUtils.removeCasaDecimal;
import static br.com.italo.utils.CasaDecimalUtils.trataEspacoesPontosEPorcentagens;

@Slf4j
@Component
public class CrawlerPapelFundamentus {


    @Autowired
    FiltroDePapeis filtroDePapeis;

    public static Collection<Papel> papeisMapeados = new ArrayList<>();

    public void buscarDados() {
        papeisMapeados.clear();
        new CrawlerPapelGrafBolsa().buscarDados();
        try {

            Document doc = Jsoup.connect("http://www.fundamentus.com.br/resultado.php").get();
            doc.getElementsByTag("tr").removeAttr("class").eachText().stream().skip(1).forEach(papelAtivo -> {
                Papel papel = mapperPapel(trataEspacoesPontosEPorcentagens(papelAtivo));
                if (siglas.contains(papel.getSigla())) {
                    papeisMapeados.add(papel);
                }
            });
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private Papel mapperPapel(String[] split) {
        Papel papel = new Papel();
        papel.setSigla(split[0]);
        papel.setCotacao(Float.parseFloat(removeCasaDecimal(split[1])));
        papel.setPl(Float.parseFloat(removeCasaDecimal(split[2])));
        papel.setPvp(Float.parseFloat(removeCasaDecimal(split[3])));
        papel.setPsr(Float.parseFloat(removeCasaDecimal(split[4])));
        papel.setDivYeld(Float.parseFloat(removeCasaDecimal(split[5])));
        papel.setPAtivo(Float.parseFloat(removeCasaDecimal(split[6])));
        papel.setPCapGiro(Float.parseFloat(removeCasaDecimal(split[7])));
        papel.setPEbit(Float.parseFloat(removeCasaDecimal(split[8])));
        papel.setPAtivCircLiq(Float.parseFloat(removeCasaDecimal(split[9])));
        papel.setEvEbit(Float.parseFloat(removeCasaDecimal(split[10])));
        papel.setEvEbitida(Float.parseFloat(removeCasaDecimal(split[11])));
        papel.setMrgEbit(Float.parseFloat(removeCasaDecimal(split[12])));
        papel.setMrgLiq(Float.parseFloat(removeCasaDecimal(split[13])));
        papel.setLiqCorr(Float.parseFloat(removeCasaDecimal(split[14])));
        papel.setRoic(Float.parseFloat(removeCasaDecimal(split[15])));
        papel.setRoe(Float.parseFloat(removeCasaDecimal(split[16])));
        papel.setLiq2meses(Float.parseFloat(removeCasaDecimal(split[17])));
        papel.setPatrimLiq(Float.parseFloat(removeCasaDecimal(split[18])));
        papel.setDivBrutPatrim(Float.parseFloat(removeCasaDecimal(split[19])));
        papel.setCrescrec5a(Float.parseFloat(removeCasaDecimal(split[20])));

        return papel;
    }

}