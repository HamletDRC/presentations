package asm.instrument;

import org.objectweb.asm.*;

public class AtMainBytecodeAdapter extends ClassAdapter {

    private boolean isAnnotated = false;
    private String currentClassName = null;
    private String annotatedMethodName = null;


    public AtMainBytecodeAdapter(ClassVisitor classVisitor) {
        super(classVisitor);
    }

    @Override
    public void visit(int i, int i1, String className, String s1, String s2, String[] strings) {
        currentClassName = className;
        super.visit(i, i1, className, s1, s2, strings);
    }

    @Override
    public MethodVisitor visitMethod(int i, final String methodName, String s1, String s2, String[] strings) {
        return new MethodAdapter(super.visitMethod(i, methodName, s1, s1, strings)) {
            @Override
            public AnnotationVisitor visitAnnotation(String s, boolean b) {
                if ("Lasm/Main;".equals(s)) {
                    isAnnotated = true;
                    annotatedMethodName = methodName;
                }
                return super.visitAnnotation(s, b);
            }

        };
    }

    @Override
    public void visitEnd() {
        if (isAnnotated) {
            isAnnotated = false; 
            MethodVisitor mv = cv.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            if (mv != null) {
                mv.visitCode();
                mv.visitTypeInsn(Opcodes.NEW, currentClassName);
                mv.visitInsn(Opcodes.DUP);
                mv.visitMethodInsn(Opcodes.INVOKESPECIAL, currentClassName, "<init>", "()V");
                mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, currentClassName, annotatedMethodName, "()V");
                mv.visitInsn(Opcodes.RETURN);
                mv.visitMaxs(2, 2);
                mv.visitEnd();
            }
        }
        super.visitEnd();
    }
}
