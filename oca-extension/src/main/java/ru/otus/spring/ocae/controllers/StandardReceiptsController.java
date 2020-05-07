package ru.otus.spring.ocae.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.ocae.model.StandardReceipt;

import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
public class StandardReceiptsController {

    StandardReceiptClient standardReceiptClient;

    public StandardReceiptsController(
            @Autowired StandardReceiptClient standardReceiptClient
    ) {
        this.standardReceiptClient = standardReceiptClient;
    }

    @GetMapping(value = "/standardreceipts")
    public @ResponseBody
    Stream<StandardReceipt> all (
//    public @ResponseBody Stream<StandardReceipt> all (
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = true, defaultValue = "1", value = "limit") int limit
    ) {
        // EntityModel<Map<String,StandardReceipt>> coll =
        EntityModel<Map<String, StandardReceipt>> coll =
                 standardReceiptClient.all(offset, limit);
        // System.out.println(coll);
        // coll.getContent().forEach(System.out::println);
        return StreamSupport.stream(coll.getContent().values().spliterator(),false);
        // coll.getContent().iterator()
        // return coll.getContent().stream().map(EntityModel::getContent);
        // Object list = coll.getContent().get("items");
        // return (ArrayList)list;
        // return null;
    }
}
