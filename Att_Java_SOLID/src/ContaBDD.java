import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ContaBDD
{
    private static final String USUARIO = "root";
    private static final String SENHA = "1234";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/banco_muita_grana";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public void salvar(Conta conta)
    {
        try
        {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);

            String query = "INSERT INTO CONTA (codigo, nome, saldo) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, conta.getCodigo());
            stmt.setString(2, conta.getNome());
            stmt.setDouble(3, conta.getSaldo());

            stmt.executeUpdate();
            stmt.close();
            System.out.println("Conta cadastrada.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}