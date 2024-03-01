package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Clientes;

public class ClientesDAO extends DAO {
    
    public ClientesDAO() {
        super();
        conectar();
    }
    
    public void finalize() {
        close();
    }
    
    public boolean insert(Clientes cliente) {
        boolean status = false;
        try {  
            Statement st = conexao.createStatement();
            String sql = "INSERT INTO Clientes (id, nome, cpf, sexo) "
                       + "VALUES ("+cliente.getCodigo()+ ", '" + cliente.getLogin() + "', '"  
                       + cliente.getSenha() + "', '" + cliente.getSexo() + "');";
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {  
            throw new RuntimeException(u);
        }
        return status;
    }
    
    public boolean autenticar(String nome, String cpf) {
        boolean resp = false;
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Clientes WHERE nome LIKE '" + nome + "' AND cpf LIKE '" + cpf  + "'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            resp = rs.next();
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return resp;
    }
    
    public List<Clientes> getSexoMasculino() {
        List<Clientes> clientesList = new ArrayList<Clientes>();
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Clientes WHERE sexo LIKE 'M'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);            
            while(rs.next()) {                
                Clientes u = new Clientes(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("sexo").charAt(0));
                clientesList.add(u);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return clientesList;
    }
    
    public boolean update(Clientes cliente) {
        boolean status = false;
        try {  
            Statement st = conexao.createStatement();
            String sql = "UPDATE Clientes SET nome = '" + cliente.getLogin() + "', cpf = '"  
                       + cliente.getSenha() + "', sexo = '" + cliente.getSexo() + "'"
                       + " WHERE id = " + cliente.getCodigo();
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {  
            throw new RuntimeException(u);
        }
        return status;
    }
    
    public List<Clientes> getOrderByCodigo() {
        return get("id");       
    }
    
    public boolean delete(int id) {
        boolean status = false;
        try {  
            Statement st = conexao.createStatement();
            String sql = "DELETE FROM Clientes WHERE id = " + id;
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {  
            throw new RuntimeException(u);
        }
        return status;
    }
    
    public List<Clientes> getOrderByLogin() {
        return get("nome");       
    }
    
    private List<Clientes> get(String orderBy) {    
    
        List<Clientes> clientesList = new ArrayList<Clientes>();
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Clientes" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);            
            while(rs.next()) {                
                Clientes u = new Clientes(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("sexo").charAt(0));
                clientesList.add(u);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return clientesList;
    }
}
