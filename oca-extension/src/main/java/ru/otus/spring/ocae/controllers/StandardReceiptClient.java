package ru.otus.spring.ocae.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.spring.ocae.model.StandardReceipt;

import java.util.Map;

@FeignClient(value = "standardReceipts", url ="https://egxt-dev4.fa.em2.oraclecloud.com")
public interface StandardReceiptClient {

    @GetMapping("/fscmRestApi/resources/11.13.18.05/standardReceipts")
    EntityModel<Map<String,StandardReceipt>> all(
//    EntityModel<Iterable<StandardReceipt>> all(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = true, defaultValue = "1", value = "limit") int limit
    );
}
//    @RequestHeader("Authorization") String authHeader,
//    @RequestHeader(value = "REST-Framework-Version", defaultValue = "7") String restFrameworkVersion,

