package br.gov.caixa.sidpn.api.dto.impl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import br.gov.caixa.sidpn.api.dto.CreditCollectionDTO;
import br.gov.caixa.sidpn.api.swagger.contracts.data.ResponseContractData;
import br.gov.caixa.sidpn.api.swagger.contracts.payments.PaymentsData;
import br.gov.caixa.sidpn.api.swagger.contracts.scheduledinstalments.InstalmentsData;
import br.gov.caixa.sidpn.api.swagger.contracts.warranties.WarrantiesData;
import br.gov.caixa.sidpn.api.util.Strings;
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
@NoArgsConstructor
@AllArgsConstructor
public class ContractDTO
		implements CreditCollectionDTO<ResponseContractData, PaymentsData, InstalmentsData, WarrantiesData> {
	private String id;
	@JsonAlias(Strings.CONTRACT_IDENTIFICATION_ALIAS)
	private ResponseContractData contractIdentification;
	@JsonAlias(Strings.CONTRACT_SCHEDULED_INSTALMENTS_ALIAS)
	@Default
	private InstalmentsData contractScheduledInstalments = InstalmentsData.builder().build();

	@JsonAlias(Strings.CONTRACT_PAYMENTS_ALIAS)
	@Default
	private PaymentsData contractPayments = PaymentsData.builder().build();
	

}
