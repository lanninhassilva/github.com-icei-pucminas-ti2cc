package service;

import dao.ProdutoDAO;
import model.Produto;
import spark.Request;
import spark.Response;

import java.util.ArrayList;

public class ProdutoService {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

   
    public Object insert(Request req, Response res) {

        try {
            String nome = req.queryParams("nome");
            String precoStr = req.queryParams("preco");
            String descricao = req.queryParams("descricao");

            if(nome == null || nome.isEmpty() ||
               precoStr == null || precoStr.isEmpty() ||
               descricao == null || descricao.isEmpty()) {
                return "<h1>Erro: Todos os campos são obrigatórios!</h1><a href='/produto/form'>Voltar</a>";
            }

            // Limpa precoStr para deixar só números e ponto decimal
            precoStr = precoStr.replaceAll("[^0-9.]", "");

            float preco;
            try {
                preco = Float.parseFloat(precoStr);
            } catch (NumberFormatException e) {
                return "<h1>Erro: Preço inválido!</h1><a href='/produto/form'>Voltar</a>";
            }

            Produto produto = new Produto(0, nome, preco, descricao);

            boolean sucesso = produtoDAO.insert(produto);

            if(!sucesso){
                return "<h1>Erro ao salvar no banco!</h1><a href='/produto/form'>Voltar</a>";
            }

            res.redirect("/produto/list/1");
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return "<h1>Erro interno no servidor!</h1><a href='/produto/form'>Voltar</a>";
        }
    }
    
    public Object get(Request req, Response res) {

        ArrayList<Produto> lista = produtoDAO.get();

        String html = "<html><head><meta charset='UTF-8'><title>Lista</title>";

        html += "<style>";
        html += "body{background:#ffe6f0;font-family:Arial;text-align:center;}";
        html += "h1{color:#cc0066;}";
        html += ".card{background:white;margin:15px auto;padding:15px;width:300px;border-radius:10px;box-shadow:0 0 8px rgba(0,0,0,0.1);}";
        html += "a{display:inline-block;margin-top:20px;padding:10px 20px;background:#ff66b3;color:white;text-decoration:none;border-radius:10px;}";
        html += "</style>";

        html += "</head><body>";

        html += "<h1>🌸 Lista de Produtos 🌸</h1>";

        for (Produto p : lista) {
            html += "<div class='card'>";
            html += "<b>" + p.getNome() + "</b><br>";
            html += "💲 " + p.getPreco() + "<br>";
            html += p.getDescricao();
            html += "</div>";
        }

        html += "<a href='/'>Voltar</a>";

        html += "</body></html>";

        return html;
    }

    public Object delete(Request req, Response res) {
        return "delete não implementado";
    }

    public Object update(Request req, Response res) {
        return "update não implementado";
    }

    public String form() {

        return "<form action='/produto/insert' method='post'>"
                + "Nome: <input name='nome'><br>"
                + "Preço: <input name='preco'><br>"
                + "Descrição: <input name='descricao'><br>"
                + "<input type='submit'>"
                + "</form>";
    }
}