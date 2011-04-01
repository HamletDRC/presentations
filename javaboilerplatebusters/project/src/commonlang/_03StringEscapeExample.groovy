
@Grab(group='commons-lang', module='commons-lang', version='2.6')
@Grab(group='commons-lang', module='commons-lang', version='2.6', classifier='sources')
import org.apache.commons.lang.StringEscapeUtils


String xmlText = "\"Hello\" & \"GoodBye\"";
String escapedXml = "&quot;Hello&quot; &amp; &quot;GoodBye&quot;";

assert escapedXml == StringEscapeUtils.escapeXml(xmlText);
assert xmlText == StringEscapeUtils.unescapeXml(escapedXml);


def htmlText = "<body>text</body>"
def escapedHtml = "&lt;body&gt;text&lt;/body&gt;"

assert escapedHtml == StringEscapeUtils.escapeHtml(htmlText);
assert htmlText == StringEscapeUtils.unescapeHtml(escapedHtml);


def csvText = "red, beans, and rice"
def escapedCsv = "\"red, beans, and rice\""

assert escapedCsv == StringEscapeUtils.escapeCsv(csvText);
assert csvText == StringEscapeUtils.unescapeCsv(escapedCsv);


println "Success";