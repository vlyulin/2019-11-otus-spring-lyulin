package ru.otus.spring.oca.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CashBanksLOV {
    @JsonProperty("BankName")
    String	BankName;
    @JsonProperty("BankNumber")
    String	BankNumber; //Bank Code
    @JsonProperty("BankPartyId")
    Long	BankPartyId;

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public String getBankNumber() {
        return BankNumber;
    }

    public void setBankNumber(String bankNumber) {
        BankNumber = bankNumber;
    }

    public Long getBankPartyId() {
        return BankPartyId;
    }

    public void setBankPartyId(Long bankPartyId) {
        BankPartyId = bankPartyId;
    }
}
