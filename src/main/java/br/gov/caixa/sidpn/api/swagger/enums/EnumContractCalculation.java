package br.gov.caixa.sidpn.api.swagger.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumContractCalculation {
	D_21_POR_252("21/252"),
	D_30_POR_360("30/360"),
	D_30_POR_365("30/365");
	
	private String value;

	  @Override
	  @JsonValue
	  public String toString()
	  {
	    return String.valueOf(value);
	  }

	  @JsonCreator
	  public static EnumContractCalculation fromValue(String text)
	  {
	    for (EnumContractCalculation b : EnumContractCalculation.values())
	    {
	        if (b.value.equals(text))
	        {
	          return b;
	        }
	    }
	    return null;
	  }
	
}
