/*
* Fóton Informática S.A.
* Criação : 29 de abr de 2021
*/
package br.gov.caixa.sidpn.api.dto;

import java.util.List;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

/**
* @author abril/2021: fabio.sobral
*/
public interface CreditCollectionDTO<I, P, S, W>
{
    
    @JsonProperty("contractData")
    I getContractIdentification();
    @JsonProperty("payments")
    P getContractPayments();
    @JsonProperty("scheduledInstalments")
    S getContractScheduledInstalments();
 

    @Getter
    public enum PersonType
    {

          FISICA(1),

          JURIDICA(2)

       ;

       private Integer value;

       private PersonType(int value){
          this.value = value;
       }


       /**
        * @param valor pode ser um int ou string, dependendo da origem do dado.
        * @return FISICA ou JURIDICA caso o @param valor informado for válido. null caso contrário.
        */
       @JsonCreator
       public static PersonType fromValue(Object valor)
       {  
          if(valor instanceof String){
             return Stream.of(PersonType.values()).filter(k -> k.name().equals(valor)).findFirst().orElse(null);
          }
          return Stream.of(PersonType.values()).filter(k -> k.value.equals(valor)).findFirst().orElse(null);
       }
   }
}
