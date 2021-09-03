package br.gov.caixa.sidpn.api.swagger.contracts.payments;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonInclude;
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

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema
public class PaymentsData {

	@Schema(example = "73", required = true, description = "Quantidade total de parcelas pagas do contrato referente à Modalidade de Crédito informada")
	@JsonProperty("paidInstalments")
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private BigDecimal paidInstalments;

	@Schema(example = "100000.04", required = true, description = "Saldo devedor Remanescente, divulgado nos canais eletrônicos, do contrato referente à Modalidade de Crédito informada. Expresso em valor monetário com 4 casas decimais")
	// @Pattern(regexp="^-?\\d{1,15}\\.\\d{2,4}$")
	@JsonProperty("contractOutstandingBalance")
	@NotNull
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	@JsonDeserialize(using = ValueDeserializeScale.class)
	private BigDecimal contractOutstandingBalance = new BigDecimal("0.0000");

	@Schema(required = true, description = "Lista dos pagamentos realizados no período")
	@JsonProperty("releases")
	@NotNull
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private List<PaymentsDataReleases> releases = List.of(PaymentsDataReleases.builder().build());

	public List<PaymentsDataReleases> getReleases() {
		if (releases.isEmpty()) {
			return List.of(PaymentsDataReleases.builder().build());
		}
		return releases;
	}

}
