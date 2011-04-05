package commonlang;

import org.apache.commons.lang.BooleanUtils;

class _04BooleanExample {

    public static void main(String[] args) {
        assert BooleanUtils.toBoolean("true");
        assert BooleanUtils.toBoolean("TRUE");
        assert BooleanUtils.toBoolean("tRUe");
        assert BooleanUtils.toBoolean("on");
        assert BooleanUtils.toBoolean("ON");
        assert BooleanUtils.toBoolean("yes");
        assert BooleanUtils.toBoolean("YES");

        System.out.println("Success");
    }
}

