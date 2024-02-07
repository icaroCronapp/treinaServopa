package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class LogicaLogin {

public static final int TIMEOUT = 300;

/**
 *
 * @author Ícaro Antunes
 * @since 31/01/2024, 10:13:45
 *
 */
public static Var trueAdmin() throws Exception {
 return new Callable<Var>() {

   private Var ehAdmin = Var.VAR_NULL;

   public Var call() throws Exception {
    ehAdmin =
    cronapi.database.Operations.query(Var.valueOf("app.entity.UserRole"),Var.valueOf("select \n	u \nfrom \n	UserRole u  \nwhere \n	u.user.normalizedUserName = :userNormalizedUserName AND \n	u.role.builtIn = true"),Var.valueOf("userNormalizedUserName",
    cronapi.util.Operations.getCurrentUserName()));
    if (
    cronapi.database.Operations.hasElement(ehAdmin).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction(Var.valueOf("blockly.js.blockly.PeriodoCliente.mostraModal"));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

