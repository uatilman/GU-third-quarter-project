package ru.tilman.gb.patterns;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        NodeList nodeList = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse("http://www.cbr.ru/scripts/XML_daily.asp")
                .getDocumentElement()
                .getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getAttributes().getNamedItem("ID").getNodeValue().equals("R01235")) {
                NodeList currentValutaList = nodeList.item(i).getChildNodes();
                for (int j = 0; j < currentValutaList.getLength(); j++) {
                    if (currentValutaList.item(j).getNodeName().equals("Value")) {
                        System.out.println(currentValutaList.item(j).getTextContent());
                        return;
                    }
                }
                return;
            }
        }

    }
}
