window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Pokemon = window.blockly.js.blockly.Pokemon || {};

/**
 * @function monitoraCampo
 *
 *
 *
 *
 * @author Ícaro Antunes
 * @since 06/02/2024, 11:22:08
 *
 */
window.blockly.js.blockly.Pokemon.monitoraCampoArgs = [];
window.blockly.js.blockly.Pokemon.monitoraCampo = async function() {
 var item;
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.input9935"))) {
    //
    this.cronapi.screen.changeValueOfField("vars.flagTrueOrFalse", false);
    //
    console.log(this.cronapi.screen.getValueOfField("vars.flagTrueOrFalse"));
  } else {
    //
    this.cronapi.screen.changeValueOfField("vars.flagTrueOrFalse", true);
    //
    console.log(this.cronapi.screen.getValueOfField("vars.flagTrueOrFalse"));
  }
}

/**
 * @function requisicaoApiPokeManual
 *
 *
 *
 *
 * @author Ícaro Antunes
 * @since 06/02/2024, 11:22:08
 *
 */
window.blockly.js.blockly.Pokemon.requisicaoApiPokeManualArgs = [];
window.blockly.js.blockly.Pokemon.requisicaoApiPokeManual = async function() {
 var item;
  //
  this.cronapi.util.getURLFromOthers('GET', 'application/json', String('https://pokeapi.co/api/v2/pokemon/') + String(this.cronapi.screen.getValueOfField("vars.inputPeloBloco")), null, null, async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.screen.changeValueOfField("vars.dynamicimage6675", this.cronapi.object.getProperty(item, 'sprites.front_default'));
  }.bind(this), async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.notification.confirmDialogAlert('error', 'Erro!', 'Id inválido', this.cronapi.notification.buttonConfirmDialogAlert('true', 'Ok!', async function() {
      }.bind(this)));
  }.bind(this));
}
