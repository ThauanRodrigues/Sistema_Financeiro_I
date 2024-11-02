package sistema.financeiro.api.domain.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
    Page<Lancamento> findAllByAtivoTrue(Pageable paginacao);
}
