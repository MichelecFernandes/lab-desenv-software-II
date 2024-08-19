package br.fai.backend.lds.backend.playground.aula_2;

import br.fai.backend.lds.backend.playground.aula_2.models.LgPrinter;
import br.fai.backend.lds.backend.playground.aula_2.models.Printer;
import br.fai.backend.lds.backend.playground.aula_2.models.SamsungPrinter;
import br.fai.backend.lds.backend.playground.aula_2.models.SecondPrinter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping
public class GenericRestController {

    @GetMapping("/testar")

    public ResponseEntity<String> test(){

        Printer<String> stringPrinter = new SamsungPrinter();

//        printer.printString("lala");
//        printer.printInt(111);

        stringPrinter.print("lalalalala");


        SecondPrinter secondPrinter = new LgPrinter();
        secondPrinter.print("texto");
        secondPrinter.print(123);
        secondPrinter.print(true);
        secondPrinter.print(123.4);

        return ResponseEntity.ok().body("teste do generico");
    }

}
