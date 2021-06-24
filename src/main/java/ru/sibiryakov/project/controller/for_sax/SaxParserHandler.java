package ru.sibiryakov.project.controller.for_sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import ru.sibiryakov.project.model.InfoAboutSecurities;
import ru.sibiryakov.project.model.TradingHistory;
import java.util.ArrayList;
import java.util.List;

/**/

public class SaxParserHandler extends DefaultHandler {
    public static List<TradingHistory> listHistory = new ArrayList<>();
    public static List<InfoAboutSecurities> listSecurities = new ArrayList<>();
    public static String fileType;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("data")) {
            String id = attributes.getValue("id");
            if (id.equals("history")) {
                fileType = "history";
            } else if (id.equals("securities")) {
                fileType = "security";
            } else return;
        }
        if (qName.equals("row")) {
            if (fileType.equals("history")) {
                String tradeDate = attributes.getValue("TRADEDATE");
                String secid = attributes.getValue("SECID");
                String numtrades = attributes.getValue("NUMTRADES");
                String open = attributes.getValue("OPEN");
                String close = attributes.getValue("CLOSE");
                listHistory.add(new TradingHistory(secid, tradeDate, numtrades, open, close));
            } else if (fileType.equals("security")) {
                int id = Integer.parseInt(attributes.getValue("id"));
                String secid = attributes.getValue("secid");
                String regnumber = attributes.getValue("regnumber");
                String name = attributes.getValue("name");
                String emitent_title = attributes.getValue("emitent_title");
                listSecurities.add(new InfoAboutSecurities(id, secid, regnumber, name, emitent_title));
            }

        }

    }
}




