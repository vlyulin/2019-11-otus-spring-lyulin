package ru.otus.spring.ocae.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import ru.otus.spring.ocae.model.StandardReceipt;

import java.io.IOException;

public class StandardReceiptDeserializer extends StdDeserializer<StandardReceipt> {

    public StandardReceiptDeserializer() {
        this(null);
    }

    public StandardReceiptDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public StandardReceipt deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        JsonNode node = p.getCodec().readTree(p);
        int id = (Integer) ((IntNode) node.get("StandardReceiptId")).numberValue();

        StandardReceipt sr = new StandardReceipt();
        sr.setStandardReceiptId(id);

        return sr;
    }
}
