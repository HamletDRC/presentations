package commonlang;

import org.apache.commons.lang.StringEscapeUtils;

class _02StringEscapeExample {

    public static void main(String[] args) {
        String xmlText = "\"Hello\" & \"GoodBye\"";
        String escapedXml = "&quot;Hello&quot; &amp; "
                + "&quot;GoodBye&quot;";

        assert escapedXml.equals(
                StringEscapeUtils.escapeXml(xmlText)
        );
        assert xmlText.equals(
                StringEscapeUtils.unescapeXml(escapedXml)
        );


        String htmlText = "<body>text</body>";
        String escapedHtml = "&lt;body&gt;" +
                "text&lt;/body&gt;";

        assert escapedHtml.equals(
                StringEscapeUtils.escapeHtml(htmlText)
        );
        assert htmlText.equals(
                StringEscapeUtils.unescapeHtml(escapedHtml)
        );


        String csvText = "red, beans, and rice";
        String escapedCsv = "\"red, beans, and rice\"";

        assert escapedCsv.equals(
                StringEscapeUtils.escapeCsv(csvText)
        );
        assert csvText.equals(
                StringEscapeUtils.unescapeCsv(escapedCsv)
        );


        System.out.println("Success");
    }
}
