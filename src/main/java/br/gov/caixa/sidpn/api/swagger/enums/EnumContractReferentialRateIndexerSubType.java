package br.gov.caixa.sidpn.api.swagger.enums;

public enum EnumContractReferentialRateIndexerSubType {
	SEM_SUB_TIPO_INDEXADOR,
	PRE_FIXADO,
	TR_TBF,
	TJLP,
	LIBOR,
	TLP,
	OUTRAS_TAXAS_POS_FIXADAS,
	CDI,
	SELIC,
	OUTRAS_TAXAS_FLUTUANTES,
	IGPM,
	IPCA,
	IPCC,
	OUTROS_INDICES_PRECO,
	TCR_PRE,
	TCR_POS,
	TRFC_PRE,
	TRFC_POS,
	OUTROS_INDEXADORES;

	public boolean isOthers() {
		return this == OUTROS_INDEXADORES || this == OUTROS_INDICES_PRECO || this == OUTRAS_TAXAS_POS_FIXADAS ||
				this == OUTRAS_TAXAS_FLUTUANTES;
	}
}
