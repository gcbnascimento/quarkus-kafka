/*
* Fóton Informática S.A.
* Criação : 29 de abr de 2021
*/

package br.gov.caixa.sidpn.api.swagger;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
* @author abril/2021: fabio.sobral
*/
public interface ResponseData
{
   @JsonIgnore
   String getProductSubTypeString();
}