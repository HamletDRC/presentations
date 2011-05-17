package astbuilder

import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ReturnStatement
import org.codehaus.groovy.ast.expr.ConstructorCallExpression


def ast = new AstBuilder().buildFromCode {
    new Date()
}

assert ast[0] instanceof BlockStatement
assert ast[0].statements[0] instanceof ReturnStatement
assert ast[0].statements[0].expression instanceof ConstructorCallExpression