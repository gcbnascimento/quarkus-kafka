package br.gov.caixa.sidpn.api.swagger.enums;

public enum EnumContractReferentialRateIndexerType {
	SEM_TIPO_INDEXADOR,
	PRE_FIXADO,
	POS_FIXADO,
	FLUTUANTES,
	INDICES_PRECOS,
	CREDITO_RURAL,
	OUTROS_INDEXADORES;

	public boolean isOthersIndexers() {
		return this == OUTROS_INDEXADORES;
	}
}
