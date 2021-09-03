package br.gov.caixa.sidpn.resource;

public class RegexConstants {
	private RegexConstants() {
	}
	public static final String REGEX_ONLY_STRINGS_NUMBERS = "^[a-zA-Z0-9][a-zA-Z0-9\\-]{0,99}$";
	public static final String REGEX_ONLY_STRINGS = "[\\w\\W\\s]*";
	public static final String REGEX_X_FAPI_AUTH_DATE = "^(Mon|Tue|Wed|Thu|Fri|Sat|Sun), \\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4} \\d{2}:\\d{2}:\\d{2} (GMT|UTC)$";
	public static final String REGEX_DATE_TIME = "^(\\d{4})-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])T(?:[01]\\d|2[0123]):(?:[012345]\\d):(?:[012345]\\d)Z$";
	public static final String REGEX_DATE = "(\\d{4}-\\d{2}-\\d{2})";

	// ACCOUNT IDENTIFICATION
	public static final String REGEX_COMPE_CODE = "\\d{3}|^NA$";
	public static final String REGEX_BRANCH_CODE = "\\d{4}|^NA$";
	public static final String REGEX_NUMBER = "^\\d{8,20}$|^NA$";
	public static final String REGEX_CURRENCY = "^(\\w{3}){1}$";

	// ACCOUNTS
	public static final String REGEX_COMPANY_CNPJ = "\\d{14}|^NA$";

	// ACCOUNT BALANCE
	public static final String REGEX_AMOUNT = "^-?\\d{1,15}\\.\\d{2,4}$";

	// ACCOUNT TRANSACTIONS
	public static final String REGEX_TRANSACTION_DATE = "^(\\d{4})-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])$";
	public static final String REGEX_CPF_CNPJ = "^\\d{11}$|^\\d{14}$|^NA$";
}
