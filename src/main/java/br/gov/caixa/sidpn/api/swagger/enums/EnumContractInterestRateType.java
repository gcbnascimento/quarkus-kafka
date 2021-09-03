package br.gov.caixa.sidpn.api.swagger.enums;

/**
 * \"Tipo de Juros (vide Enum) - SIMPLES (aplicada/cobrada sempre sobre o capital inicial, que é o valor emprestado/investido. Não há
 * cobrança de juros sobre juros acumulados no(s) período(s) anterior(es). Exemplo: em um empréstimo de R$1.000, com taxa de juros
 * simples de 8% a.a., com duração de 2 anos, o total de juros será R$80 no primeiro ano e R$ 80 no segundo ano. Ao final do contrato, o
 * tomador irá devolver o principal e os juros simples de cada ano: R$1.000+R$80+R$80=R$1.160) - COMPOSTO (para cada período do contrato
 * (diário, mensal, anual etc.), há um “novo capital” para a cobrança da taxa de juros contratada. Esse “novo capital” é a soma do
 * capital e do juro cobrado no período anterior. Exemplo: em um empréstimo de R$1.000, com taxa de juros composta de 8% a.a., com
 * duração de 2 anos, o total de juros será R$80 no primeiro ano. No segundo ano, os juros vão ser somados ao capital (R$1.000 + R$ 80 =
 * R$ 1.080), resultando em juros de R$ 86 (8%de R$ 1.080))\"
 */

public enum EnumContractInterestRateType {
	SIMPLES,
	COMPOSTO;
}
