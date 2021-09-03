package br.gov.caixa.sidpn.api.swagger.contracts.payments;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
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
public class PaymentsDataOverParcel {
  @Schema(required = true, description = "Lista das tarifas que foram pagas fora da parcela, só para pagamento avulso.")
  @JsonProperty("fees")
  @NotNull
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private List<PaymentsDataOverParcelFee> fees = List.of(PaymentsDataOverParcelFee.builder().build());

  @Schema(required = true, description = "Lista dos encargos que foram pagos fora da parcela.")
  @JsonProperty("charges")
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private List<PaymentsDataOverParcelCharge> charges = List.of(PaymentsDataOverParcelCharge.builder().build());
}