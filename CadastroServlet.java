import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");

        // Aqui você pode usar o código de cadastro de clientes em Java que já foi mostrado

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Confirmação de Cadastro</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Cadastro de Cliente</h1>");
        out.println("<p>Cliente cadastrado com sucesso!</p>");
        out.println("<p>Nome: " + nome + "</p>");
        out.println("<p>Endereço: " + endereco + "</p>");
        out.println("<p>Telefone: " + telefone + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
