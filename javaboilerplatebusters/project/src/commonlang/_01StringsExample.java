package commonlang;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;

class _01StringsExample {

    public static void main(String[] args) {
        /* Stringly typed system support */

        assert StringUtils.isAlpha("abcde");
        assert StringUtils.isNumeric("12345");
        assert StringUtils.isAlphanumeric("12345abc");

        assert StringUtils.isBlank("");
        assert StringUtils.isBlank(null);


        assert StringUtils.isAllLowerCase("abcdef");
        assert StringUtils.isAllUpperCase("ABCDEF");

        assert "abc" == StringUtils.defaultString("abc");
        assert "" == StringUtils.defaultString("");
        assert "" == StringUtils.defaultString(null);


        assert "abc".equals(StringUtils.left("abcdef", 3));
        assert "def".equals(StringUtils.right("abcdef", 3));
        assert null == StringUtils.right(null, 3);

        Object[] array = new Object[]{1, 2, 3};
        assert "1, 2, 3".equals(StringUtils.join(array, ", "));

        List list = Arrays.asList(1, 2, 3);
        assert "1, 2, 3".equals(StringUtils.join(list, ", "));


        System.out.println("Success");
    }
}

