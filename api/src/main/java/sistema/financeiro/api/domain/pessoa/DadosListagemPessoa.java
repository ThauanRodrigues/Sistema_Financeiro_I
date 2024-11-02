package sistema.financeiro.api.domain.pessoa;

import org.jetbrains.annotations.NotNull;

public record DadosListagemPessoa(Long id, String nome) {
    public DadosListagemPessoa(@NotNull Pessoa pessoa){this(pessoa.getId(), pessoa.getNome());}
}