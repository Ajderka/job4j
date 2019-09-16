package storesql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import logger.UsageLog4j2;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 05.09.2019.
 */
public class ConvertXSQT {
    private static final Logger LOG = LogManager.getLogger(UsageLog4j2.class.getName());

    /**
     * Method converts a XML documents to a different XML file format via XSTL.
     *
     * @param source reads a file.
     * @param dest   converts in file.
     * @param scheme transformation template.
     */
    public void convert(File source, File dest, File scheme) {
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

        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer(new StreamSource(
                    new FileInputStream(xsl))
            );
            transformer.transform(new StreamSource(
                            new FileInputStream(source)),
                    new StreamResult(new FileOutputStream(dest))
            );
        } catch (FileNotFoundException | TransformerException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
