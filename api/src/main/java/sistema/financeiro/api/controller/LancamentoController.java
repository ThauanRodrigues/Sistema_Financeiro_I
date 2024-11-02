package sistema.financeiro.api.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;
import sistema.financeiro.api.domain.categoria.CategoriaRepository;
import sistema.financeiro.api.domain.lancamento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import sistema.financeiro.api.domain.pessoa.PessoaRepository;

@RestController
@RequestMapping("lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLancamento dados, UriComponentsBuilder uriBuilder){
        var categoria = categoriaRepository.findById(dados.idCategoria())
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
        var pessoa = pessoaRepository.findById(dados.idPessoa())
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));

        var lancamento = new Lancamento(dados, categoria, pessoa);
        lancamentoRepository.save(lancamento);

        var dto = new DadosDetalhamentoLancamento(lancamento);

        var uri = uriBuilder.path("/lancamentos/{id}").buildAndExpand(lancamento.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLancamento>> listar(@PageableDefault(size=10, sort = {"id"}) Pageable paginacao){
        var page = lancamentoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemLancamento::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLancamento dados){
        var lancamento = lancamentoRepository.getReferenceById(dados.id());

        var categoria = categoriaRepository.findById(dados.idCategoria())
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
        var pessoa = pessoaRepository.findById(dados.idPessoa())
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));

        lancamento.atualizarInformacoes(dados, categoria, pessoa);

        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var lancamento = lancamentoRepository.getReferenceById(id);
        lancamento.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var lancamento = lancamentoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));
    }
}