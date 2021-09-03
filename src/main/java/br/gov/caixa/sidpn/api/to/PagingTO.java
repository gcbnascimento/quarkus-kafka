/*
* Fóton Informática S.A.
* Criação : 6 de mai de 2021
*/
package br.gov.caixa.sidpn.api.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author maio/2021: fabio.sobral
 */
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PagingTO
{

   @Builder.Default
   Integer page = 1;
   @Builder.Default
   Integer pageSize = 25;
   @Builder.Default
   Integer totalPages = 1; // valor padrão
   @Builder.Default
   Integer totalRecords = 1; // valor padrão
   private static final Integer FIRST = 1;

   public PagingTO(Integer page, Integer pageSize)
   {
      this.page = page;
      this.pageSize = pageSize;
      totalPages = 1;
      totalRecords = 1;
   }

   public Integer getTotalPages(Integer totalRecords)
   {
      this.totalRecords = totalRecords;
      return (int) Math.ceil((double) this.totalRecords / pageSize);
   }

   public void setTotalRecords(Integer totalRecords)
   {
      this.totalPages = getTotalPages(totalRecords);
   }

   public Integer getOffset()
   {
      return (page - 1) * pageSize;
   }

   public boolean isFirst()
   {
      return page.equals(getFirst());
   }

   public boolean hasPrev()
   {
      return !this.isFirst();
   }

   public boolean hasNext()
   {
      return !this.isLast();
   }

   public boolean isLast()
   {
      return totalPages.equals(page);
   }

   public Integer getFirst()
   {
      return FIRST;
   }

   public Integer getNext()
   {
      return page + 1;
   }

   public Integer getLast()
   {
      return totalPages;
   }

   public Integer getPrev()
   {
      return page - 1;
   }

}
