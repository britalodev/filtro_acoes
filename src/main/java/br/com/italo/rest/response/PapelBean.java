package br.com.italo.rest.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class PapelBean {

	private String sigla;
	private float cotacao;
	private float pl;
	private float pvp;
	private float psr;
	private float divYeld;
	private float pAtivo;
	private float pCapGiro;
	private float pEbit;
	private float pAtivCircLiq;
	private float evEbit;
	private float evEbitida;
	private float mrgEbit;
	private float mrgLiq;
	private float liqCorr;
	private float roic;
	private float roe;
	private float liq2meses;
	private float patrimLiq;
	private float divBrutPatrim;
	private float crescrec5a;
}
