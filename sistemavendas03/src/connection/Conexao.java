/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import com.sun.jdi.connect.spi.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author 007
 */
public class Conexao {
private static final String driver = "com.mysql.cj.jdbc.Driver";
         private static final String servidor = "localhost:3306";
         private static final String banco = "vendas";
         private static final String timezone = "?useTimezone=true&serverTimezone=UTC";
         private static final String url = "jdbc:mysql://" + servidor + "/" + banco + timezone;
         private static final String usuario = "sistemavendas";
         private static final String senha = "s1st3m4V&ND@$";

         public static Connection getConexao() {
               Connection connection = null;
               try {
                    Class.forName(driver);
                    connection = (Connection) DriverManager.getConnection(url, usuario, senha);
                    return connection;
              } catch (ClassNotFoundException | SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao abrir conexão.", "Erro",
                                     JOptionPane.WARNING_MESSAGE);
                    return connection;
              }
         }

         public static void fecharConexao(Connection c) {
                 if (c != null) {
                      try {
                            c.close();
                      } catch (SQLException e) {
                           JOptionPane.showMessageDialog(null, "Erro ao fechar conexão.", "Erro",
                                               JOptionPane.WARNING_MESSAGE);
                      }
               }
         }

        public static void fecharConexao(Connection c, PreparedStatement ps) {
               fecharConexao(c);
               if (ps != null) {
                   try {
                         ps.close();
                   } catch (SQLException e) {
                       JOptionPane.showMessageDialog(null, "Erro ao fechar conexão.", "Erro",
                                          JOptionPane.WARNING_MESSAGE);
                   }
             }
      }

      public static void fecharConexao(Connection c, PreparedStatement ps, ResultSet rs) {
              fecharConexao(c,ps);
              if (rs != null) {
                   try {
                        rs.close();
                   } catch (SQLException e) {
                       JOptionPane.showMessageDialog(null, "Erro ao fechar conexão.", "Erro",
                                            JOptionPane.WARNING_MESSAGE);
                  }
          }
    }    
}
