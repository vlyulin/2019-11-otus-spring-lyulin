package ru.otus.spring.oca.domain;

import com.fasterxml.jackson.annotation.*;
import ru.otus.spring.oca.service.mapper.JsonViews;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandardReceipt {
    @JsonProperty("StandardReceiptId")
    Long	StandardReceiptId; //Standard Receipt ID
    @JsonProperty("ReceiptNumber")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
    String	ReceiptNumber; //Receipt Number
    @JsonProperty("BusinessUnit")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
    String	BusinessUnit; //Business Unit
    @JsonProperty("ReceiptMethod")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
    String	ReceiptMethod; //Receipt Method
    @JsonProperty("ReceiptDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
    Date ReceiptDate; //Receipt Date
    @JsonProperty("DocumentNumber")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
    Long	DocumentNumber; //Document Number
    @JsonProperty("Amount")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
    Float	Amount; //Receipt Amount
    @JsonProperty("Currency")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
    String	Currency; //Currency
    @JsonProperty("ConversionRateType")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
    String	ConversionRateType; //Conversion Rate Type
    @JsonProperty("ConversionDate")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date	ConversionDate; //Conversion Date
    @JsonProperty("ConversionRate")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
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
    @JsonView(JsonViews.StandardReceiptCreateView.class)
    String	RemittanceBankAccountNumber; //Remittance Bank Account Number
    @JsonProperty("RemittanceBankDepositDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
    Date	RemittanceBankDepositDate; //Remittance Bank Deposit Date
    @JsonProperty("RemittanceBankAllowOverride")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
    String	RemittanceBankAllowOverride; //Remittance Bank Allow Override
    @JsonProperty("CustomerName")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
    String	CustomerName; //Customer Name
    @JsonProperty("TaxpayerIdentificationNumber")
    String	TaxpayerIdentificationNumber; //Taxpayer Identification Number
    @JsonProperty("CustomerSite")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
    String	CustomerSite; //Customer Site
    @JsonProperty("CustomerAccountNumber")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date	AccountingDate; //Accounting Date
    @JsonProperty("MaturityDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date	MaturityDate; //Maturity Date
    @JsonProperty("PostmarkDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date	PostmarkDate; //Postmark Date
    @JsonProperty("ReceiptAtRisk")
    String	ReceiptAtRisk; //Receipt at Risk
    @JsonProperty("ReceivablesSpecialist")
    String	ReceivablesSpecialist; //Receivables Specialist
    @JsonProperty("Comments")
    @JsonView(JsonViews.StandardReceiptCreateView.class)
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date	CreationDate; //Creation Date
    @JsonProperty("LastUpdateDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date	LastUpdateDate; //Last Update Date
    @JsonProperty("LastUpdatedBy")
    String	LastUpdatedBy; //Last Updated By

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

    public void setState(String State) {
        this.State = State;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
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
