package blockly;

import cronapi.CronapiMetaData;
import cronapi.ParamMetaData;


/**
 * Descrição da Função ...
 *
 * @author Ícaro Antunes
 * @version 1.0
 * @since 2024-02-08
 *
 */

@CronapiMetaData(categoryName = "Minhas Funções")
public class NomeDaClasse {

	@CronapiMetaData(type = "function", name = "Nova Função", description = "Descrição da Função")
	public static String NovaFuncao(@ParamMetaData(description = "Parâmetro: Descrição do parâmetro") String input) throws Exception {

		return "Input " + input;
		
	}

}