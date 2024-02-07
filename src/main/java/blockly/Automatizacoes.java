package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Automatizacoes {

public static final int TIMEOUT = 300;

/**
 *
 * @param Entidade<app.entity.Reserva>
 *
 * @author Ícaro Antunes
 * @since 01/02/2024, 10:57:41
 *
 */
public static Var obterLoginIdDoUsarioLogado(@ParamMetaData(description = "Entidade", id = "76c9a689") Var Entidade) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
cronapi.list.Operations.getFirst((
cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u  \nwhere \n	u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
cronapi.text.Operations.normalize(
cronapi.util.Operations.getCurrentUserName())))));
   }
 }.call();
}

}

