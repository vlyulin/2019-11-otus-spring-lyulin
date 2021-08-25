package ru.otus.spring.oca.helpers.batch;

import org.springframework.batch.item.ItemProcessor;
import java.util.LinkedHashMap;
import java.util.Map;

public class JavaDomenProcessor implements ItemProcessor<LinkedHashMap, String> {

    Map<String, String> typesMap = Map.of(
            "string","String",
            "date", "Date",
            "number", "Float",
            "datetime", "Date",
            "integer", "Long");

    @Override
    public String process(LinkedHashMap item) throws Exception {
        StringBuilder resultStr = new StringBuilder();
        resultStr.append(
                "@JsonProperty(\"" + item.get("name") + "\")\n"
                + typesMap.get(item.get("type"))
                + "\t" + item.get("name") + "; //"
                + item.get("title"));
        return resultStr.toString();
    }
}
