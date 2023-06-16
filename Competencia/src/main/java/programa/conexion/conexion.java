/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programa.conexion;

import java.sql.*;
public class conexion {
    
/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Connection conexion = null;
        Statement sentencia = null;
        try {
            // Paso 1: Cargar el driver:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Paso 2:
            String url = "jdbc:sqlserver://localhost:1433;databaseName=CompetenciaTirosAlAro;TrustServerCertificate=True;";
            //String url = "jdbc:sqlserver://localhost:1433;databaseName=mysql;TrustServerCertificate=True;";
            conexion = DriverManager.getConnection(url, "sa", "12345678");
            // Paso 3: Crear una sentencia: 
            sentencia = conexion.createStatement();
            
            /* Paso 4: Ejecutar una consulta:
            String consulta = "select * from Participantes";
            ResultSet resultado = sentencia.executeQuery(consulta);

             Paso 5: Manipilar los resultados:
            System.out.println("El resultado de la consulta es:");
            System.out.printf("%-30s %-30s %s%n", "Nombre", "Apellido", "Salario");
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                double salario = resultado.getDouble("salario");
                System.out.printf("%-30s %-30s %7.2f%n", nombre, apellido, salario);
            }*/
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: no se encuentra el archivo de la");
            System.out.println("clase para la conexión con la base de datos.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Error de conexión a la base de datos.");
            ex.printStackTrace();
        } finally {
            try {
                sentencia.close();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error en cierre de conexión.");
            }

        }
    }
    
}
