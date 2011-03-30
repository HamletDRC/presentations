package dataflow;


import org.intellij.lang.annotations.Language;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FloatingPointCalculatorServlet extends HttpServlet {

    private final CalculatorFacade calculator = new CalculatorFacade();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String left = req.getParameter("param1");
        String right = req.getParameter("param2");
        String operation = req.getParameter("operation");

        int result = calculator.calculate(operation, left, right);

        @Language("HTML")
        String markup = "<html><body><p>Result: %d</p></body></html>";


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(String.format(markup, result));
        out.close();
    }

}
