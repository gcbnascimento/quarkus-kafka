package br.gov.caixa.sidpn.api.swagger;

import java.util.List;

import br.gov.caixa.sidpn.api.swagger.contracts.payments.PaymentsDataReleases;

public interface ResponseDataPayments {
	
	List<PaymentsDataReleases> getReleases();

}
