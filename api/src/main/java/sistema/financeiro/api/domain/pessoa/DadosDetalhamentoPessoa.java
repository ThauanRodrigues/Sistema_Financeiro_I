package sistema.financeiro.api.domain.pessoa;

import sistema.financeiro.api.domain.endereco.Endereco;

public record DadosDetalhamentoPessoa(
        Long id, String nome,
        Endereco endereco) {
            public DadosDetalhamentoPessoa(Pessoa pessoa) {
                this(pessoa.getId(),
                        pessoa.getNome(),
                        pessoa.getEndereco());
            }
        }
