package sistema.financeiro.api.domain.usuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import sistema.financeiro.api.domain.endereco.DadosEndereco;

public record DadosCadastroUsuario(
        @NotNull
        String nome,
        @NotNull
        String email,
        @NotNull
        String senha) {
}
