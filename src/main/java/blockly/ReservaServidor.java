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
 * @since 08/02/2024, 10:58:09
 *
 */
public static Var antesDeInserir(@ParamMetaData(description = "Entidade", id = "b0b5617e") Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var objetoVaga = Var.VAR_NULL;
   private Var periodoAtivoNoMomento = Var.VAR_NULL;

   public Var call() throws Exception {
    objetoVaga =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Vaga"),Var.valueOf("select \n	v \nfrom \n	Vaga v  \nwhere \n	v.id = :id"),Var.valueOf("id",
    cronapi.conversion.Operations.toString(
    cronapi.object.Operations.getObjectField(
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("vaga")),
    Var.valueOf("id")))));
    periodoAtivoNoMomento =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Periodo"),Var.valueOf("select \n	p \nfrom \n	Periodo p  \nwhere \n	p.ativo = true"));
    if (
    cronapi.database.Operations.hasElement(Entidade).getObjectAsBoolean()) {
        cronapi.database.Operations.updateField(Entidade,
        Var.valueOf("periodo"),
        cronapi.database.Operations.getField(periodoAtivoNoMomento, Var.valueOf("this[0].periodo")));
    } else {
        cronapi.util.Operations.throwException(
        Var.valueOf("Contate um admin, não há nenhum período ativo."));
    }
    if (
    Var.valueOf(
    cronapi.database.Operations.getField(objetoVaga,
    Var.valueOf("this[0].status")).equals(
    Var.valueOf("Fechada"))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf("Essa vaga já está sendo ocupada. Tente outra."));
    }
    if (
    cronapi.list.Operations.getFirst((
    cronapi.database.Operations.query(Var.valueOf("app.entity.Reserva"),Var.valueOf("select \n	r.ativo \nfrom \n	Reserva r  \nwhere \n	r.user.normalizedUserName = :userNormalizedUserName"),Var.valueOf("userNormalizedUserName",
    cronapi.text.Operations.normalize(
    cronapi.util.Operations.getCurrentUserName()))))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf("Você só pode reservar uma vaga por vez"));
    } else {
        cronapi.database.Operations.updateField(Entidade,
        Var.valueOf("ativo"),
        Var.VAR_TRUE);
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
 * @since 08/02/2024, 10:58:09
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

