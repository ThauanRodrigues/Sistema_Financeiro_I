package sistema.financeiro.api.domain.usuario;

import org.jetbrains.annotations.NotNull;

public record DadosListagemUsuario(Long id, String nome, String email, String senha) {
    public DadosListagemUsuario(@NotNull Usuario usuario){this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());}
}