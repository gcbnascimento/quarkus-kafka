package br.gov.caixa.sidpn.api.swagger.contracts.payments;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import br.gov.caixa.sidpn.api.util.ValueDeserializeScale;
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
@Schema(description="Lista dos pagamentos realizados no período")
public class PaymentsDataReleases {
  @Schema(example = "Parcela regular", description = "Texto livre de responsabilidade de cada Instituição transmissora para identificar o pagamento informado")
  @JsonProperty("paymentId")
  @Pattern(regexp="\\w\\W\\s]*")
  @Size(max=80)
  private String paymentId;

  @Schema(example = "true", required = true, description = "Identifica se é um pagamento pactuado ou avulso.")
  @JsonProperty("isOverParcelPayment")
  @NotNull
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private Boolean isOverParcelPayment = false;

  @Schema(example = "15", required = true, description = "Texto livre de responsabilidade de cada Instituição transmissora para identificar a parcela informada")
  @JsonProperty("instalmentId")
  @NotNull
  @Pattern(regexp="\\w\\W\\s]*")
  @Size(max=40)
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private String instalmentId = "NA";

  @Schema(example = "2021-05-21T08:30Z", required = true, description = "Traz a data de efetivação do pagamento referente ao contrato da modalidade de crédito consultada, conforme especificação RFC-3339.")
  @JsonProperty("paidDate")
  @NotNull
  @Pattern(regexp = "^(\\d{4})-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])$")
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private String paidDate = "0000-01-01";

  @Schema(example = "BRL", required = true, description = "Moeda referente ao valor monetário informado, segundo modelo ISO-4217. p.ex. ''BRL''. Todos os valores monetários informados estão representados com a moeda vigente do Brasil")
  @JsonProperty("currency")
  @NotNull
  @Pattern(regexp="^(\\w{3}){1}$")
  @Size(max=3)
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private String currency = "BRL";

  @Schema(example = "100000.04", required = true, description = "Traz o valor do pagamento referente ao  contrato da modalidade de crédito consultada. Expresso em valor monetário com 4 casas decimais")
  @JsonProperty("paidAmount")
  @JsonDeserialize(using = ValueDeserializeScale.class)
  //@Pattern(regexp="^-?\\d{1,15}\\.\\d{2,4}$")
  @NotNull
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private BigDecimal paidAmount = new BigDecimal("0.0000");

  @Schema(required = true, description = "")
  @JsonProperty("overParcel")
  @NotNull
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private PaymentsDataOverParcel overParcel = PaymentsDataOverParcel.builder().build();
}
