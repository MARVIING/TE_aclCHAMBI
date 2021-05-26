
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class validar extends ConexionBD {
    Connection con=this.conectar();
    PreparedStatement pr;
    
    public boolean checkUser(String correo, String clave){
        boolean resultado=false;
        try {
            
            String sql="select * from usuarios where correo=? and clave =md5(?) ";
            pr=con.prepareStatement(sql);
            pr.setString(1,correo);
            pr.setString(2, clave);
            ResultSet rs = pr.executeQuery();
            resultado=rs.next();
           
        } catch (SQLException ex) {
            System.out.println("ERROR AL AUTENTICA");
        }
         return resultado;
    }
}
