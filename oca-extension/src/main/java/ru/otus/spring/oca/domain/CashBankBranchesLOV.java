package ru.otus.spring.oca.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CashBankBranchesLOV {
    @JsonProperty("BranchPartyId")
    Long	BranchPartyId;
    @JsonProperty("BankBranchName")
    String	BankBranchName;
    @JsonProperty("BranchNumber")
    String	BranchNumber; //Branch Number
    @JsonProperty("BankName")
    String	BankName;

    public Long getBranchPartyId() {
        return BranchPartyId;
    }

    public void setBranchPartyId(Long branchPartyId) {
        BranchPartyId = branchPartyId;
    }

    public String getBankBranchName() {
        return BankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        BankBranchName = bankBranchName;
    }

    public String getBranchNumber() {
        return BranchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        BranchNumber = branchNumber;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }
}
