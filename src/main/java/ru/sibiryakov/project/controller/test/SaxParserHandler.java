package ru.sibiryakov.project.controller.test;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.sibiryakov.project.model.Names;

import java.util.ArrayList;
import java.util.List;

public class SaxParserHandler extends DefaultHandler {
    public static List<Names> list = new ArrayList<>();
    String fileType;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("data")) {
            String id = attributes.getValue("id");
            if (id.equals("history")) {
                fileType = "history";
            } else
                fileType = "security";
        }
        if (qName.equals("row")) {
            if(fileType.equals("history")){
            String secid = attributes.getValue("SECID");
            Names name = new Names(secid);
            list.add(name);}
            else
                return;
        }

    }
}




