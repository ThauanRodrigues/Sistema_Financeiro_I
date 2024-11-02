package sistema.financeiro.api.domain.pessoa;

import jakarta.validation.constraints.NotNull;
import sistema.financeiro.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPessoa(@NotNull
                                         Long id,
                                     String nome,
                                     DadosEndereco endereco){
}
