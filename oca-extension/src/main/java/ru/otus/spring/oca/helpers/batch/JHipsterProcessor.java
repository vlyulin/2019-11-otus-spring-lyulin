package ru.otus.spring.oca.helpers.batch;

import org.springframework.batch.item.ItemProcessor;

import java.util.LinkedHashMap;
import java.util.Map;

public class JHipsterProcessor implements ItemProcessor<LinkedHashMap, String> {

    Map<String, String> typesMap = Map.of(
            "string","String",
            "date", "LocalDate",
            "number", "Float",
            "datetime", "Date",
            "integer", "Long");

    @Override
    public String process(LinkedHashMap item) throws Exception {
        StringBuilder resultStr = new StringBuilder();
        resultStr.append("\t" + item.get("name") + "\t" + typesMap.get(item.get("type")) + ",");
        return resultStr.toString();
    }
}
