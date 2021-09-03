package br.gov.caixa.sidpn.api.swagger.enums;
/**
 * Tipo de encargo pactuado no contrato.
 */

public enum EnumChargeType {
    JUROS_REMUNERATORIOS_POR_ATRASO,
    MULTA_ATRASO_PAGAMENTO,
    JUROS_MORA_ATRASO,
    IOF_CONTRATACAO,
    IOF_POR_ATRASO,
    SEM_ENCARGO,
    OUTROS;

    public boolean isOthers() {
        return this == OUTROS;
    }
}