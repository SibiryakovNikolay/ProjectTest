package ru.sibiryakov.project.controller.test;

import org.xml.sax.SAXException;
import ru.sibiryakov.project.model.Names;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxMyParser {
    public Names parse(String fileName){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        File file = new File(fileName);
        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            e.printStackTrace();
            return null;
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
        return null;
    }

}
