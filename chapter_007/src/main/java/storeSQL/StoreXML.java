package storeSQL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 03.09.2019.
 */
public class StoreXML {

    /**
     * File to save.
     */
    private File target;

    public StoreXML(File target) {
        this.target = target;
    }

    /**
     * The method saves the list of database elements to XML.
     *
     * @param list of items convert.
     */
    public void save(List<Entry> list) throws JAXBException {
        Entries entries = new Entries();
        entries.setEntries(list);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(entries, target);
        } catch (JAXBException e) {
            System.out.println(e);
        }
    }
}
