(function ($) {
    var contextPath = AJS.Meta.get("context-path"),
        atltoken = AJS.Meta.get('atl-token'),
        /**
         * Publishes every event that's queued in AJS.EventQueue.
         */
        bulkPublish = function() {
            var events = [],
                event,
                e, i, ii;
            if (AJS.EventQueue.length == 0)
                return;
            for (i = 0, ii = AJS.EventQueue.length; i < ii; ++i) {
                e = AJS.EventQueue[i];
                if (e.name) {
                    // the queue could contain anything - shear unusable properties
                    event = { name: e.name, properties: e.properties };
                    events.push(event);
                }
            }
            AJS.EventQueue.length = 0;
            // AJS.safe.post appears to corrupt a JSON data object, so we send it as a context param instead.
            // Failing to JSON encode the data results in jQuery not attempting to send, and silently swallowing our attempt
            $.ajax({
                type: "POST",
                url: contextPath + "/rest/internal/events/1/publish/bulk?atl_token=" + atltoken,
                data: $.toJSON(events),
                contentType: "application/json",
                dataType: "json"
            });
        };

    /**
     * Provides methods to help send browser events to the server side, for further processing there.
     * @class Events
     */
    AJS.Events = {
        /**
         * Publishes the given event to the server, eventually.
         * @function
         * @param {String} name the event name
         * @param {Object} properties the properties to send. Optional.
         */
        publish: function(name, properties) {
            AJS.EventQueue.push({name: name, properties: properties});
        }
    };

    /**
     * Provides a way to publish events asynchronously, without requiring AJS.Events to have loaded.
     * Users of this property must conditionally initialise it to an empty array. Objects pushed
     * must have a name property, and optionally a properties property of other data to send.
     * @example
     * AJS.EventQueue = AJS.EventQueue || [];
     * AJS.EventQueue.push({name: 'eventName', properties: {some: 'data', more: true, hits: 20}});
     * @field
     */
    AJS.EventQueue = AJS.EventQueue || [];

    AJS.toInit(function() {
        setInterval(bulkPublish, 5 * 1000);
    });
    $(window).unload(function() {
        bulkPublish();
    });
}(AJS.$));

