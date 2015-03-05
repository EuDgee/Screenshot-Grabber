

var system = require('system');
if (system.args.length >= 7) {
  var url = system.args[1];
  var id = system.args[2];
  var width = system.args[3];
  var height = system.args[4];
  var format = system.args[5];
  var folder = system.args.slice(6).join(' ');
  if (folder[-1] !== '/') {
    folder += '/';
  }

  var viewport = {
    'width': width,
    'height': height
  };
  var cliprect = {
    'top': 0,
    'left': 0,
    'width': width,
    'height': height
  };

  var page = require('webpage').create();
  page['viewportSize'] = viewport;
  page['clipRect'] = cliprect;
  page.open(url, function() {
    page.render(folder + id + '.' + format);
    phantom.exit();
  });
} else {
  console.log('Incorrect params, needs to be\n' +
      'url id width height format folder');
  phantom.exit();
}
