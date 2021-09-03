package br.gov.caixa.sidpn.api.swagger.contracts.data;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.gov.caixa.sidpn.api.swagger.enums.EnumContractCalculation;
import br.gov.caixa.sidpn.api.swagger.enums.EnumContractInterestRateType;
import br.gov.caixa.sidpn.api.swagger.enums.EnumContractReferentialRateIndexerSubType;
import br.gov.caixa.sidpn.api.swagger.enums.EnumContractReferentialRateIndexerType;
import br.gov.caixa.sidpn.api.swagger.enums.EnumContractTaxPeriodicity;
import br.gov.caixa.sidpn.api.swagger.enums.EnumContractTaxType;
import br.gov.caixa.sidpn.api.util.ValueDeserializeScale4;
import br.gov.caixa.sidpn.resource.RegexConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Objeto que traz o conjunto de informações necessárias para demonstrar a composição das taxas de juros remuneratórios da Modalidade de
 * crédito
 */
@Schema(description = "Objeto que traz o conjunto de informações necessárias para demonstrar a composição das taxas de juros remuneratórios da Modalidade de crédito")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseContractDataInterestRates
{

   @Schema(example = "EFETIVA", required = true,
            description = "\"Tipo de Taxa (vide  Enum) - NOMINAL (taxa nominal é uma taxa de juros em que a unidade referencial não coincide com a unidade de tempo da capitalização. Ela é sempre fornecida em termos anuais, e seus períodos de capitalização podem ser diários, mensais, trimestrais ou semestrais. p.ex. Uma taxa de 12% ao ano com capitalização mensal) - EFETIVA (É a taxa de juros em que a unidade referencial coincide com a unidade de tempo da capitalização. Como as unidades de medida de tempo da taxa de juros e dos períodos de capitalização são iguais, usa-se exemplos simples como 1% ao mês, 60% ao ano)\" ")
   @NotNull
   @JsonProperty("taxType")
   @JsonSetter(nulls = Nulls.SKIP)
   @Default
   private EnumContractTaxType taxType = EnumContractTaxType.NOMINAL;

   @Schema(example = "SIMPLES", required = true,
            description = "\"Tipo de Juros  (vide  Enum) - SIMPLES (aplicada/cobrada sempre sobre o capital inicial, que é o valor emprestado/investido. Não há cobrança de juros sobre juros acumulados no(s) período(s) anterior(es). Exemplo: em um empréstimo de R$1.000, com taxa de juros simples de 8% a.a., com duração de 2 anos, o total de juros será R$80 no primeiro ano e R$ 80 no segundo ano. Ao final do contrato, o tomador irá devolver o principal e os juros simples de cada ano: R$1.000+R$80+R$80=R$1.160) - COMPOSTO (para cada período do contrato (diário, mensal, anual etc.), há um “novo capital” para a cobrança da taxa de juros contratada. Esse “novo capital” é a soma do capital e do juro cobrado no período anterior. Exemplo: em um empréstimo de R$1.000, com taxa de juros composta de 8% a.a., com duração de 2 anos, o total de juros será R$80 no primeiro ano. No segundo ano, os juros vão ser somados ao capital (R$1.000 + R$ 80 = R$ 1.080), resultando em juros de R$ 86 (8%de R$ 1.080))\" ")
   @NotNull
   @JsonProperty("interestRateType")
   @JsonSetter(nulls = Nulls.SKIP)
   @Default
   private EnumContractInterestRateType interestRateType = EnumContractInterestRateType.COMPOSTO;

   @Schema(example = "AA", required = true, description = "\"Periodicidade da taxa . (Vide  Enum) a.m - ao mês a.a. - ao ano\" ")
   @NotNull
   @JsonProperty("taxPeriodicity")
   @JsonSetter(nulls = Nulls.SKIP)
   @Default
   private EnumContractTaxPeriodicity taxPeriodicity = EnumContractTaxPeriodicity.AM;

   @Schema(example = "21/25", required = true, description = "Base de cálculo")
   @NotNull
   @JsonProperty("calculation")
   @JsonSetter(nulls = Nulls.SKIP)
   @Default
   private EnumContractCalculation calculation = EnumContractCalculation.D_30_POR_360;

   @Schema(example = "PRE_FIXADO", required = true, description = "Tipos de taxas referenciais ou indexadores, conforme Anexo 5: Taxa referencial ou Indexador (Indx), do Documento 3040")
   @NotNull
   @JsonProperty("referentialRateIndexerType")
   @JsonSetter(nulls = Nulls.SKIP)
   @Default
   private EnumContractReferentialRateIndexerType referentialRateIndexerType = EnumContractReferentialRateIndexerType.SEM_TIPO_INDEXADOR;

   @Schema(example = "TJLP", description = "\"Sub tipos de taxas referenciais ou indexadores, conforme Anexo 5: Taxa referencial ou Indexador (Indx), do Documento 3040\" ")
   @JsonProperty("referentialRateIndexerSubType")
   private EnumContractReferentialRateIndexerSubType referentialRateIndexerSubType;

   @Schema(description = "Campo livre de preenchimento obrigatório para complementar a informação relativa ao Tipo de taxa referencial ou indexador, quando selecionada o tipo ou subtipo OUTRO")
   @Pattern(regexp = RegexConstants.REGEX_ONLY_STRINGS)
   @Size(max = 140)
   @JsonProperty("referentialRateIndexerAdditionalInfo")
   private String referentialRateIndexerAdditionalInfo;

   public String getReferentialRateIndexerAdditionalInfo() {
      if ((referentialRateIndexerAdditionalInfo == null || referentialRateIndexerAdditionalInfo.isEmpty())
              && (getReferentialRateIndexerType().isOthersIndexers()
              || (getReferentialRateIndexerSubType() != null && getReferentialRateIndexerSubType().isOthers()))){
         referentialRateIndexerAdditionalInfo = "NA";
      }
      return referentialRateIndexerAdditionalInfo;
   }

   @Schema(example = "0.6", required = true,
            description = "\"Taxa pré fixada aplicada sob o contrato da modalidade crédito. p.ex. 0.0045. O preenchimento deve respeitar as 4 casas decimais, mesmo que venham preenchidas com zeros (representação de porcentagem p.ex: 0.1500. Este valor representa 15%. O valor 1 representa 100%)\" ")
   @JsonProperty("preFixedRate")
   @JsonDeserialize(using = ValueDeserializeScale4.class)
   @JsonSetter(nulls = Nulls.SKIP)
   @Default
   private BigDecimal preFixedRate = new BigDecimal("0.0000");

   @Schema(example = "0.55", required = true,
            description = "\"Taxa pós fixada aplicada sob o contrato da modalidade crédito. p.ex. 0.0045 .O preenchimento deve respeitar as 4 casas decimais, mesmo que venham preenchidas com zeros (representação de porcentagem p.ex: 0.1500. Este valor representa 15%. O valor 1 representa 100%)\" ")
   @JsonProperty("postFixedRate")
   @JsonDeserialize(using = ValueDeserializeScale4.class)
   @JsonSetter(nulls = Nulls.SKIP)
   @Default
   private BigDecimal postFixedRate = new BigDecimal("0.0000");

   @Schema(required = true, description = "Texto com informações adicionais sobre a composição das taxas de juros pactuadas")
   @NotNull
   @Pattern(regexp = RegexConstants.REGEX_ONLY_STRINGS)
   @Size(max = 1200)
   @JsonProperty("additionalInfo")
   @JsonSetter(nulls = Nulls.SKIP)
   @Default
   private String additionalInfo = "NA";
   
}
