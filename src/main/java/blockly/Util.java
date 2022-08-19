package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Util {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// util
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var adicionarQuery() throws Exception {
 return new Callable<Var>() {

   private Var ret = Var.VAR_NULL;

   public Var call() throws Exception {

    ret =
    cronapi.json.Operations.toJson(
    cronapi.util.Operations.getURLFromOthers(
    Var.valueOf("POST"),
    Var.valueOf("application/json"),
    Var.valueOf("https://lai-service-sql.herokuapp.com/service/sql/"), Var.VAR_NULL, Var.VAR_NULL,
    cronapi.map.Operations.createObjectMapWith(Var.valueOf("queryName",
    cronapi.text.Operations.replaceAll(
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.queryname")),
    Var.valueOf(" "),
    Var.valueOf("_"))) , Var.valueOf("query",
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.query"))) , Var.valueOf("sgbd",
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.sgbd"))) , Var.valueOf("product",
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.product")))),
    Var.valueOf(""),
    Var.valueOf("BODY")));
    return ret;
   }
 }.call();
}

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Descreva esta função...
public static Var deleteQuery(@ParamMetaData(description = "queryName") Var queryName) throws Exception {
 return new Callable<Var>() {

   private Var ret = Var.VAR_NULL;

   public Var call() throws Exception {

    ret =
    cronapi.json.Operations.toJson(
    cronapi.util.Operations.getURLFromOthers(
    Var.valueOf("DELETE"),
    Var.valueOf("application/json"),
    Var.valueOf(
    Var.valueOf("https://lai-service-sql.herokuapp.com/service/sql/").toString() +
    queryName.toString()), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL,
    Var.valueOf(""),
    Var.valueOf("BODY")));
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Descreva esta função...
public static Var editarQuery(@ParamMetaData(description = "queryName") Var queryName) throws Exception {
 return new Callable<Var>() {

   private Var ret = Var.VAR_NULL;

   public Var call() throws Exception {

    ret =
    cronapi.json.Operations.toJson(
    cronapi.util.Operations.getURLFromOthers(
    Var.valueOf("PUT"),
    Var.valueOf("application/json"),
    Var.valueOf(
    Var.valueOf("https://lai-service-sql.herokuapp.com/service/sql/").toString() +
    queryName.toString()), Var.VAR_NULL, Var.VAR_NULL,
    cronapi.map.Operations.createObjectMapWith(Var.valueOf("queryName",
    /*# sourceMappingStart=c=[,P]`NN_PbrU7ys~$} */
    ( cronapi.logic.Operations.isNullOrEmpty(
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.queryname"))).getObjectAsBoolean() ?
    Var.valueOf("") :
    cronapi.text.Operations.replaceAll(
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.queryname")),
    Var.valueOf(" "),
    Var.valueOf("_")))) , Var.valueOf("query",
    /*# sourceMappingStart=.4en*4mkc;Rc++|q*0Cf */
    ( cronapi.logic.Operations.isNullOrEmpty(
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.query"))).getObjectAsBoolean() ?
    Var.valueOf("") :
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.query")))) , Var.valueOf("sgbd",
    /*# sourceMappingStart=tN:f/+[zS:Kq5c!U{#i3 */
    ( cronapi.logic.Operations.isNullOrEmpty(
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.sgbd"))).getObjectAsBoolean() ?
    Var.valueOf("") :
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.sgbd")))) , Var.valueOf("product",
    /*# sourceMappingStart=Gay-(Jd+4eotnESZApdl */
    ( cronapi.logic.Operations.isNullOrEmpty(
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.product"))).getObjectAsBoolean() ?
    Var.valueOf("") :
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.product"))))),
    Var.valueOf(""),
    Var.valueOf("BODY")));
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var obterQuerys() throws Exception {
 return new Callable<Var>() {

   private Var ret = Var.VAR_NULL;

   public Var call() throws Exception {

    ret =
    cronapi.json.Operations.toJson(
    cronapi.util.Operations.getURLFromOthers(
    Var.valueOf("GET"),
    Var.valueOf("application/json"),
    Var.valueOf("https://lai-service-sql.herokuapp.com/service/sql/all"), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL,
    Var.valueOf(""),
    Var.valueOf("BODY")));

    System.out.println(ret.getObjectAsString());
    return ret;
   }
 }.call();
}

}

