package br.gov.caixa.sidpn.api.swagger.contracts.warranties;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class WarrantiesDataHelper
{
	@JsonProperty("warranties")
   @Default
   private List<WarrantiesData> contractWarranties = List.of(WarrantiesData.builder().build());
}