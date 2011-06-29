package asm.instrument;

import java.lang.instrument.Instrumentation;

public class AtMainPreMain {

    public static void premain(String agentArgs, Instrumentation in) {
		in.addTransformer(new AtMainTransformer());
	}
}
