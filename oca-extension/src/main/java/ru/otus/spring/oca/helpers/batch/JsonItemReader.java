package ru.otus.spring.oca.helpers.batch;

import com.jayway.jsonpath.JsonPath;
import io.micrometer.core.instrument.util.IOUtils;
import lombok.Data;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

@Data
public class JsonItemReader implements ItemReader<LinkedHashMap> {

    private File sourceJsonFile;
    List<Object> attributes;
    Iterator<Object> attrIterator;

    public JsonItemReader(String fileName, String jsonPath) {
        try {
            sourceJsonFile = new ClassPathResource(fileName).getFile();
            if( sourceJsonFile != null && sourceJsonFile.exists() ) {
                InputStream is = new FileInputStream(sourceJsonFile);
                String jsonTxt = IOUtils.toString(is);
                attributes = JsonPath.parse(jsonTxt).read(jsonPath);
                attrIterator = attributes.iterator();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedHashMap read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(attrIterator.hasNext()) {
            Object jobj = attrIterator.next();
            if( jobj instanceof LinkedHashMap) {
                return (LinkedHashMap)jobj;
            }
        }
        return null;
    }
}
