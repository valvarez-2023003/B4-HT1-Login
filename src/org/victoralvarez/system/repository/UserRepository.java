/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.victoralvarez.system.repository;
import java.sql.CallableStatement;
import org.victoralvarez.system.config.ConexionDB;
import org.victoralvarez.system.model.Users;

/**
 *
 * @author informatica
 */
public class UserRepository
        implements UserInterface {
    //CallableStatement
    private CallableStatement callSP;
    
    //ConexionDB
    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();
    @Override
    public void create(Users users) {
        try{
            callSP = conexionDB.getConnection().prepareCall("{call sp_create_users(?,?,?,?,?)}");
            
            callSP.setString(1, users.getName());
            callSP.setString(2, users.getLastname());
            callSP.setString(3, users.getEmail());
            callSP.setString(4, users.getUser());
            callSP.setString(5, users.getPassword());
            
            callSP.execute();
            
            callSP.close(); //Liberar los recursos
        } catch (Exception e){
            
        }
    }
}
