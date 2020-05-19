package ru.otus.spring.oca.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandardReceipt {
    @JsonProperty("StandardReceiptId")
    Long	StandardReceiptId; //Standard Receipt ID
    @JsonProperty("ReceiptNumber")
    String	ReceiptNumber; //Receipt Number
    @JsonProperty("BusinessUnit")
    String	BusinessUnit; //Business Unit
    @JsonProperty("ReceiptMethod")
    String	ReceiptMethod; //Receipt Method
    @JsonProperty("ReceiptDate")
    Date ReceiptDate; //Receipt Date
    @JsonProperty("DocumentNumber")
    Long	DocumentNumber; //Document Number
    @JsonProperty("Amount")
    Float	Amount; //Receipt Amount
    @JsonProperty("Currency")
    String	Currency; //Currency
    @JsonProperty("ConversionRateType")
    String	ConversionRateType; //Conversion Rate Type
    @JsonProperty("ConversionDate")
    Date	ConversionDate; //Conversion Date
    @JsonProperty("ConversionRate")
    Float	ConversionRate; //Conversion Rate
    @JsonProperty("State")
    String	State; //State
    @JsonProperty("Status")
    String	Status; //Status
    @JsonProperty("RemittanceBankName")
    String	RemittanceBankName; //Remittance Bank Name
    @JsonProperty("RemittanceBankBranch")
    String	RemittanceBankBranch; //Remittance Bank Branch
    @JsonProperty("RemittanceBankAccountNumber")
    String	RemittanceBankAccountNumber; //Remittance Bank Account Number
    @JsonProperty("RemittanceBankDepositDate")
    Date	RemittanceBankDepositDate; //Remittance Bank Deposit Date
    @JsonProperty("RemittanceBankAllowOverride")
    String	RemittanceBankAllowOverride; //Remittance Bank Allow Override
    @JsonProperty("CustomerName")
    String	CustomerName; //Customer Name
    @JsonProperty("TaxpayerIdentificationNumber")
    String	TaxpayerIdentificationNumber; //Taxpayer Identification Number
    @JsonProperty("CustomerSite")
    String	CustomerSite; //Customer Site
    @JsonProperty("CustomerAccountNumber")
    String	CustomerAccountNumber; //Customer Account Number
    @JsonProperty("CustomerBank")
    String	CustomerBank; //Customer Bank
    @JsonProperty("CustomerBankBranch")
    String	CustomerBankBranch; //Customer Bank Branch
    @JsonProperty("CustomerBankAccountNumber")
    String	CustomerBankAccountNumber; //Customer Bank Account Number
    @JsonProperty("UnappliedAmount")
    Float	UnappliedAmount; //Unapplied Amount
    @JsonProperty("AccountedAmount")
    Float	AccountedAmount; //Accounted Amount
    @JsonProperty("AccountingDate")
    Date	AccountingDate; //Accounting Date
    @JsonProperty("MaturityDate")
    Date	MaturityDate; //Maturity Date
    @JsonProperty("PostmarkDate")
    Date	PostmarkDate; //Postmark Date
    @JsonProperty("ReceiptAtRisk")
    String	ReceiptAtRisk; //Receipt at Risk
    @JsonProperty("ReceivablesSpecialist")
    String	ReceivablesSpecialist; //Receivables Specialist
    @JsonProperty("Comments")
    String	Comments; //Comments
    @JsonProperty("CreditCardTokenNumber")
    String	CreditCardTokenNumber; //Credit Card Token Number
    @JsonProperty("CreditCardAuthorizationRequestIdentifier")
    Long	CreditCardAuthorizationRequestIdentifier; //Credit Card Authorization Request Identifier
    @JsonProperty("CardHolderFirstName")
    String	CardHolderFirstName; //First Name of the Credit Card Holder
    @JsonProperty("CardHolderLastName")
    String	CardHolderLastName; //Last Name of the Credit Card Holder
    @JsonProperty("CreditCardIssuerCode")
    String	CreditCardIssuerCode; //Credit Card Issuer Code
    @JsonProperty("CreditCardExpirationDate")
    String	CreditCardExpirationDate; //Credit Card Expiration Date
    @JsonProperty("VoiceAuthorizationCode")
    String	VoiceAuthorizationCode; //Credit Card Voice Authorization Code
    @JsonProperty("CreatedBy")
    String	CreatedBy; //Created By
    @JsonProperty("CreationDate")
    Date	CreationDate; //Creation Date
    @JsonProperty("LastUpdateDate")
    Date	LastUpdateDate; //Last Update Date
    @JsonProperty("LastUpdatedBy")
    String	LastUpdatedBy; //Last Updated By
    // @JsonUnwrapped

    public Long getStandardReceiptId() {
        return StandardReceiptId;
    }

    public void setStandardReceiptId(Long standardReceiptId) {
        StandardReceiptId = standardReceiptId;
    }

    public String getReceiptNumber() {
        return ReceiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        ReceiptNumber = receiptNumber;
    }

    public String getBusinessUnit() {
        return BusinessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        BusinessUnit = businessUnit;
    }

    public String getReceiptMethod() {
        return ReceiptMethod;
    }

    public void setReceiptMethod(String receiptMethod) {
        ReceiptMethod = receiptMethod;
    }

    public Date getReceiptDate() {
        return ReceiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        ReceiptDate = receiptDate;
    }

    public Long getDocumentNumber() {
        return DocumentNumber;
    }

    public void setDocumentNumber(Long documentNumber) {
        DocumentNumber = documentNumber;
    }

    public Float getAmount() {
        return Amount;
    }

    public void setAmount(Float amount) {
        Amount = amount;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getConversionRateType() {
        return ConversionRateType;
    }

    public void setConversionRateType(String conversionRateType) {
        ConversionRateType = conversionRateType;
    }

    public Date getConversionDate() {
        return ConversionDate;
    }

    public void setConversionDate(Date conversionDate) {
        ConversionDate = conversionDate;
    }

    public Float getConversionRate() {
        return ConversionRate;
    }

    public void setConversionRate(Float conversionRate) {
        ConversionRate = conversionRate;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getRemittanceBankName() {
        return RemittanceBankName;
    }

    public void setRemittanceBankName(String remittanceBankName) {
        RemittanceBankName = remittanceBankName;
    }

    public String getRemittanceBankBranch() {
        return RemittanceBankBranch;
    }

    public void setRemittanceBankBranch(String remittanceBankBranch) {
        RemittanceBankBranch = remittanceBankBranch;
    }

    public String getRemittanceBankAccountNumber() {
        return RemittanceBankAccountNumber;
    }

    public void setRemittanceBankAccountNumber(String remittanceBankAccountNumber) {
        RemittanceBankAccountNumber = remittanceBankAccountNumber;
    }

    public Date getRemittanceBankDepositDate() {
        return RemittanceBankDepositDate;
    }

    public void setRemittanceBankDepositDate(Date remittanceBankDepositDate) {
        RemittanceBankDepositDate = remittanceBankDepositDate;
    }

    public String getRemittanceBankAllowOverride() {
        return RemittanceBankAllowOverride;
    }

    public void setRemittanceBankAllowOverride(String remittanceBankAllowOverride) {
        RemittanceBankAllowOverride = remittanceBankAllowOverride;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getTaxpayerIdentificationNumber() {
        return TaxpayerIdentificationNumber;
    }

    public void setTaxpayerIdentificationNumber(String taxpayerIdentificationNumber) {
        TaxpayerIdentificationNumber = taxpayerIdentificationNumber;
    }

    public String getCustomerSite() {
        return CustomerSite;
    }

    public void setCustomerSite(String customerSite) {
        CustomerSite = customerSite;
    }

    public String getCustomerAccountNumber() {
        return CustomerAccountNumber;
    }

    public void setCustomerAccountNumber(String customerAccountNumber) {
        CustomerAccountNumber = customerAccountNumber;
    }

    public String getCustomerBank() {
        return CustomerBank;
    }

    public void setCustomerBank(String customerBank) {
        CustomerBank = customerBank;
    }

    public String getCustomerBankBranch() {
        return CustomerBankBranch;
    }

    public void setCustomerBankBranch(String customerBankBranch) {
        CustomerBankBranch = customerBankBranch;
    }

    public String getCustomerBankAccountNumber() {
        return CustomerBankAccountNumber;
    }

    public void setCustomerBankAccountNumber(String customerBankAccountNumber) {
        CustomerBankAccountNumber = customerBankAccountNumber;
    }

    public Float getUnappliedAmount() {
        return UnappliedAmount;
    }

    public void setUnappliedAmount(Float unappliedAmount) {
        UnappliedAmount = unappliedAmount;
    }

    public Float getAccountedAmount() {
        return AccountedAmount;
    }

    public void setAccountedAmount(Float accountedAmount) {
        AccountedAmount = accountedAmount;
    }

    public Date getAccountingDate() {
        return AccountingDate;
    }

    public void setAccountingDate(Date accountingDate) {
        AccountingDate = accountingDate;
    }

    public Date getMaturityDate() {
        return MaturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        MaturityDate = maturityDate;
    }

    public Date getPostmarkDate() {
        return PostmarkDate;
    }

    public void setPostmarkDate(Date postmarkDate) {
        PostmarkDate = postmarkDate;
    }

    public String getReceiptAtRisk() {
        return ReceiptAtRisk;
    }

    public void setReceiptAtRisk(String receiptAtRisk) {
        ReceiptAtRisk = receiptAtRisk;
    }

    public String getReceivablesSpecialist() {
        return ReceivablesSpecialist;
    }

    public void setReceivablesSpecialist(String receivablesSpecialist) {
        ReceivablesSpecialist = receivablesSpecialist;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public String getCreditCardTokenNumber() {
        return CreditCardTokenNumber;
    }

    public void setCreditCardTokenNumber(String creditCardTokenNumber) {
        CreditCardTokenNumber = creditCardTokenNumber;
    }

    public Long getCreditCardAuthorizationRequestIdentifier() {
        return CreditCardAuthorizationRequestIdentifier;
    }

    public void setCreditCardAuthorizationRequestIdentifier(Long creditCardAuthorizationRequestIdentifier) {
        CreditCardAuthorizationRequestIdentifier = creditCardAuthorizationRequestIdentifier;
    }

    public String getCardHolderFirstName() {
        return CardHolderFirstName;
    }

    public void setCardHolderFirstName(String cardHolderFirstName) {
        CardHolderFirstName = cardHolderFirstName;
    }

    public String getCardHolderLastName() {
        return CardHolderLastName;
    }

    public void setCardHolderLastName(String cardHolderLastName) {
        CardHolderLastName = cardHolderLastName;
    }

    public String getCreditCardIssuerCode() {
        return CreditCardIssuerCode;
    }

    public void setCreditCardIssuerCode(String creditCardIssuerCode) {
        CreditCardIssuerCode = creditCardIssuerCode;
    }

    public String getCreditCardExpirationDate() {
        return CreditCardExpirationDate;
    }

    public void setCreditCardExpirationDate(String creditCardExpirationDate) {
        CreditCardExpirationDate = creditCardExpirationDate;
    }

    public String getVoiceAuthorizationCode() {
        return VoiceAuthorizationCode;
    }

    public void setVoiceAuthorizationCode(String voiceAuthorizationCode) {
        VoiceAuthorizationCode = voiceAuthorizationCode;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return LastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        LastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdatedBy() {
        return LastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        LastUpdatedBy = lastUpdatedBy;
    }
}
