package br.gov.caixa.sidpn.api.swagger.contracts.scheduledinstalments;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.gov.caixa.sidpn.api.util.ValueDeserializeScale4;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InstalmentsDataBalloonPayments {
  @Schema(example = "2021-05-21T08:30Z", required = true, description = "Data de vencimento da parcela não regular  a vencer do contrato da modalidade de crédito consultada, conforme especificação RFC-3339. p.ex. 2014-03-19")
  @JsonProperty("dueDate")
  @NotNull
  @Pattern(regexp = "^(\\d{4})-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])$")
  @Size(max=10)
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private String dueDate = "0000-01-01";

  @Schema(example = "BRL", required = true, description = "Moeda referente ao valor monetário informado, segundo modelo ISO-4217. p.ex. 'BRL' Todos os valores monetários informados estão representados com a moeda vigente do Brasil.")
  @JsonProperty("currency")
  @NotNull
  @Pattern(regexp="^(\\w{3}){1}$")
  @Size(max=3)
  @Default
  private String currency = "BRL";

  @Schema(example = "100000.04", required = true, description = "Valor monetário da parcela não regular a vencer.  Expresso em valor monetário com até 4 casas decimais")
  @JsonProperty("amount")
  @Pattern(regexp="^-?\\d{1,15}\\.\\d{2,4}$")
  @Size(max=20)
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonDeserialize(using = ValueDeserializeScale4.class)
  private BigDecimal amount;
}