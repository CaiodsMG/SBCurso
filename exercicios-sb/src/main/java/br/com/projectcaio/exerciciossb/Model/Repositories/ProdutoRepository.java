package br.com.projectcaio.exerciciossb.Model.Repositories;

import br.com.projectcaio.exerciciossb.Model.Entities.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository
        extends CrudRepository<Produto, Integer> {


    public Iterable<Produto> findByNomeContaining(String parteNome);

    public Iterable<Produto> findByPrecoGreaterThan(double preco);

    public Iterable<Produto> findByNomeStartingWith(String comecaCom);

    public Iterable<Produto> findByNomeEndingWith(String terminaCom);
}
