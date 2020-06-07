package br.com.italo.utils;

import org.springframework.stereotype.Service;

@Service
public class CasaDecimalUtils {

    public static String removeCasaDecimal(String valor) {
        valor = valor.replace(".", "");
        int quantidadeDeCasasAntesDoPonto = valor.length() - 2;
        String valoresAntesDoPonto = valor.subSequence(0, (valor.length() - 2)).toString();
        String valoresDepoisDoPonto = valor.subSequence(quantidadeDeCasasAntesDoPonto, valor.length()).toString();
        String valorDeRetorno = valoresAntesDoPonto + "." + valoresDepoisDoPonto;
        return valorDeRetorno;
    }

    public static String[] trataEspacoesPontosEPorcentagens(String papelAtivo) {

        return papelAtivo.replaceAll(",", ".").replaceAll("%", "").split(" ");

    }

}
