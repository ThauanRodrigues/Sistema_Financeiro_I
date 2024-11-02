package sistema.financeiro.api.domain.lancamento;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizacaoLancamento(@NotNull
                                         Long id,
                                         TipoLancamento lancamento,
                                         String descricao,
                                         LocalDate dataVencimento,
                                         LocalDate dataPagamento,
                                         BigDecimal valor,
                                         String observacao,
                                         Long idCategoria,
                                         Long idPessoa) {
}
