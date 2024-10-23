package com.solvd.laba;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JaxB {

    public static <T> void  marshal (T t, Class<T> clazz) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(t, new File("./" + clazz.getSimpleName() + ".xml"));
        } catch(JAXBException e) {
            e.printStackTrace();
        }

    }

    public static <T> T unmarshal(String fileName, Class<T> clazz) throws JAXBException, IOException{
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);

            return clazz.cast(
                    context.createUnmarshaller().unmarshal(new FileReader(fileName)));

        } catch(JAXBException|IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
