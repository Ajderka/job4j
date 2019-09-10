package storeSQL;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 04.09.2019.
 */
public class StoreXMLTest {

    @Test
    public void name() throws Exception {
        Config config = new Config();
        config.init();
        StoreSQL storeSQL = new StoreSQL(config);
        storeSQL.initConnection();
        storeSQL.createStructure();
        try {
            storeSQL.generate(100);
        } catch (SQLException e) {
            System.out.println(e);
        }
        List<Entry> entry = storeSQL.load();
        StoreXML storeXML = new StoreXML(new File("storexml.xml"));
        storeXML.save(entry);
        storeSQL.close();

        Entries result = new Entries ();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            result = (Entries) jaxbUnmarshaller.unmarshal(new File("storexml.xml"));
        } catch (JAXBException e) {
            System.out.println(e);
        }
        List<Entry> expected = Stream.iterate(1, n -> n + 1).limit(100).map(Entry::new).collect(Collectors.toList());
        assertThat(result.getEntries(), is(expected));
    }

}