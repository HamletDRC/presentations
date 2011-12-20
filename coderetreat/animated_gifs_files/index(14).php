/**
 * to benefit of [[:Template:Multilingual description]]
 *
 * Implements language selection for multilingual elements
 *
 * In certain environments, it's not feasible to neatly box away each
 * different language into its own section of the site. By marking elements
 * multilingual, you can emulate this behavior by only displaying the
 * message in the user's language. This reduces the "Tower of Babel" effect.
 *
 * @author Edward Z. Yang (Ambush Commander), Rewritten by DieBuche
 */
 
/* Configuration: */
 
// in your monobook.js, set ls_enable = false to stop the javascript
// the cookie name we use to stash the info.
var multilingual =
{
 cookie: 'commonswiki_language_js',
 
 // link to the language select page
 helpUrl: '//meta.wikimedia.org/wiki/Meta:Language_select',
 
 // strings that are part of the widgets
 stringHelp: {
  'be-tarask' : 'Выбар мовы',
  'be-x-old'  : 'Выбар мовы',
  'cs': 'Výběr jazyka:',
  'da': 'Vælg sprog:',
  'de': 'Sprachauswahl:',
  'en': 'Language select:',
  'eo': 'Lingvoelekto:',
  'fr': 'Sélecteur de langue:',
  'hu': 'Nyelvválasztás:',
  'ko': '언어 선택:',
  'mk': 'Јазик:',
  'ml': 'ഭാഷ തിരഞ്ഞെടുക്കുക:',
  'nds': 'Spraakutwahl:',
  'nl': 'Taal:',
  'pl': 'Wybierz język:',
  'pt': 'Seleção do idioma:',
  'pt-br': 'Seleção do idioma:',
  'ru': 'Выбор языка:',
  'sv': 'Välj språk:'
 },
 stringSelect: {
  'be-tarask' : 'Выбраць',
  'be-x-old'  : 'Выбраць',
  'cs': 'Vybrat',
  'da': 'Vælg',
  'de': 'Auswahl',
  'en': 'Select',
  'eo': 'Elekti',
  'fr': 'Seulement cette langue',
  'hu': 'Választás',
  'ko': '선택',
  'mk': 'Одбери',
  'ml': 'തിരഞ്ഞെടുക്കുക',
  'nds': 'Utwählen',
  'nl': 'Selecteer',
  'pl': 'Wybierz',
  'pt': 'Selecionar',
  'pt-br': 'Selecionar',
  'ru': 'Выбрать',
  'sv': 'Välj'
 },
 stringShowAll: {
  'be-tarask' : 'Паказаць усе',
  'be-x-old'  : 'Паказаць усе',
  'cs': 'Zobrazit všechny',
  'da': 'Vis alle',
  'de': 'Alle anzeigen',
  'en': 'Show all',
  'eo': 'ĉiuj',
  'fr': 'Toutes les langues',
  'hu': 'Mutasd mind',
  'ko': '모두 보기',
  'mk': 'Сите',
  'ml': 'എല്ലാം',
  'nds': 'All wiesen',
  'nl': 'Toon alles',
  'pl': 'Pokaż wszystkie',
  'pt': 'Mostrar todos',
  'pt-br': 'Mostrar todos',
  'ru': 'Показать все',
  'sv': 'Visa alla'
 },
 
 
 // autodetects a browser language
 getBrowserLanguage: function () {
  return navigator.userLanguage || navigator.language || navigator.browserLanguage;
 },
 
 // sets a new language to the cookie
 setCookieLanguage: function (language) {
  $.cookie(this.cookie, escape(language), {
   expires: 100,
   path: '/'
  });
 },
 
 // deletes the cookie
 deleteCookieLanguage: function (language) {
  $.cookie(this.cookie, null, {
   path: '/'
  });
 },
 // grabs the ISO 639 language code based
 // on either the browser or a supplied cookie
 getLanguage: function () {
  var language = '';
 
  // Priority:
  //  1. Cookie
  //  2. wgUserLanguage global variable
  //  3. Browser autodetection
  // grab according to cookie
  language = $.cookie(this.cookie);
 
  // grab according to wgUserLanguage if user is logged in
  if (!language && window.wgUserLanguage && wgUserGroups !== null) {
   language = wgUserLanguage;
  }
 
  // grab according to browser if none defined
  if (!language) language = this.getBrowserLanguage();
 
  // inflexible: can't accept multiple languages
  // remove dialect/region code, leaving only the ISO 639 code
  // language = language.replace(/(-.*)+/, '');
 
  return language;
 },
 
 // build widget for changing the language cookie
 buildWidget: function (language) {
 
  this.$container = $('<div/>');
  // link to language select description page
  this.$container.html('<a href="' + this.helpUrl + '" class="ls_link">' + this.stringHelpText + '</a> ');
  this.$select = $('<select/>');
 
 
  var seen = {};
  $('[lang]').each(function () {
   var lang = $(this).attr('lang');
   if (!seen[lang]) {
    seen[lang] = true;
    multilingual.$select.append('<option>' + lang + '</option>');
   }
  });
  this.$select.prepend('<option value="showall">' + this.stringShowallText + '</option>');
  this.$select.attr('id', 'langselector');
  this.$select.val(this.getLanguage());
  this.$select.change(function () {
   multilingual.setCookieLanguage($('#langselector').val());
   multilingual.apply($('#langselector').val());
  });
  this.$container.append(this.$select);
  if ($('#file').length) $('#file').append(this.$container);
  else $('#bodyContent').prepend(this.$container);
 },
 
 // main body of the function
 init: function () {
  if (typeof ls_enable !== 'undefined') return;
 
  this.stringHelpText = (this.stringHelp[wgUserLanguage] || this.stringHelp.en);
  this.stringShowallText = (this.stringShowAll[wgUserLanguage] || this.stringShowAll.en);
 
  //disabling the gadget on special pages
  if (wgCanonicalNamespace == "Special") return;
 
  // only activated in view , purge, historysubmit or submit mode
  if (!((wgAction == 'view') || (wgAction == 'purge') || (wgAction == 'edit') || (wgAction == 'historysubmit') || (wgAction == 'submit'))) return;
  
  //try to find loose {{en|...}} and wrap them in a .multilingual
  //Select all div.description[lang] which have at least one of their kind preceding them.
  $('div.description[lang]+div.description[lang]').each(function() {
    var $this = $(this);
    //Already in a multiling, nothing to do here;
    if ($this.parent().hasClass('multilingual')) return;
    var group = $(this).prevUntil(':not(div.description[lang])').add($(this)).add($(this).nextUntil(':not(div.description[lang])'));
    //Check length
    if( group.length < 4 ) {
      return true;
    }
    group.wrapAll('<div class="multilingual"></div>');
  });

  // grab an array of multilingual elements
  this.mls = $('.multilingual');
   
  // Only build form if there are MLDs on page.
  if (!this.mls.length) return;
 
  this.buildWidget();
  this.apply(this.getLanguage());
 },
 
 apply: function (language) {
  // if language is blank, delete the cookie and then recalculate
  if (!language) {
    this.deleteCookieLanguage();
    language = this.getLanguage();
  }
 
   this.mls.each(function () {
     // Cache selector
     var $ml = $(this);
 
     if ( $ml.parent('[class^="image_annotation_content"]').length ) return true;
  
     var id = $ml.attr('id');
     if ( id === 'bodyContent' || id === 'wikiPreview' || id === 'LangTableLangs') return true;
 
     var $reqLang = $ml.find('[lang="' + language + '"]');
 
     if ( $reqLang.length ) {
       $ml.children('[lang][lang!="' + language + '"]').hide();
       $ml.children('[lang="' + language + '"]').show();
     } else {
       $ml.children('[lang]').show();
     }
   });
 }
};
 
 
mw.loader.using('jquery.cookie', function() {
  // register as onDOMContentReady function
  $(document).ready(function () {
    multilingual.init();
  });
});