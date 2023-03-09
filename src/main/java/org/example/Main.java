package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collections;

import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        System.setErr(new PrintStream(System.err, true, "UTF-8"));
        Document doc = Jsoup.connect("https://www.krylatskoye.ru/content/ratings/2021/09/0928.html").get();
        Element table = doc.select("table").first();
        Elements rows = table.select("tr");
        ArrayList<String> cities = new ArrayList<String>();
        for(int i = 2; i < rows.size(); i++){
            Element row = rows.get(i);
            Elements cols = row.select("td");
            cities.add(cols.get(1).text());
        }
        Collections.sort(cities);
        for (String s: cities
             ) {
            System.out.println(s);
        }
    }
}