package com.crocheteiras.crocheteiras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crocheteiras.crocheteiras.model.Produto;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findAllByOrderByIdAsc();
}


