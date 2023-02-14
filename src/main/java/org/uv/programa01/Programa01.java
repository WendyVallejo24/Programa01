/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.uv.programa01;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wendy Vallejo
 */
public class Programa01 {
        
    public static void main(String[] args) {
                
        Connection bd = null;
        Statement st = null;
        
        try{
            
            String sql = "INSERT INTO empleado (clave, nombre, direccion, telefono) values" 
                    + "('01', 'Wendy', 'U.H. El Trebol', '2721986855')";
            
            String url = "jdbc:postgresql://127.0.0.1:5432/ejemplo";
            String user = "postgres";
            String pass = "123456";
            
            bd = DriverManager.getConnection(url, user, pass);
            st = bd.createStatement();
            st.execute(sql);
            
            Logger.getLogger(Programa01.class.getName()).log(Level.INFO, "Se conectó a la BD");
            
        }
       
        catch(SQLException ex){
            Logger.getLogger(Programa01.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                if(bd!=null)
                    bd.close();
            } catch (SQLException ex) {
                Logger.getLogger(Programa01.class.getName()).log(Level.SEVERE, null, ex);
            }
            try{
                if(st != null)
                    st.close();
            } catch (SQLException ex){
                Logger.getLogger(Programa01.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}



