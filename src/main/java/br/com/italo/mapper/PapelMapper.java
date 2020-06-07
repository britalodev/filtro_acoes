package br.com.italo.mapper;

import br.com.italo.repository.Papel;
import br.com.italo.rest.response.PapelBean;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PapelMapper {

    PapelMapper INSTANCE = Mappers.getMapper(PapelMapper.class);

    @Mapping(source = "sigla", target = "sigla")
    @Mapping(source = "cotacao", target = "cotacao")
    @Mapping(source = "pl", target = "pl")
    @Mapping(source = "pvp", target = "pvp")
    @Mapping(source = "psr", target = "psr")
    @Mapping(source = "divYeld", target = "divYeld")
    @Mapping(source = "PAtivo", target = "PAtivo")
    @Mapping(source = "PCapGiro", target = "PCapGiro")
    @Mapping(source = "PEbit", target = "PEbit")
    @Mapping(source = "PAtivCircLiq", target = "PAtivCircLiq")
    @Mapping(source = "evEbit", target = "evEbit")
    @Mapping(source = "evEbitida", target = "evEbitida")
    @Mapping(source = "mrgEbit", target = "mrgEbit")
    @Mapping(source = "mrgLiq", target = "mrgLiq")
    @Mapping(source = "liqCorr", target = "liqCorr")
    @Mapping(source = "roic", target = "roic")
    @Mapping(source = "roe", target = "roe")
    @Mapping(source = "liq2meses", target = "liq2meses")
    @Mapping(source = "patrimLiq", target = "patrimLiq")
    @Mapping(source = "divBrutPatrim", target = "divBrutPatrim")
    @Mapping(source = "crescrec5a", target = "crescrec5a")
    PapelBean papelToPapelBean(Papel papel);

}
