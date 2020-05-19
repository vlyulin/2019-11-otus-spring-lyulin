package ru.otus.spring.oca.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerAccountSitesLOV {
    @JsonProperty("CustomerName")
    String	CustomerName; //Customer Name
    @JsonProperty("AccountNumber")
    String	AccountNumber; //Account Number
    @JsonProperty("AccountDescription")
    String	AccountDescription; //Account Description
    @JsonProperty("TaxpayerIdentificationNumber")
    String	TaxpayerIdentificationNumber; //Taxpayer Identification Number
    @JsonProperty("TaxRegistrationNumber")
    String	TaxRegistrationNumber; //Tax Registration Number
    @JsonProperty("CustomerAccountId")
    Long	CustomerAccountId; //Customer Account ID
    @JsonProperty("PartyNumber")
    String	PartyNumber; //Party Number
    @JsonProperty("SiteName")
    String	SiteName; //Site Name
    @JsonProperty("PrimarySite")
    String	PrimarySite; //Primary Site
    @JsonProperty("SiteUseId")
    Long	SiteUseId; //Site Use ID
    @JsonProperty("SetName")
    String	SetName; //Set Name

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getAccountDescription() {
        return AccountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        AccountDescription = accountDescription;
    }

    public String getTaxpayerIdentificationNumber() {
        return TaxpayerIdentificationNumber;
    }

    public void setTaxpayerIdentificationNumber(String taxpayerIdentificationNumber) {
        TaxpayerIdentificationNumber = taxpayerIdentificationNumber;
    }

    public String getTaxRegistrationNumber() {
        return TaxRegistrationNumber;
    }

    public void setTaxRegistrationNumber(String taxRegistrationNumber) {
        TaxRegistrationNumber = taxRegistrationNumber;
    }

    public Long getCustomerAccountId() {
        return CustomerAccountId;
    }

    public void setCustomerAccountId(Long customerAccountId) {
        CustomerAccountId = customerAccountId;
    }

    public String getPartyNumber() {
        return PartyNumber;
    }

    public void setPartyNumber(String partyNumber) {
        PartyNumber = partyNumber;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    public String getPrimarySite() {
        return PrimarySite;
    }

    public void setPrimarySite(String primarySite) {
        PrimarySite = primarySite;
    }

    public Long getSiteUseId() {
        return SiteUseId;
    }

    public void setSiteUseId(Long siteUseId) {
        SiteUseId = siteUseId;
    }

    public String getSetName() {
        return SetName;
    }

    public void setSetName(String setName) {
        SetName = setName;
    }
}
