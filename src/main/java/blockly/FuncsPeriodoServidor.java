package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class FuncsPeriodoServidor {

public static final int TIMEOUT = 300;

/**
 *
 * @param Entidade<app.entity.Periodo>
 *
 * @author Ícaro Antunes
 * @since 07/02/2024, 11:22:38
 *
 */
public static Var antesDeInserir(@ParamMetaData(description = "Entidade", id = "054f7668") Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var periodoGerado = Var.VAR_NULL;
   private Var consultaPeriodo = Var.VAR_NULL;
   private Var datasEntre = Var.VAR_NULL;
   private Var objetoAtivo = Var.VAR_NULL;

   public Var call() throws Exception {
    if (
    Var.valueOf(!
    cronapi.dateTime.Operations.getMonth(
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("dataInicial"))).equals(
    cronapi.dateTime.Operations.getMonth(
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("dataFinal"))))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("O mês das datas escolhidas precisam ser o mesmo.")));
    }
    periodoGerado =
    Var.VAR_NULL;
    if (
    Var.valueOf(
    Var.valueOf(
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("periodo")).equals(
    Var.valueOf("1"))).getObjectAsBoolean() ||
    Var.valueOf(
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("periodo")).equals(
    Var.valueOf("2"))).getObjectAsBoolean()).getObjectAsBoolean()) {
        periodoGerado =
        Var.valueOf(
        cronapi.object.Operations.getObjectField(Entidade,
        Var.valueOf("periodo")).getObjectAsString() +
        Var.valueOf("/").getObjectAsString() +
        cronapi.conversion.Operations.toString(
        cronapi.dateTime.Operations.getYear(
        cronapi.object.Operations.getObjectField(Entidade,
        Var.valueOf("dataFinal")))).getObjectAsString());
        cronapi.database.Operations.updateField(Entidade,
        Var.valueOf("periodo"), periodoGerado);
    }
    consultaPeriodo =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Periodo"),Var.valueOf("select \n	p \nfrom \n	Periodo p  \nwhere \n	p.periodo = :periodo"),Var.valueOf("periodo",periodoGerado));
    if (
    cronapi.database.Operations.hasElement(consultaPeriodo).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf(
        Var.valueOf("O Período ").getObjectAsString() +
        periodoGerado.getObjectAsString() +
        Var.valueOf(" já existe. Tente outro.").getObjectAsString()));
    }
    datasEntre =
    cronapi.database.Operations.query(Var.valueOf("app"),Var.valueOf("SELECT * \nFROM Periodo P \nWHERE :dataInicial BETWEEN p.dataInicial AND p.dataFinal\nOR :dataFinal BETWEEN p.dataInicial AND p.dataFinal;"),Var.valueOf("dataInicial",
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("dataInicial"))),Var.valueOf("dataFinal",
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("dataFinal"))));
    if (
    cronapi.database.Operations.hasElement(datasEntre).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf("Data já está sendo usada em outro período"));
    }
    objetoAtivo =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Periodo"),Var.valueOf("select \n	p \nfrom \n	Periodo p  \nwhere \n	p.ativo = true"));
    if (
    Var.valueOf(
    cronapi.database.Operations.getField(objetoAtivo,
    Var.valueOf("this[0].ativo")).getObjectAsBoolean() &&
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("ativo")).getObjectAsBoolean()).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf(
        Var.valueOf("O período ").getObjectAsString() +
        cronapi.database.Operations.getField(objetoAtivo,
        Var.valueOf("this[0].periodo")).getObjectAsString() +
        Var.valueOf("já está ativo. Apenas um período por vez pode ser ativo.").getObjectAsString()));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Ícaro Antunes
 * @since 07/02/2024, 11:22:38
 *
 */
public static void logicoobjetoativo() throws Exception {
  new Callable<Var>() {

   private Var Entidade = Var.VAR_NULL;
   private Var periodoGerado = Var.VAR_NULL;
   private Var consultaPeriodo = Var.VAR_NULL;
   private Var datasEntre = Var.VAR_NULL;
   private Var objetoAtivo = Var.VAR_NULL;

   public Var call() throws Exception {
   return Var.VAR_NULL;
   }
 }.call();
}

}

