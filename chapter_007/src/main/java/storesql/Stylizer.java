package storesql;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 05.09.2019.
 */
public class Stylizer {

    public static void main(String[] args) throws TransformerException {
        String xsl = "<?xml version=\"1.0\"?>\n"
                + "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n"
                + "<xsl:template match=\"/\">\n"
                + "<entries>"
                + "   <xsl:for-each select=\"user/values\">\n"
                + "       <entry>"
                + "           <xsl:attribute name=\"href\">"
                + "               <xsl:value-of select=\"value\"/>"
                + "           </xsl:attribute>"
                + "       </entry>\n"
                + "   </xsl:for-each>\n"
                + " </entries>\n"
                + "</xsl:template>\n"
                + "</xsl:stylesheet>\n";

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<user>\n"
                + "   <values>\n"
                + "       <value>1</value>\n"
                + "   </values>\n"
                + "   <values>\n"
                + "       <value>2</value>\n"
                + "   </values>\n"
                + "</user>";

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource(
                        new ByteArrayInputStream(xsl.getBytes())
                )
        );
        transformer.transform(new StreamSource(
                new ByteArrayInputStream(xml.getBytes())),
                new StreamResult(System.out)
        );
    }
}
