package storeSQL;

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

    /**
     * Method converts a XML documents to a different XML file format via XSTL.
     *
     * @param source reads a file.
     * @param dest   converts in file.
     * @param scheme transformation template.
     */
    public void convert(File source, File dest, File scheme) {
        //Системное свойство, которое определяет, какую реализацию Фабрики создать.
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer(new StreamSource(
                            new FileInputStream(scheme))
            );
            transformer.transform(new StreamSource(
                            new FileInputStream(source)),
                    new StreamResult(new FileOutputStream(dest))
            );
        } catch (FileNotFoundException | TransformerException e) {
            System.out.println(e);
        }
    }
}
