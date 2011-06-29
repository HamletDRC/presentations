package asm.instrument;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class AtMainTransformer implements ClassFileTransformer {
    public byte[] transform(ClassLoader loader, String className,
                            Class<?> clazz,
                            ProtectionDomain domain,
                            byte[] classBytes) {
        ClassReader cr = new ClassReader(classBytes);
        ClassWriter cw = new ClassWriter(cr, 0);
        AtMainBytecodeAdapter ca = new AtMainBytecodeAdapter(cw);
        cr.accept(ca, 0);
        return cw.toByteArray();
    }
}
