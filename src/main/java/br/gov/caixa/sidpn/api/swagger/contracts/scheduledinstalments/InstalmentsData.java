package br.gov.caixa.sidpn.api.swagger.contracts.scheduledinstalments;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

import br.gov.caixa.sidpn.api.swagger.enums.EnumContractRemainingType;
import br.gov.caixa.sidpn.api.swagger.enums.EnumTypeNumberOfInstalments;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@Schema(description="Conjunto de informações referentes ao prazo remanescente e às parcelas de uma operação de crédito de adiantamento a depositante")
public class InstalmentsData {
  @Schema(required = true, description = "Tipo de prazo total do contrato referente à modalidade de crédito informada.")
  @JsonProperty("typeNumberOfInstalments")
  @NotNull
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private EnumTypeNumberOfInstalments typeNumberOfInstalments = EnumTypeNumberOfInstalments.ANO;

  @Schema(example = "130632", required = true, description = "Prazo Total segundo o tipo (dia, semana, mês, ano) referente à Modalidade de Crédito informada.")
  @JsonProperty("totalNumberOfInstalments")
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private BigDecimal totalNumberOfInstalments;

  @Schema(required = true, description = "Tipo de prazo remanescente do contrato referente à modalidade de crédito informada.")
  @JsonProperty("typeContractRemaining")
  @NotNull
  @Default
  private EnumContractRemainingType typeContractRemaining = EnumContractRemainingType.ANO;

  @Schema(example = "14600", required = true, description = "Prazo Remanescente em dias do contrato referente à Modalidade de Crédito informada")
  @JsonProperty("contractRemainingNumber")
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private BigDecimal contractRemainingNumber;
  
  @Schema(example = "73", required = true, description = "Quantidade de prestações pagas. (No caso de modalidades que não possuam parcelas, o número de prestações é igual a zero)")
  @JsonProperty("paidInstalments")
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private BigDecimal paidInstalments;

  @Schema(example = "57", required = true, description = "Quantidade de prestações a vencer. (No caso de modalidades que não possuam parcelas, o número de prestações é igual a zero)")
  @JsonProperty("dueInstalments")
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private BigDecimal dueInstalments;

  @Schema(example = "73", required = true, description = "Quantidade de prestações vencidas. (No caso de modalidades que não possuam parcelas, o número de prestações é igual a zero)")
  @JsonProperty("pastDueInstalments")
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private BigDecimal pastDueInstalments;

  @Schema(required = true, description = "Lista que traz as datas de vencimento e valor das parcelas não regulares  do contrato da modalidade de crédito consultada")
  @JsonProperty("balloonPayments")
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @Size(min=1)
  @Default
  private List<InstalmentsDataBalloonPayments> balloonPayments
    = List.of(InstalmentsDataBalloonPayments.builder().build());
}