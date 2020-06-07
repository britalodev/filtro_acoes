package br.com.italo;

import br.com.italo.core.CrawlerPapelFundamentus;
import br.com.italo.core.CrawlerPapelGrafBolsa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FiltroAcoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiltroAcoesApplication.class, args);
		new CrawlerPapelGrafBolsa().buscarDados();
		new CrawlerPapelFundamentus().buscarDados();
	}

}
