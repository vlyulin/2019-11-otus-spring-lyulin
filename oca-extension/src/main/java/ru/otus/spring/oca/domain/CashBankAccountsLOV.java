package ru.otus.spring.oca.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CashBankAccountsLOV {
    @JsonProperty("BankAccountId")
    Long BankAccountId;
    @JsonProperty("BankAccountName")
    String BankAccountName;
    @JsonProperty("MaskedAccountNumber")
    String MaskedAccountNumber;

    public Long getBankAccountId() {
        return BankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        BankAccountId = bankAccountId;
    }

    public String getBankAccountName() {
        return BankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        BankAccountName = bankAccountName;
    }

    public String getMaskedAccountNumber() {
        return MaskedAccountNumber;
    }

    public void setMaskedAccountNumber(String maskedAccountNumber) {
        MaskedAccountNumber = maskedAccountNumber;
    }
}
