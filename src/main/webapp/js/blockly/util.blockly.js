window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Util = window.blockly.js.blockly.Util || {};

/**
 * util
 */
window.blockly.js.blockly.Util.ExecutarArgs = [];
window.blockly.js.blockly.Util.Executar = async function() {
 var type, queryName, ret;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Util.initArgs = [];
window.blockly.js.blockly.Util.init = async function() {
 var type, queryName, ret;
  this.cronapi.screen.changeValueOfField("list_querys", (await this.cronapi.util.callServerBlockly('blockly.Util:obterQuerys')));
  this.cronapi.screen.changeValueOfField("action", false);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Util.pesquisarQuerysArgs = [];
window.blockly.js.blockly.Util.pesquisarQuerys = async function() {
 var type, queryName, ret;
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.search_query"))) {
    this.cronapi.screen.changeValueOfField("list_querys", (await this.cronapi.util.callServerBlockly('blockly.Util:obterQuerys')));
  } else {
    lista_aux = [];
    var item_list = (await this.cronapi.util.callServerBlockly('blockly.Util:obterQuerys'));
    for (var item_index in item_list) {
      item = item_list[item_index];
      if (this.cronapi.json.getProperty(item, 'queryName').indexOf(this.cronapi.screen.getValueOfField("vars.search_query")) + 1 > 0 || this.cronapi.json.getProperty(item, 'product').indexOf(this.cronapi.screen.getValueOfField("vars.search_query")) + 1 > 0 || this.cronapi.json.getProperty(item, 'sgbd').indexOf(this.cronapi.screen.getValueOfField("vars.search_query")) + 1 > 0) {
        lista_aux.push(item);
      }
    }
    this.cronapi.screen.changeValueOfField("list_querys", lista_aux);
  }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Util.atualizarQuerysArgs = [];
window.blockly.js.blockly.Util.atualizarQuerys = async function() {
 var type, queryName, ret;
  this.cronapi.screen.changeValueOfField("list_querys", (await this.cronapi.util.callServerBlockly('blockly.Util:obterQuerys')));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Util.ChangeActionArgs = ['edit', 'item'];
window.blockly.js.blockly.Util.ChangeAction = async function(edit, item) {
 var type;
  this.cronapi.screen.changeValueOfField("action", this.cronapi.conversion.toBoolean(this.cronapi.screen.getValueOfField("action")) ? false : true);
  if (edit) {
    this.cronapi.screen.changeValueOfField("edit", true);
    this.cronapi.screen.changeValueOfField("old_queryname", this.cronapi.json.getProperty(item, 'queryName'));
    this.cronapi.screen.changeValueOfField("vars.queryname", this.cronapi.json.getProperty(item, 'queryName'));
    this.cronapi.screen.changeValueOfField("vars.query", this.cronapi.json.getProperty(item, 'query'));
    this.cronapi.screen.changeValueOfField("vars.sgbd", this.cronapi.json.getProperty(item, 'sgbd'));
    this.cronapi.screen.changeValueOfField("vars.product", this.cronapi.json.getProperty(item, 'product'));
  } else {
    this.cronapi.screen.changeValueOfField("vars.queryname", '');
    this.cronapi.screen.changeValueOfField("vars.firebird", '');
    this.cronapi.screen.changeValueOfField("vars.postgres", '');
  }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Util.actionArgs = ['type', 'queryName'];
window.blockly.js.blockly.Util.action = async function(type, queryName) {
 var ret;
  if (type == 'POST') {
    console.log(this.cronapi.util.executeJavascriptReturn('$.getJSON(\"https://api.ipify.org?format=json\", function(data) {\n         return data\n    })'));
    this.cronapi.screen.changeValueOfField("action", this.cronapi.conversion.toBoolean(this.cronapi.screen.getValueOfField("action")) ? false : true);
  } else if (type == 'PUT') {
    ret = (await this.cronapi.util.callServerBlockly('blockly.Util:editarQuery', this.cronapi.screen.getValueOfField("old_queryname")));
    this.cronapi.screen.changeValueOfField("edit", false);
    this.cronapi.screen.changeValueOfField("action", this.cronapi.conversion.toBoolean(this.cronapi.screen.getValueOfField("action")) ? false : true);
  } else if (type == 'DELETE') {
    if (this.cronapi.conversion.toBoolean(this.cronapi.screen.confimDialog(['Deseja excluir a query \'',this.cronapi.json.getProperty(queryName, 'queryName'),'\' ?'].join('')))) {
      ret = (await this.cronapi.util.callServerBlockly('blockly.Util:deleteQuery', this.cronapi.json.getProperty(queryName, 'queryName')));
    }
  }
  this.cronapi.screen.changeValueOfField("list_querys", (await this.cronapi.util.callServerBlockly('blockly.Util:obterQuerys')));
}
