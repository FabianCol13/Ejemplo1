/*
FabianCol
*/
package ejemplo1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejemplo1 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        String user = "root";
        String pass = "";
        String url = "jdbc:mysql://localhost:3306/demo";
        Connection conexion;
        Statement statement;
        ResultSet rs;
       try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
          //  Logger.getLogger(ConsultaUsuarios.class.getName()).log(Level.SEVERE, null, ex);

        }
       
        try {
            conexion = DriverManager.getConnection(url,user,pass);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO USUARIOS(nombreUsuario, passUsuario) VALUES ('SuperFabi2','SuperSegura123')");
            rs = statement.executeQuery("SELECT * FROM USUARIOS");
            rs.next();
            
            do{
                System.out.println(rs.getInt("idUsuario")+ " : " + rs.getString("nombreUsuario"));
            }while(rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(Ejemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    
}


        /*conexion = getConnection(url, user, pass);

        if (conexion != null) {

            System.out.println("Se establecio la conexión con la BD");
            //Create - Lllamar a la funcion para Crear un usuario
            int id = createUser(conexion, "SuperFabi-25", "SuperSegura123");
            System.out.println("Se crea un registro con ID: " + id);
            //Read - Llamar a la funcion para Leer o consultar usuarios de la BD
            readUsers(conexion);
            //Update - Llamar a la funcion para Modificar un usuario
            updateUser(conexion, id, "SuperFabi-25", "Super");
            System.out.println("Se actualizar el usuario con ID: " + id);
            //Delete - Llamar a la funcion para eliminar el usuario creado y modificado
            deleteUser(conexion, id);
            System.out.println("Se elimina el usuario with ID: " + id);
            //Se cierra la conexion BD
            conexion.close();
        } else {
            System.out.println("Fallo la conexion a la BD");
        }
    }

    public static Connection getConnection(String url, String user, String pass) {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Ejemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }

    public static int createUser(Connection conexion, String nombreUsuario, String passUsuario) {
        int id = 0;
        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO USUARIOS(nombreUsuario, passUsuario) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombreUsuario);
            ps.setString(2, passUsuario);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ejemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    public static void readUsers(Connection conexion) {
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM USUARIOS");
            while (rs.next()) {
                System.out.println(rs.getInt("idUsuario") + " : " + rs.getString("nombreUsuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ejemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateUser(Connection conexion, int id, String nombreUsuario, String passUsuario) {
        try {
            PreparedStatement ps = conexion.prepareStatement("UPDATE USUARIOS SET nombreUsuario = ?, passUsuario = ? WHERE idUsuario = ?");
            ps.setString(1, nombreUsuario);
            ps.setString(2, passUsuario);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ejemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteUser(Connection conexion, int id) {
        try {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM USUARIOS WHERE idUsuario = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ejemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
*/
