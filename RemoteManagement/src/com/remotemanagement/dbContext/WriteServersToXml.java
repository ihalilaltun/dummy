/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remotemanagement.dbContext;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author cooper
 */
public class WriteServersToXml {

    public static final String EPATH = System.getProperty("user.dir") + "/" + "conf/servers.xml";
    StringWriter sw;
    FileWriter fw;
    DocumentBuilderFactory docFactory;
    DocumentBuilder docBuilder;
    Document doc;
    Node defaultNode;
    Node newNode;
    Transformer transformer;
    StreamResult result;
    DOMSource source;
    File f;

    public void writeXML(String host) {
        BufferedWriter output = null;
        try {
            f = new File(EPATH);
            if (!f.exists()) {
                try {
                    f.createNewFile();
                    fw = new FileWriter(f);
                    sw = new StringWriter();
                    sw.write("<?xml version='1.0' ?>\n");
                    sw.write("<Servers>\n	<server>localhost</server>\n</Servers>");
                    sw.close();
                    fw.write(sw.toString());
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(WriteServersToXml.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                docFactory = DocumentBuilderFactory
                        .newInstance();
                docBuilder = docFactory.newDocumentBuilder();
                doc = docBuilder.parse(EPATH);
                defaultNode = doc.getFirstChild();
                newNode = doc.createElement("server");
                newNode.setTextContent(host);
                defaultNode.appendChild(newNode);

            } catch (ParserConfigurationException | SAXException | IOException ex) {
                Logger.getLogger(WriteServersToXml.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            } catch (TransformerConfigurationException | TransformerFactoryConfigurationError e) {
            }
            result = new StreamResult(new StringWriter());
            source = new DOMSource(doc);
            try {
                transformer.transform(source, result);
            } catch (TransformerException e) {
            }
            String xmlString = result.getWriter().toString();
            File fileToWrite = new File(EPATH);
            output = new BufferedWriter(new FileWriter(fileToWrite));
            output.write(xmlString);
            output.close();

        } catch (IOException ex) {
            Logger.getLogger(WriteServersToXml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(WriteServersToXml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<String> returnExistingHosts() {
        ArrayList<String> comboList = new ArrayList<>();

        try {
            docFactory = DocumentBuilderFactory
                    .newInstance();
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(EPATH);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(WriteServersToXml.class.getName()).log(Level.SEVERE, null, ex);
        }

        NodeList nodeList = doc.getElementsByTagName("server");
        for (int i = 0; i < nodeList.getLength(); i++) {
            // Get element
            Element element = (Element) nodeList.item(i);
            comboList.add(element.getChildNodes().item(0).getNodeValue());
        }
        return comboList;
    }

    public boolean hostExists(String host) {

        boolean retVal = false;
        try {
            docFactory = DocumentBuilderFactory
                    .newInstance();
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(EPATH);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(WriteServersToXml.class.getName()).log(Level.SEVERE, null, ex);
        }

        NodeList nodeList = doc.getElementsByTagName("server");
        for (int i = 0; i < nodeList.getLength(); i++) {
            // Get element
            Element element = (Element) nodeList.item(i);
            if (element.getChildNodes().item(0).getNodeValue().contains(host)) {
                retVal = true;
            }
        }

        return retVal;
    }

}
