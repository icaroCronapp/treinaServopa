package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ReservaServidor {

public static final int TIMEOUT = 300;

/**
 *
 * @param Entidade<app.entity.Reserva>
 *
 * @author Ícaro Antunes
 * @since 01/02/2024, 11:42:36
 *
 */
public static Var antesDeInserir(@ParamMetaData(description = "Entidade", id = "b0b5617e") Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var objetoVaga = Var.VAR_NULL;

   public Var call() throws Exception {
    objetoVaga =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Vaga"),Var.valueOf("select \n	v \nfrom \n	Vaga v  \nwhere \n	v.id = :id"),Var.valueOf("id",
    cronapi.conversion.Operations.toString(
    cronapi.object.Operations.getObjectField(
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("vaga")),
    Var.valueOf("id")))));
    if (
    Var.valueOf(
    cronapi.database.Operations.getField(objetoVaga,
    Var.valueOf("this[0].status")).equals(
    Var.valueOf("Fechada"))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf("Essa vaga já está sendo ocupada. Tente outra."));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param Entidade<app.entity.Reserva>
 *
 * @author Ícaro Antunes
 * @since 01/02/2024, 11:42:36
 *
 */
public static Var depoisDeInserir(@ParamMetaData(description = "Entidade", id = "b0b5617e") Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var objetoVagaQueFoiReservada = Var.VAR_NULL;

   public Var call() throws Exception {
    objetoVagaQueFoiReservada =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Vaga"),Var.valueOf("select \n	v \nfrom \n	Vaga v  \nwhere \n	v.id = :id"),Var.valueOf("id",
    cronapi.conversion.Operations.toString(
    cronapi.object.Operations.getObjectField(
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("vaga")),
    Var.valueOf("id")))));
    cronapi.database.Operations.updateField(objetoVagaQueFoiReservada,
    Var.valueOf("status"),
    Var.valueOf("Fechada"));
    return Var.VAR_NULL;
   }
 }.call();
}

}

