package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class AutomatizaUser {

public static final int TIMEOUT = 300;

/**
 *
 * @param Entidade<app.entity.Reserva>
 *
 * @author Ícaro Antunes
 * @since 01/02/2024, 11:11:20
 *
 */
public static Var obterUserNameAtual(@ParamMetaData(description = "Entidade", id = "8a640e8e") Var Entidade) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
cronapi.list.Operations.getFirst((
cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.normalizedUserName \nfrom \n	User u  \nwhere \n	u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
cronapi.util.Operations.getCurrentUserName()))));
   }
 }.call();
}

}

