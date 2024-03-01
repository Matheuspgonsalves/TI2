package app;

import dao.ClientesDAO;
import model.Clientes;

import java.util.List;

public class Aplicacao {
    
    public static void main(String[] args) {
        
        ClientesDAO clientesDAO = new ClientesDAO();
        
        System.out.println("\n\n==== Inserir usuário === ");
        Clientes cliente = new Clientes(11, "pablo", "pablo", 'M');
        if(clientesDAO.insert(cliente)) {
            System.out.println("Inserção com sucesso -> " + cliente.toString());
        }
        
        System.out.println("\n\n==== Testando autenticação ===");
        System.out.println("Usuário (" + cliente.getLogin() + "): " + clientesDAO.autenticar("pablo", "pablo"));
        
        System.out.println("\n\n==== Mostrar usuários do sexo masculino === ");
        List<Clientes> clientesList = clientesDAO.getSexoMasculino();
        for (Clientes u: clientesList) {
            System.out.println(u.toString());
        }
        
        System.out.println("\n\n==== Atualizar senha (código (" + cliente.getCodigo() + ") === ");
        cliente.setSenha("novaSenha");
        if(clientesDAO.update(cliente)) {
            System.out.println("Senha atualizada com sucesso!");
        }
        
        System.out.println("\n\n==== Testando autenticação ===");
        System.out.println("Usuário (" + cliente.getLogin() + "): " + clientesDAO.autenticar("pablo", "novaSenha"));
        
        System.out.println("\n\n==== Invadir usando SQL Injection ===");
        System.out.println("Usuário (" + cliente.getLogin() + "): " + clientesDAO.autenticar("pablo", "x' OR 'x' LIKE 'x"));
        
        System.out.println("\n\n==== Mostrar usuários ordenados por código === ");
        clientesList = clientesDAO.getOrderByCodigo();
        for (Clientes u: clientesList) {
            System.out.println(u.toString());
        }
        
        System.out.println("\n\n==== Excluir usuário (código " + cliente.getCodigo() + ") === ");
        if(clientesDAO.delete(cliente.getCodigo())) {
            System.out.println("Usuário excluído com sucesso!");
        }
        
        System.out.println("\n\n==== Mostrar usuários ordenados por login === ");
        clientesList = clientesDAO.getOrderByLogin();
        for (Clientes u: clientesList) {
            System.out.println(u.toString());
        }
    }
}
