package sistema.financeiro.api.domain.usuario;

import jakarta.validation.constraints.NotNull;
import sistema.financeiro.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoUsuario(@NotNull
                                         Long id,
                                      @NotNull
                                      String nome,
                                      @NotNull
                                      String email,
                                      @NotNull
                                      String senha){
}
