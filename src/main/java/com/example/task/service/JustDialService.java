package com.example.task.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class JustDialService {


    public Map<String, Object> scrapJustDial() {
        Document doc;
        Map<String, Object> selectorsMap = new HashMap<>();
        {
            try {
                doc = Jsoup.connect("https://www.justdial.com/Mumbai/Sangam-Mandap-Decorator-Near-National-Sports-Club-Of-India-and-Buddh-Mandir-Worli/022PXX22-XX22-120519010306-C8K9_BZDET?ncatid=10010816&area=&search=Top%20Air%20Coolers%20On%20Rent%20in%20Mumbai&mncatname=Air%20Coolers%20On%20Rent&search_id=e735d3ee60b3643908a6a36754adf96dd85ba912b663a727fa49522757a40e5d&abd_btn=&abd_heading=")
                        .header("referer", "https://www.google.com/")
                        .header("user-agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36").timeout(30000).get();
                Element element = doc.getElementById("mainContent");
                Elements firstDiv = element.getAllElements();
                for (Element e : firstDiv) {
                    selectorsMap.put(e.id(), e.getElementsByTag("div").text());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return selectorsMap;
    }

}
