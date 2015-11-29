import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * Created by Maciek on 2015-11-29.
 */
public class RSSReader {

    public static Feed feed = new Feed();
    private static RSSReader instance = null;

    private URL url;

    private RSSReader() {
    }

    public static RSSReader getInstance() {
        if (instance == null)
            instance = new RSSReader();
        return instance;
    }

    public void setUrl(URL link) {
        url = link;
    }

    public Feed writeFeed() {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            NodeList obiekt = doc.getElementsByTagName("item");

            for (int i = 0; i < obiekt.getLength(); i++) {
                Element element = (Element) obiekt.item(i);
                feed.setTitle(getValue(element, "title"));
                feed.setDescription(getValue(element, "description"));
                feed.setPubDate(getValue(element, "pubDate"));
                feed.setLink(getValue(element, "link"));
                feed.NewsList.add(feed.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return feed;
    }



    private String getValue(Element parent, String nodeName) {
        return parent.getElementsByTagName(nodeName).item(0).getFirstChild().getNodeValue();
    }
}





