/*jslint evil:true */
/**
 * Dynamic thread loader
 *
 * 
 * 
 * 
 * 
 * 
*/

// 
var DISQUS;
if (!DISQUS || typeof DISQUS == 'function') {
    throw "DISQUS object is not initialized";
}
// 

// json_data and default_json django template variables will close
// and re-open javascript comment tags

(function () {
    var jsonData, cookieMessages, session, key;

    /* */ jsonData = {"reactions": [], "reactions_limit": 10, "ordered_highlighted": [], "posts": {"374468321": {"edited": false, "author_is_moderator": false, "from_request_user": null, "up_voted": false, "can_edit": false, "ip": "", "last_modified_date": null, "dislikes": 0, "raw_message": "I'm super sorry I was only once present and every subsequent\u00a0occasion\u00a0I had plans. Same now. Have fun!", "has_replies": false, "vote": false, "votable": true, "last_modified_by": null, "real_date": "2011-11-28_16:50:52", "date": "20 hours ago", "message": "I'm super sorry I was only once present and every subsequent\u00a0occasion\u00a0I had plans. Same now. Have fun!", "approved": true, "is_last_child": false, "author_is_founder": false, "can_reply": true, "likes": 0, "user_voted": null, "num_replies": 0, "down_voted": false, "is_first_child": false, "has_been_anonymized": false, "highlighted": false, "parent_post_id": null, "depth": 0, "points": 0, "user_key": "836e3fd2a7138ca0ac5ca2fa408391b4", "author_is_creator": false, "email": "", "killed": false, "is_realtime": false}}, "ordered_posts": [374468321], "realtime_enabled": false, "ready": true, "mediaembed": [], "has_more_reactions": false, "realtime_paused": true, "integration": {"receiver_url": "", "hide_user_votes": false, "reply_position": false, "disqus_logo": false}, "highlighted": {}, "reactions_start": 0, "media_url": "http://mediacdn.disqus.com/1322011329", "users": {"836e3fd2a7138ca0ac5ca2fa408391b4": {"username": "Lucian", "tumblr": "", "about": "", "display_name": "Lucian", "url": "http://disqus.com/guest/836e3fd2a7138ca0ac5ca2fa408391b4/", "registered": false, "remote_id": null, "linkedin": "", "blog": "", "remote_domain": "", "points": null, "facebook": "", "avatar": "http://mediacdn.disqus.com/1322011329/images/noavatar32.png", "delicious": "", "is_remote": false, "verified": false, "flickr": "", "twitter": "", "remote_domain_name": ""}}, "user_unapproved": {}, "messagesx": {"count": 0, "unread": []}, "thread": {"voters_count": 0, "offset_posts": 0, "slug": "unit_testing_automatic_testing_tdd_pros_and_cons", "paginate": false, "num_pages": 1, "days_alive": 0, "moderate_none": false, "voters": {}, "total_posts": 1, "realtime_paused": false, "queued": false, "pagination_type": "append", "user_vote": null, "likes": 1, "num_posts": 1, "closed": false, "per_page": 0, "id": 274433477, "killed": false, "moderate_all": false}, "forum": {"use_media": true, "avatar_size": 32, "apiKey": "GDiWGQGOVPHmaNuii958vlqPTYcEsRfUmxuJWabOkXR45g9Ju11Cs9CGywStErdC", "features": {}, "use_old_templates": false, "comment_max_words": 0, "mobile_theme_disabled": false, "linkbacks_enabled": true, "is_early_adopter": false, "allow_anon_votes": true, "revert_new_login_flow": false, "stylesUrl": "http://mediacdn.disqus.com/uploads/styles/74/8347/alexbolboaca.css", "login_buttons_enabled": false, "streaming_realtime": false, "show_avatar": true, "reactions_enabled": true, "reply_position": false, "id": 748347, "name": "alexbolboaca.ro", "language": "en", "mentions_enabled": true, "url": "alexbolboaca", "allow_anon_post": true, "disqus_auth_disabled": false, "thread_votes_disabled": false, "default_avatar_url": "http://mediacdn.disqus.com/1322011329/images/noavatar32.png", "ranks_enabled": false, "template": {"url": "http://mediacdn.disqus.com/1322011329/build/themes/t_b3e3e393c77e35a4a3f3cbd1e429b5dc.js?1", "mobile": {"url": "http://mediacdn.disqus.com/1322011329/build/themes/newmobile.js", "css": "http://mediacdn.disqus.com/1322011329/build/themes/newmobile.css"}, "api": "1.1", "name": "Houdini", "css": "http://mediacdn.disqus.com/1322011329/build/themes/t_b3e3e393c77e35a4a3f3cbd1e429b5dc.css?1"}, "hasCustomStyles": false, "max_depth": 0, "lastUpdate": "", "moderate_all": false}, "settings": {"realtimeHost": "qq.disqus.com", "uploads_url": "http://media.disqus.com/uploads", "ssl_media_url": "https://securecdn.disqus.com/1322011329", "realtime_url": "http://rt.disqus.com/forums/realtime-cached.js", "facebook_app_id": "52254943976", "minify_js": true, "recaptcha_public_key": "6LdKMrwSAAAAAPPLVhQE9LPRW4LUSZb810_iaa8u", "read_only": false, "facebook_api_key": "4aaa6c7038653ad2e4dbeba175a679ba", "realtimePort": "80", "debug": false, "disqus_url": "http://disqus.com", "media_url": "http://mediacdn.disqus.com/1322011329"}, "ranks": {}, "request": {"sort": "hot", "is_authenticated": false, "user_type": "anon", "subscribe_on_post": 0, "missing_perm": null, "user_id": null, "remote_domain_name": "", "remote_domain": "", "is_verified": false, "profile_url": "", "username": "", "is_global_moderator": false, "sharing": {}, "timestamp": "2011-11-29_13:19:11", "is_moderator": false, "ordered_unapproved_posts": [], "unapproved_posts": {}, "forum": "alexbolboaca", "is_initial_load": true, "display_username": "", "points": null, "has_email": false, "moderator_can_edit": false, "is_remote": false, "userkey": "", "page": 1}, "context": {"use_twitter_signin": false, "use_fb_connect": false, "show_reply": true, "active_switches": ["autocommitted_thread", "bespin", "community_icon", "embedapi", "google_auth", "mentions", "new_facebook_auth", "new_thread_create", "realtime_cached", "show_captcha_on_links", "ssl", "static_reply_frame", "static_styles", "statsd_created", "upload_media", "use_rs_paginator_60m"], "sigma_chance": 10, "use_google_signin": false, "switches": {"olark_admin_addons": true, "listactivity_replies": true, "es_index_threads": true, "use_master_for_api": true, "google_auth": true, "html_email": true, "statsd.timings": true, "community_icon": true, "show_captcha_on_links": true, "send_to_akismet": true, "olark_admin_packages": true, "static_styles": true, "stats": true, "realtime": true, "realtime_cached": true, "statsd_created": true, "bespin": true, "olark_support": true, "olark_addons": true, "new_facebook_auth": true, "limit_get_posts_days_30d": true, "edits_to_spam": true, "use_akismet": true, "new_thread_create": true, "use_impermium": true, "upload_media": true, "vip_read_slave": true, "embedapi": true, "train_akismet": true, "ssl": true, "autocommitted_thread": true, "send_to_impermium": true, "theme_editor_disabled": true, "train_impermium": true, "listactivity_replies_30d": true, "moderate_ascending": true, "new_moderate": true, "use_rs_paginator_60m": true, "redis_threadcount": true, "mentions": true, "olark_install": true, "static_reply_frame": true}, "forum_facebook_key": "", "use_yahoo": false, "subscribed": false, "active_gargoyle_switches": ["edits_to_spam", "es_index_threads", "html_email", "limit_get_posts_days_30d", "listactivity_replies", "listactivity_replies_30d", "moderate_ascending", "new_moderate", "olark_addons", "olark_admin_addons", "olark_admin_packages", "olark_install", "olark_support", "realtime", "redis_threadcount", "send_to_akismet", "send_to_impermium", "show_captcha_on_links", "stats", "statsd.timings", "theme_editor_disabled", "train_akismet", "train_impermium", "use_akismet", "use_impermium", "use_master_for_api", "vip_read_slave"], "realtime_speed": 15000, "use_openid": false}}; /* */
    /* */ cookieMessages = {"user_created": null, "post_has_profile": null, "post_twitter": null, "post_not_approved": null}; session = {"url": null, "name": null, "email": null}; /* */

    DISQUS.jsonData = jsonData;
    DISQUS.jsonData.cookie_messages = cookieMessages;
    DISQUS.jsonData.session = session;

    if (DISQUS.useSSL) {
        DISQUS.useSSL(DISQUS.jsonData.settings);
    }

    // The mappings below are for backwards compatibility--before we port all the code that
    // accesses jsonData.settings to DISQUS.settings

    var mappings = {
        debug:                'disqus.debug',
        minify_js:            'disqus.minified',
        read_only:            'disqus.readonly',
        recaptcha_public_key: 'disqus.recaptcha.key',
        facebook_app_id:      'disqus.facebook.appId',
        facebook_api_key:     'disqus.facebook.apiKey'
    };

    var urlMappings = {
        disqus_url:    'disqus.urls.main',
        media_url:     'disqus.urls.media',
        ssl_media_url: 'disqus.urls.sslMedia',
        realtime_url:  'disqus.urls.realtime',
        uploads_url:   'disqus.urls.uploads'
    };

    if (DISQUS.jsonData.context.switches.realtime_setting_change) {
        urlMappings.realtimeHost = 'realtime.host';
        urlMappings.realtimePort = 'realtime.port';
    }
    for (key in mappings) {
        if (mappings.hasOwnProperty(key)) {
            DISQUS.settings.set(mappings[key], DISQUS.jsonData.settings[key]);
        }
    }

    for (key in urlMappings) {
        if (urlMappings.hasOwnProperty(key)) {
            DISQUS.jsonData.settings[key] = DISQUS.settings.get(urlMappings[key]);
        }
    }
}());

DISQUS.jsonData.context.csrf_token = '21bc467119200cb06806902fa8e2f5b0';

DISQUS.jsonData.urls = {
    login: 'http://disqus.com/profile/login/',
    logout: 'http://disqus.com/logout/',
    upload_remove: 'http://alexbolboaca.disqus.com/thread/unit_testing_automatic_testing_tdd_pros_and_cons/async_media_remove/',
    request_user_profile: 'http://disqus.com/AnonymousUser/',
    request_user_avatar: 'http://mediacdn.disqus.com/1322011329/images/noavatar92.png',
    verify_email: 'http://disqus.com/verify/',
    remote_settings: 'http://alexbolboaca.disqus.com/_auth/embed/remote_settings/',
    edit_profile_window: 'http://disqus.com/embed/profile/edit/',
    embed_thread: 'http://alexbolboaca.disqus.com/thread.js',
    embed_vote: 'http://alexbolboaca.disqus.com/vote.js',
    embed_thread_vote: 'http://alexbolboaca.disqus.com/thread_vote.js',
    embed_thread_share: 'http://alexbolboaca.disqus.com/thread_share.js',
    embed_queueurl: 'http://alexbolboaca.disqus.com/queueurl.js',
    embed_hidereaction: 'http://alexbolboaca.disqus.com/hidereaction.js',
    embed_more_reactions: 'http://alexbolboaca.disqus.com/more_reactions.js',
    embed_subscribe: 'http://alexbolboaca.disqus.com/subscribe.js',
    embed_highlight: 'http://alexbolboaca.disqus.com/highlight.js',
    embed_block: 'http://alexbolboaca.disqus.com/block.js',
    update_moderate_all: 'http://alexbolboaca.disqus.com/update_moderate_all.js',
    update_days_alive: 'http://alexbolboaca.disqus.com/update_days_alive.js',
    show_user_votes: 'http://alexbolboaca.disqus.com/show_user_votes.js',
    forum_view: 'http://alexbolboaca.disqus.com/unit_testing_automatic_testing_tdd_pros_and_cons',
    cnn_saml_try: 'http://disqus.com/saml/cnn/try/',
    realtime: DISQUS.jsonData.settings.realtime_url,
    thread_view: 'http://alexbolboaca.disqus.com/thread/unit_testing_automatic_testing_tdd_pros_and_cons/',
    twitter_connect: DISQUS.jsonData.settings.disqus_url + '/_ax/twitter/begin/',
    yahoo_connect: DISQUS.jsonData.settings.disqus_url + '/_ax/yahoo/begin/',
    openid_connect: DISQUS.jsonData.settings.disqus_url + '/_ax/openid/begin/',
    googleConnect: DISQUS.jsonData.settings.disqus_url + '/_ax/google/begin/',
    community: 'http://alexbolboaca.disqus.com/community.html',
    admin: 'http://alexbolboaca.disqus.com/admin/moderate/',
    moderate: 'http://alexbolboaca.disqus.com/admin/moderate/',
    moderate_threads: 'http://alexbolboaca.disqus.com/admin/moderate-threads/',
    settings: 'http://alexbolboaca.disqus.com/admin/settings/',
    unmerged_profiles: 'http://disqus.com/embed/profile/unmerged_profiles/',

    channels: {
        def:      'http://disqus.com/default.html', /* default channel */
        auth:     'https://disqus.com/embed/login.html',
        tweetbox: 'http://disqus.com/forums/integrations/twitter/tweetbox.html?f=alexbolboaca',
        edit:     'http://alexbolboaca.disqus.com/embed/editcomment.html'
    }
};


// 
//     
DISQUS.jsonData.urls.channels.reply = 'http://mediacdn.disqus.com/1322011329/build/system/reply.html';
DISQUS.jsonData.urls.channels.upload = 'http://mediacdn.disqus.com/1322011329/build/system/upload.html';
DISQUS.jsonData.urls.channels.sso = 'http://mediacdn.disqus.com/1322011329/build/system/sso.html';
DISQUS.jsonData.urls.channels.facebook = 'http://mediacdn.disqus.com/1322011329/build/system/facebook.html';
//     
// 