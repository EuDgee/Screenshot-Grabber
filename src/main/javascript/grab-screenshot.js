

var system = require('system');

if (system.args.length >= 3) {
  var address = system.args[1];
  var id = system.args[2];

  var page = require('webpage').create();
  var size = require('../resources/size.json');
  page.viewportSize = size['viewport'];
  page.clipRect = size['cliprect'];
  page.open(address, function() {
    page.render(id + '.jpg');
    phantom.exit();
  });
}
