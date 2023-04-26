package br.com.alurafood.pagamentos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alurafood.pagamentos.model.Pagamento;

public interface PagamentosRepository  extends JpaRepository<Pagamento, Long>{

}
