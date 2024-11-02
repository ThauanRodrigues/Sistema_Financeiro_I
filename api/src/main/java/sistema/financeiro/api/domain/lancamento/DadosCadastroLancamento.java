package sistema.financeiro.api.domain.lancamento;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroLancamento(
        @NotNull
        TipoLancamento lancamento,
        @NotBlank
        String descricao,

        @FutureOrPresent
        LocalDate dataVencimento,

        @PastOrPresent
        LocalDate dataPagamento,

        @Positive
        BigDecimal valor,

        @Size(max = 200, message
                = "A observação excede o máximo de 200 caracteres!")
        String observacao,

        @NotNull
        Long idCategoria,
        @NotNull
        Long idPessoa) {
}