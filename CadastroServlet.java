package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Configurações do banco de dados
    private static final String DB_URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String DB_USER = "seu_usuario";
    private static final String DB_PASSWORD = "sua_senha";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");

        // Conexão com o banco de dados
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // SQL para inserir o cliente no banco de dados
            String sql = "INSERT INTO clientes (nome, endereco, telefone) VALUES (?, ?, ?)";
            
            // Criação da declaração preparada
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, nome);
                statement.setString(2, endereco);
                statement.setString(3, telefone);

                // Execução da inserção
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
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
                } else {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Falha ao cadastrar o cliente.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao conectar ao banco de dados.");
        }
    }
}
