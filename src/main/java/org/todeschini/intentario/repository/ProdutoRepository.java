package org.todeschini.intentario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.todeschini.intentario.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
