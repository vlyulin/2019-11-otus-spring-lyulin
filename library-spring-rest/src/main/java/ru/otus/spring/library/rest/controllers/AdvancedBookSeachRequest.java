package ru.otus.spring.library.rest.controllers;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

// https://stackoverflow.com/questions/45771870/http-status-400-required-string-parameter-walletname-is-not-present
@Data
public class AdvancedBookSeachRequest {
   private String bookName;
   private String genreMeaning;
   private String authorName;
   private String publishingHouseName;
   private int publishingYearFrom;
   private int publishingYearTo;
   private int pagesFrom;
   private int pagesTo;
}
