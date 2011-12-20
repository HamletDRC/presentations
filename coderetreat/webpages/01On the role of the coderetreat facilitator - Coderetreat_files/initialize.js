var deferredContent = function() {
  var script    = $('posterous_initialization_script');
  var postData  = (script.readAttribute('data-post-data'));
  var postsData = (script.readAttribute('data-posts-data'));
  var url       = script.readAttribute('data-posterous-deferred-content-url');

  data = {
    authenticity_token: window._token,
    referrer: window.location.href,
    url: url
  };
  
  if (postData !== null) {
    data["post"] = postData;
  }
  
  if (postsData !== null) {
    data["posts"] = postsData;
  }
  
  if (Modernizr.webworkers) {
    data["url"] = data["url"] + ".json";
    makeDeferredContentCallWithWebWorkers(data);
  } else {
    data["url"] = data["url"] + ".jsonp";
    makeDeferredContentCall(url, data, 0);
  }
};

var makeDeferredContentCallWithWebWorkers = function(data) {
  var worker = new Worker('/javascripts/controllers/sites/deferred_content_worker.js');
  worker.onmessage = function(e) {
    console.log(e.data);
    completeDeferredContent(JSON.parse(e.data));
  };
  worker.onerror = function(event){
      throw new Error(event.message + " (" + event.filename + ":" + event.lineno + ")");
  };
  worker.postMessage(JSON.stringify(data));
};

var completeDeferredContent = function(json) {
  if (window.p) {
    p.makeDeferredCallbacks(json);
  } else {
    document.observe('posterous:initialized', function() {
      p.makeDeferredCallbacks(json);
    });
  }
};

var makeDeferredContentCall = function(url, data, retries) {
  $j.jsonp({
    url: url,
    data: data,
    success: function(json) {
      completeDeferredContent(json);
    },
    error: function() {
      if (retries < 3) {
        retries++;
        deferredContent(url, data, retries);
      }
    }
  });
};

deferredContent();
