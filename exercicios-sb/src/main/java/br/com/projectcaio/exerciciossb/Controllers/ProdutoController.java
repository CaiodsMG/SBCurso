package br.com.projectcaio.exerciciossb.Controllers;

import br.com.projectcaio.exerciciossb.Model.Entities.Produto;
import br.com.projectcaio.exerciciossb.Model.Repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;


    //@PostMapping
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto novoProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public Iterable<Produto> obterProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome){
        return produtoRepository.findByNomeContaining(parteNome);
    }

    @GetMapping(path = "/preco/{precoMaior}")
    public Iterable<Produto> obterProdutosPorPrecoMaiorQue(@PathVariable double precoMaior){
        return produtoRepository.findByPrecoGreaterThan(precoMaior);
    }

    @GetMapping(path = "/comeca/{comecaCom}")
    public Iterable<Produto> obterProdutoComecaCom(@PathVariable String comecaCom){
        return produtoRepository.findByNomeStartingWith(comecaCom);
    }

    @GetMapping(path = "/termina/{terminaCom}")
    public Iterable<Produto> obterProdutoTerminaCom(@PathVariable String terminaCom){
        return produtoRepository.findByNomeEndingWith(terminaCom);
    }



    @GetMapping("/{id}")
    public Optional<Produto> obterProduto(@PathVariable int id){
       return produtoRepository.findById(id);
    }

    /*@PutMapping
    public Produto alterarProduto(@Valid Produto produto){
        produtoRepository.save(produto);
        return produto;
    }*/

    @DeleteMapping(path = "/{id}")
    public void deletarProduto(@PathVariable int id){
        produtoRepository.deleteById(id);
    }
}
