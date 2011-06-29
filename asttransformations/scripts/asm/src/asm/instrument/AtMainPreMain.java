package asm.instrument;

import java.lang.instrument.Instrumentation;

public class AtMainPreMain {

    public static void premain(String agentArguments, Instrumentation instrumentation) {
		instrumentation.addTransformer(new AtMainTransformer());
	}
}
