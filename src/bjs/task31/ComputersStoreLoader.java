package bjs.task31;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by U-1 on 17.01.2016.
 */
public class ComputersStoreLoader{
    /**Object which presents hierarchy for whole XML document*/
    private ComputersStore computersStore;

    /**Reference to the DOM*/
    Document document;
    /**Reference to the root node*/
    Element rootElement;

    public ComputersStoreLoader (ComputersStore computersStore) {
        this.computersStore = computersStore;
    }

    /**
     * Parses XML document
     * @param xmlFile Path to the XML file
     * @return True if successfully parsed
     */
    public boolean parse(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            document = documentBuilder.parse(xmlFile);
            rootElement = document.getDocumentElement();
        }
        catch (Exception e ) {
            System.out.println("Failed to parse XML. " + e);
            return false;
        }

        getComputerCatalogs();

        return true;
    }

    /**
     * Loads all "catalog" entities
     */
    protected void getComputerCatalogs() {
       for (Node child = rootElement.getFirstChild(); child != null; child = child.getNextSibling()) {
            if (child.getNodeType() == child.ELEMENT_NODE) {
                int id = Integer.parseInt(child.getAttributes().getNamedItem("id").getNodeValue());
                ComputersCatalog computersCatalog = new ComputersCatalog(id);
                computersStore.setCatalog(computersCatalog);

                getComputerType(computersCatalog, child);
            }
        }
    }

    /**
     * Loads all "computer"
     * @param computersCatalog Catalog which contains computer
     * @param parent Node which is parent for "computer"
     */
    protected void getComputerType(ComputersCatalog computersCatalog, Node parent) {
        for (Node child = parent.getFirstChild(); child != null; child = child.getNextSibling()) {
            if (child.getNodeType() == child.ELEMENT_NODE) {
                Element element = (Element)child;

                int id = Integer.parseInt(element.getAttribute("id"));
                ComputerType computerType = new ComputerType(id);

                Element title = (Element)element.getElementsByTagName("title").item(0);
                if (title != null) {
                    computerType.setTitle(title.getTextContent());
                }

                Element type = (Element)element.getElementsByTagName("type").item(0);
                if (type != null) {
                    computerType.setType(type.getTextContent());
                }

                Element amount = (Element)element.getElementsByTagName("amount").item(0);
                if (amount != null) {
                    computerType.setAmount(Integer.parseInt(amount.getTextContent()));
                }

                computersCatalog.setComputerType(computerType);
            }
        }
    }
}
