
package br.gov.caixa.sidpn.api.swagger.contracts.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * \"Tipo da modalidade de crédito contratada, conforme circular 4.015 e descrição do DOC3040 do SCR). (Vide Enum) Adiantamento a
 * depositantes, Direitos creditórios descontados Empréstimos, Financiamentos, Financiamentos rurais e Financiamentos imobiliários\"
 */
@Getter
@AllArgsConstructor
public enum ProductType
{

   ADIANTAMENTO_A_DEPOSITANTES("ADIANTAMENTO_A_DEPOSITANTES");

   private String value;

}
