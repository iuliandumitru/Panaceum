package com.unlimited.panaceum.ir;

import com.unlimited.panaceum.utils.XmlFormatter;
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import javax.lang.model.type.TypeVisitor;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * @author Iulian Dumitru
 */
public class TestParser {

    private static final StringBuilder XML = new StringBuilder();

    public static void main(String[] args) throws Exception {

        CompilationUnit cu;
        try (InputStream in = TestParser.class.getResourceAsStream("/Test.txt")) {
            cu = JavaParser.parse(in);
        }


//        new CompilationUnitVisitor().visit(cu, null);
        new TypeVisitor().visit(cu, null);
        new MethodVisitor().visit(cu, null);

        XML.append("</class>");


        System.out.println(XML);

//        String formattedXML = XmlFormatter.format(XML.toString());
//        System.out.println(formattedXML);


    }

    /**
     * Simple visitor implementation for visiting MethodDeclaration nodes.
     */
    private static class MethodVisitor extends VoidVisitorAdapter {

        @Override
        public void visit(MethodDeclaration methodDeclaration, Object arg) {

            List<Parameter> parameters = methodDeclaration.getParameters();

            int modifiers = methodDeclaration.getModifiers();
            boolean isPublic = Modifier.isPublic(modifiers);
            boolean isPrivate = Modifier.isPrivate(modifiers);

            String modifier = "";
            if (isPublic) {
                modifier = "public";
            } else if (isPrivate) {
                modifier = "private";
            }

            XML.append("<method name='" + methodDeclaration.getName() + "' modifier='" + modifier + "' >");
            if (parameters != null) {
                XML.append("<parameters>");
                for (Parameter parameter : parameters) {
                    XML.append("<parameter name='" + parameter.getId().getName() + "'/>");
                }
                XML.append("</parameters>");
            }

            XML.append("<body>");

            BlockStmt body = methodDeclaration.getBody();
            List<Statement> stmts = body.getStmts();
            for (Statement stmt : stmts) {
                stmt.accept(new VoidVisitorAdapter<Object>() {
                    @Override
                    public void visit(ExpressionStmt expressionStmt, Object arg) {

                        Expression expression = expressionStmt.getExpression();

                        XML.append("<expression>" + expression + "</expression>");

                    }
                }, null);
            }

            XML.append("</body>");

            XML.append("</method>");

        }
    }


    private static class TypeVisitor extends VoidVisitorAdapter {
        @Override
        public void visit(ClassOrInterfaceDeclaration n, Object arg) {
            XML.append("<class name='" + n.getName() + "'>");
        }

    }

    private static class CompilationUnitVisitor extends VoidVisitorAdapter {

        @Override
        public void visit(CompilationUnit n, Object arg) {
            XML.append("<package>" + n.getPackage().getName() + "</package>");
        }

    }

}
