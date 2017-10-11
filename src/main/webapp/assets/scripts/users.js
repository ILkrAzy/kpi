'use strict';

Object.defineProperty(exports, "__esModule", {
    value: true
});
exports.default = {
    name: 'users'
};
if (module.exports.__esModule) module.exports = module.exports.default
;(typeof module.exports === "function"? module.exports.options: module.exports).template = "\n<div id=\"users\">\n    <!-- the router outlet, where all matched components would ber viewed -->\n    <h1>User</h1>\n</div>\n"
if (module.hot) {(function () {  module.hot.accept()
  var hotAPI = require("vue-hot-reload-api")
  hotAPI.install(require("vue"), true)
  if (!hotAPI.compatible) return
  if (!module.hot.data) {
    hotAPI.createRecord("_v-b715b6cc", module.exports)
  } else {
    hotAPI.update("_v-b715b6cc", module.exports, (typeof module.exports === "function" ? module.exports.options : module.exports).template)
  }
})()}