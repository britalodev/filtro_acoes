package br.com.italo.core;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class CrawlerPapelGrafBolsa {

    List<Object[]> objects = new ArrayList<>();

    public static List<String> siglas = new ArrayList<>();

    public void buscarDados() {
        siglas.clear();
        try {
            Document doc = Jsoup.connect("http://www.grafbolsa.com").get();
            doc.getElementsByTag("tr").stream().skip(4).forEach(node -> {
                Elements td = node.getElementsByTag("td");
                objects.add(td.toArray());
            });

            objects.forEach(node -> {
                String s = node[9].toString();
                s = s.substring(7, s.length());
                Pattern compile = Pattern.compile("\\w*");
                Matcher matcher = compile.matcher(s);
                if (matcher.find()) {
                    siglas.add(matcher.group());
                }
            });
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

}
