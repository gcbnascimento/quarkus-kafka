/*
* Fóton Informática S.A.
* Criação : 4 de mai de 2021
*/
package br.gov.caixa.sidpn.api.util;

import static java.text.MessageFormat.format;

/**
* Interface utilitaria para centralizar Strings em geral.
* 
* @author  maio/2021: fabio.sobral
*/
public class Strings
{

   public static final String  CONTRACT_IDENTIFICATION_ALIAS = "contractIdentification";
   public static final String CONTRACT_SCHEDULED_INSTALMENTS_ALIAS = "contractScheduledInstalments";
   public static final String CONTRACT_WARRANTIES_ALIAS = "contractWarranties";
   public static final String CONTRACT_WARRANTIES_HELPER_ALIAS = "contractWarrantiesHelper";
   public static final String CONTRACT_PAYMENTS_ALIAS = "contractPayments";
   public static final String TOTAL_RECORDS_ALIAS = "totalRecords";
   public static final String CONTRACT_ID_PARAM = "@contractId";
   public static final String PID_PARAM = "@pid";
   public static final String CUSTOMER_ID_PARAM = "@customerId";
   public static final String CUSTOMER_TYPE_PARAM = "@customerIDType";
   public static final String PRODUCT_TYPE_PARAM = "@productType";
   public static final String SUBTYPES_PARAM = "@subTypeList";
   public static final String ARRAY_INDEX_PARAM = "@index";
   public static final String PAGE_SIZE_PARAM = "@pageSize";
   public static final String CURRENT_DATE= "@currentDate"; 
   public static final String PASTE_DATE= "@pasteDate"; 
   private static final String MONTHS_FILTERS = format("ARRAY(select value t from t in c.payments.releases WHERE t.paidDate BETWEEN {0} AND {1})", PASTE_DATE, CURRENT_DATE);
	
   private static final String WHERE_CLAUSE = format("JOIN custo IN c.customer WHERE c.contractId = {0} AND c.__pid = {1} AND ARRAY_CONTAINS({2}, c.contractData.productSubType) AND custo.customerId = {3} AND custo.customerIDType = {4}", CONTRACT_ID_PARAM, PID_PARAM, SUBTYPES_PARAM, CUSTOMER_ID_PARAM, CUSTOMER_TYPE_PARAM);
   
   public static final String QUERY_CONTRACT_BY_ID = format("SELECT (SELECT c.contractId,"
	   		+ " c.contractData.ipocCode,"
	   		+ " c.contractData.productName,"
	   		+ " c.contractData.productType,"
	   		+ " c.contractData.productSubType,"
	   		+ " c.contractData.contractDate,"
	   		+ " c.contractData.disbursementDate,"
	   		+ " c.contractData.settlementDate,"
	   		+ " c.contractData.contractAmount,"
	   		+ " c.contractData.currency,"
	   		+ " c.contractData.dueDate,"
	   		+ " c.contractData.instalmentPeriodicity,"
	   		+ " c.contractData.instalmentPeriodicityAdditionalInfo,"
	   		+ " c.contractData.firstInstalmentDueDate,"
	   		+ " c.contractData.CET,"
	   		+ " c.contractData.amortizationScheduled,"
	   		+ " c.contractData.amortizationScheduledAdditionalInfo,"
	   		+ " c.contractData.interestRates,"
	   		+ " c.contractData.contractedFees,"
	   		+ " c.contractData.contractedFinanceCharges,"
	   		+ " c.contractData.cnpjConsignee)"
	   		+ " AS {0} FROM c {1}", CONTRACT_IDENTIFICATION_ALIAS, WHERE_CLAUSE);   
  
  //ALTERAÇÃO: contractRemainingNumber receberá a diferença em dias de dueDate - dataAtual, 
  //paidInstalments será buscado em payments,
  //ContractNumber receberá o ContractId (public static final String QUERY_CONTRACT_BY_ID)
  //acordado em reunião com Thiago Leitão, Ernesto, Diego e P.O
   
   public static final String QUERY_CONTRACT_SCHEDULED_INSTALMENTS_BY_ID = format("SELECT c.contractData AS {0} FROM c {1}", CONTRACT_IDENTIFICATION_ALIAS, WHERE_CLAUSE);

   public static final String QUERY_CONTRACT_WARRANTIES_BY_ID = format("SELECT c.contractData AS {0} FROM c {1}", CONTRACT_IDENTIFICATION_ALIAS, WHERE_CLAUSE);

   public static final String QUERY_CONTRACT_PAYMENTS_BY_ID = format("SELECT ARRAY_LENGTH({6}) AS {4}, "
   		+ " (SELECT c.contractData.productType, c.contractData.productSubType) AS {5},"
   		+ " (SELECT c.payments.paidInstalments, c.payments.contractOutstandingBalance, "
   		+ " ARRAY_SLICE({6}, {0}, {1}) AS releases) AS {2} "
   		+ " FROM c {3}", ARRAY_INDEX_PARAM, PAGE_SIZE_PARAM, CONTRACT_PAYMENTS_ALIAS, WHERE_CLAUSE, TOTAL_RECORDS_ALIAS, CONTRACT_IDENTIFICATION_ALIAS, MONTHS_FILTERS);

   public static final String QUERY_CONTRACT_ID_LIST = format("SELECT c.productType, c.productSubType, c.ipocCode, c.contractId FROM c WHERE c.customerId = {0} AND c.customerIDType = {1} AND c.productType = {2} AND ARRAY_CONTAINS({3}, c.productSubType) ", CUSTOMER_ID_PARAM, CUSTOMER_TYPE_PARAM, PRODUCT_TYPE_PARAM, SUBTYPES_PARAM);

   private  Strings() {
	   throw new IllegalStateException("Utility class");  
   }
}
