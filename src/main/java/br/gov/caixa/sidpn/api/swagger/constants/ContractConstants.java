package br.gov.caixa.sidpn.api.swagger.constants;

public abstract class ContractConstants {
	
	private ContractConstants() {}

	public static final String UNARRANGED_ACCOUNT_OVERDRAFT_CONTRACT_PATH_ID = "{contractId}";
	
	public static final String RFC3339_DATE_PATTERN = "^(\\\\d{4})-(\\\\d{2})-(\\\\d{2})([Tt](\\\\d{2}):(\\\\d{2}):(\\\\d{2})(\\\\.\\\\d+)?)?([Zz]|([+-])(\\\\d{2}):(\\\\d{2}))?";
	
	public static final String REQUEST_BODY = "REQUEST_BODY";
}
