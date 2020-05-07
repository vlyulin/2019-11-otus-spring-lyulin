package ru.otus.spring.ocae.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
// @JsonDeserialize(using = StandardReceiptDeserializer.class)
// https://stackoverflow.com/questions/25858698/spring-hateoas-embedded-resource-support
// @Relation(collectionRelation = "items")
// @JsonIgnoreProperties(ignoreUnknown = true)
public class StandardReceipt {
    long	StandardReceiptId; //Standard Receipt ID
    String	ReceiptNumber; //Receipt Number
    String	BusinessUnit; //Business Unit
    String	ReceiptMethod; //Receipt Method
    Date	ReceiptDate; //Receipt Date
    long	DocumentNumber; //Document Number
    long	Amount; //Receipt Amount java.math.BigDecimal
    String	Currency; //Currency
    String	ConversionRateType; //Conversion Rate Type
    Date	ConversionDate; //Conversion Date
    long	ConversionRate; //Conversion Rate java.math.BigDecimal
    String	State; //State
    String	Status; //Status
    String	RemittanceBankName; //Remittance Bank Name
    String	RemittanceBankBranch; //Remittance Bank Branch
    String	RemittanceBankAccountNumber; //Remittance Bank Account Number
    Date	RemittanceBankDepositDate; //Remittance Bank Deposit Date
    String	RemittanceBankAllowOverride; //Remittance Bank Allow Override
    String	CustomerName; //Customer Name
    String	TaxpayerIdentificationNumber; //Taxpayer Identification Number
    String	CustomerSite; //Customer Site
    String	CustomerAccountNumber; //Customer Account Number
    String	CustomerBank; //Customer Bank
    String	CustomerBankBranch; //Customer Bank Branch
    String	CustomerBankAccountNumber; //Customer Bank Account Number
    long	UnappliedAmount; //Unapplied Amount java.math.BigDecimal
    long	AccountedAmount; //Accounted Amount java.math.BigDecimal
    Date	AccountingDate; //Accounting Date
    Date	MaturityDate; //Maturity Date
    Date	PostmarkDate; //Postmark Date
    String	ReceiptAtRisk; //Receipt at Risk
    String	ReceivablesSpecialist; //Receivables Specialist
    String	Comments; //Comments
    String	CreditCardTokenNumber; //Credit Card Token Number
    long	CreditCardAuthorizationRequestIdentifier; //Credit Card Authorization Request Identifier
    String	CardHolderFirstName; //First Name of the Credit Card Holder
    String	CardHolderLastName; //Last Name of the Credit Card Holder
    String	CreditCardIssuerCode; //Credit Card Issuer Code
    String	CreditCardExpirationDate; //Credit Card Expiration Date
    String	VoiceAuthorizationCode; //Credit Card Voice Authorization Code
    String	CreatedBy; //Created By
    Date	CreationDate; //Creation Date
    Date    LastUpdateDate; //Last Update Date
    String	LastUpdatedBy; //Last Updated By
    // @JsonUnwrapped
}
