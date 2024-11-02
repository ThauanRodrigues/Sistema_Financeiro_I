package sistema.financeiro.api.domain.lancamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosDetalhamentoLancamento(
        Long id,
        TipoLancamento lancamento,
        String descricao,
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        BigDecimal valor,
        String observacao,
        Long idCategoria,
        Long idPessoa) {

    public DadosDetalhamentoLancamento(Lancamento lancamento) {
        this(lancamento.getId(),
                lancamento.getLancamento(),
                lancamento.getDescricao(),
                lancamento.getVencimento(),
                lancamento.getPagamento(),
                lancamento.getValor(),
                lancamento.getObservacao(),
                lancamento.getIdCategoria().getId(),
                lancamento.getIdPessoa().getId());
    }
}
