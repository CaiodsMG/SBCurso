package br.com.projectcaio.exerciciossb.Controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/calculadora")
public class CalculadoraController {


    //calculadora/somar/num1/num2
    @GetMapping("/somar/{a}/{b}")
    public int somar(@PathVariable int a, @PathVariable int b){
        return a + b;
    }

    //calculadora/subtrair?a=num1&b=num2
    @GetMapping("/subtrair")
    public int subtrair(
            @RequestParam(name = "a") int a, @RequestParam(name = "b") int b){
        return a - b;
    }

}
