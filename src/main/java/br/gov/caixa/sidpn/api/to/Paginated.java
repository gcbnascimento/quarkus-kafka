package br.gov.caixa.sidpn.api.to;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe com intuito de controlar a paginação parâmetro "paginate" criado pois no Cosmos algumas consultas já fazem a paginação (offset e
 * limit) e ao criar essa isntância a paginação não pode ser feita novamente pra não prejudicar a paginação e os totais
 *
 * @author maio/2021: Ares
 */
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Paginated
{

	private PagingTO paging;
	private Optional<? extends List> data;

	public Paginated(PagingTO paging, Optional<? extends List> data, boolean paginate) {
		log.debug("[PAGINATION] Criando objeto de paginação, paginate:{}, paging:{}", paginate, paging);
		this.paging = paging;
		this.data = data;
		if(data.isPresent()) {
			this.paging.setTotalRecords((this.data.get()).size());
			if(paginate) {
				this.data = Optional.of(Arrays.asList(data.get().stream().skip(this.paging.getOffset())
						.limit(this.paging.getPageSize()).toArray()));
			}
		}
	}
}
