window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.PeriodoCliente = window.blockly.js.blockly.PeriodoCliente || {};

/**
 * @function mostraModal
 *
 *
 *
 *
 * @author Ícaro Antunes
 * @since 07/02/2024, 10:38:38
 *
 */
window.blockly.js.blockly.PeriodoCliente.mostraModalArgs = [];
window.blockly.js.blockly.PeriodoCliente.mostraModal = async function() {
 var a, orderBy, y, z, item;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Periodo:obterPeriodoAtivo', async function(sender_valorDoperiodoAtivo) {
      valorDoperiodoAtivo = sender_valorDoperiodoAtivo;
    //
    console.log(valorDoperiodoAtivo);
    //
    if (!valorDoperiodoAtivo) {
      //
      this.cronapi.notification.confirmDialogAlert('warning', 'Você não tem um período ativo. ', 'Cadastre um para disponibilizar reservas.', [this.cronapi.notification.buttonConfirmDialogAlert('true', 'Ok, entendi!', async function() {
        }.bind(this)), this.cronapi.notification.buttonConfirmDialogAlert('false', 'Cadastre um período', async function() {
         //
        this.cronapi.screen.changeView("#/home/admin/periodo",[  ]);
       }.bind(this))]);
    }
  }.bind(this));
}

/**
 * @function faça algo
 *
 *
 *
 *
 * @author Ícaro Antunes
 * @since 07/02/2024, 10:38:38
 *
 */
window.blockly.js.blockly.PeriodoCliente.fa_C3_A7a_algoArgs = [];
window.blockly.js.blockly.PeriodoCliente.fa_C3_A7a_algo = async function() {
 var a, orderBy, y, z, item;
  //
  this.cronapi.util.getURLFromOthers('GET', 'application/json', 'https://servicodados.ibge.gov.br/api/v1/localidades/estados', [ { orderBy : 'nome' } ], null, async function(sender_item) {
      item = sender_item;
    //
    console.log(item);
  }.bind(this), async function(sender_item) {
      item = sender_item;
  }.bind(this));
}
