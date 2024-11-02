package sistema.financeiro.api.domain.lancamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sistema.financeiro.api.domain.categoria.Categoria;
import sistema.financeiro.api.domain.pessoa.Pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "lancamentos")
@Entity(name = "Lancamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoLancamento lancamento;
    private String descricao;
    private LocalDate vencimento;
    private LocalDate pagamento;
    private BigDecimal valor;
    private String observacao;
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria idCategoria;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa idPessoa;

    public Lancamento(DadosCadastroLancamento dados, Categoria categoria, Pessoa pessoa) {
        this.ativo = true;
        this.lancamento = dados.lancamento();
        this.descricao = dados.descricao();
        this.vencimento = dados.dataVencimento();
        this.pagamento = dados.dataPagamento();
        this.valor = dados.valor();
        this.observacao = dados.observacao();
        this.idCategoria = categoria;
        this.idPessoa = pessoa;
    }


    public void atualizarInformacoes(DadosAtualizacaoLancamento dados, Categoria categoria, Pessoa pessoa) {
        if (dados.lancamento() != null) {
            this.lancamento = dados.lancamento();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.dataVencimento() != null) {
            this.vencimento = dados.dataVencimento();
        }
        if (dados.dataPagamento() != null) {
            this.pagamento = dados.dataPagamento();
        }
        if (dados.valor() != null) {
            this.valor = dados.valor();
        }
        if (dados.observacao() != null) {
            this.observacao = dados.observacao();
        }
        if (categoria != null) {
            this.idCategoria = categoria;
        }
        if (pessoa != null) {
            this.idPessoa = pessoa;
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
