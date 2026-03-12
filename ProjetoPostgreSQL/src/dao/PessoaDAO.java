package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexao.Conexao;
import model.Pessoa;

public class PessoaDAO {

    public void inserir(Pessoa p) {

        String sql = "INSERT INTO pessoa(nome, idade) VALUES (?,?)";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getIdade());

            stmt.execute();

            System.out.println("Pessoa inserida!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listar() {

        String sql = "SELECT * FROM pessoa";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " - " +
                        rs.getString("nome") + " - " +
                        rs.getInt("idade")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {

        String sql = "DELETE FROM pessoa WHERE id=?";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();

            System.out.println("Pessoa removida!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Pessoa p) {

        String sql = "UPDATE pessoa SET nome=?, idade=? WHERE id=?";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getIdade());
            stmt.setInt(3, p.getId());

            stmt.execute();

            System.out.println("Pessoa atualizada!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}