package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@RestController
@CronappSwagger
@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Periodo {

public static final int TIMEOUT = 300;

/**
 *
 * @author Ícaro Antunes
 * @since 07/02/2024, 11:01:44
 *
 */
public static Var fa_C3_A7a_algo() throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;

   public Var call() throws Exception {
    item =
    cronapi.json.Operations.toJson(
    cronapi.util.Operations.getURLFromOthers(
    Var.valueOf("GET"),
    Var.valueOf("application/json"),
    Var.valueOf("https://servicodados.ibge.gov.br/api/v1/localidades/estados"),
    cronapi.map.Operations.createObjectMapWith(Var.valueOf("orderBy",
    Var.valueOf("nome"))), Var.VAR_NULL, Var.VAR_NULL,
    Var.valueOf(""),
    Var.valueOf("BODY")));
    System.out.println(item.getObjectAsString());
    for (Iterator it_i = item.iterator(); it_i.hasNext();) {
        i = Var.valueOf(it_i.next());
        System.out.println(
        cronapi.json.Operations.getJsonOrMapField(i,
        Var.valueOf("nome")).getObjectAsString());
    } // end for
    System.out.println(
    cronapi.json.Operations.getJsonOrMapField(
    cronapi.list.Operations.getFirst(item),
    Var.valueOf("id")).getObjectAsString());
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Ícaro Antunes
 * @since 07/02/2024, 11:01:44
 *
 */
@RequestMapping(path = { "/api/cronapi/rest/Periodo:obterPeriodoAtivo", "/obterPeriodoAtivo" }, method = RequestMethod.GET, consumes = "*/*")
public static Var obterPeriodoAtivo() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
cronapi.list.Operations.getFirst((
cronapi.database.Operations.query(Var.valueOf("app.entity.Periodo"),Var.valueOf("select \n	p.ativo \nfrom \n	Periodo p  \nwhere \n	p.ativo = true"))));
   }
 }.call();
}

}

