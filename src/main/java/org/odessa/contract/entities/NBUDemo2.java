package org.odessa.contract.entities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NBUDemo2 {
	
	
	
	public static void main(String[] args)
    {
        try
        {
        	
        	File xmlFile1 = new File("D:\\currency.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder;
				
				documentBuilder = documentBuilderFactory.newDocumentBuilder();
				Document document = documentBuilder.parse(xmlFile1);
				document.getDocumentElement().normalize();
                
                System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());
                NodeList nodeList = document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(1).getNodeName());
                System.out.println("--------------------");
                int tmp =5;
                //int tmp =19;
                    Node node = nodeList.item(tmp);
                    if(node.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element element = (Element)node;
                        System.out.println("Kurs #" + tmp + ":");
                        //System.out.println("rate: " + element.getElementsByTagName("rate").item(0).getChildNodes().item(0).getNodeValue());
                        System.out.println("rate: " + element.getElementsByTagName("Value").item(0).getChildNodes().item(0).getNodeValue());
                        Double kurs= Double.valueOf(element.getElementsByTagName("Value").item(0).getChildNodes().item(0).getNodeValue());
                        kurs = kurs/100;
                        kurs = new BigDecimal(kurs).setScale(3, RoundingMode.HALF_UP).doubleValue();
                        System.out.println("Dollar: " + kurs);
                    }
            
        }
        catch (Exception e)
        {             
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

}
