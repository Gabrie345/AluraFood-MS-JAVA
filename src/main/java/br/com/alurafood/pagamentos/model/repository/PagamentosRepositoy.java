package br.com.alurafood.pagamentos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alurafood.pagamentos.model.Pagamento;

public interface PagamentosRepositoy  extends JpaRepository<Pagamento, Long>{

}