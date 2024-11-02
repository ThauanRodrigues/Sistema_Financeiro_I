package sistema.financeiro.api.domain.categoria;

import org.jetbrains.annotations.NotNull;

public record DadosListagemCategoria(Long id, String nome) {
    public DadosListagemCategoria(@NotNull Categoria categoria) {
        this(categoria.getId(), categoria.getNome());
    }
}