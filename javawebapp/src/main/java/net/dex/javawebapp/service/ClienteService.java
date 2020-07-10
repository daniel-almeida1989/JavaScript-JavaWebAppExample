/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.dex.javawebapp.service;


import java.util.ArrayList;
import java.util.List;
import net.dex.javawebapp.model.Cliente;


/**
 *
 * @author Daniel Augusto Almeida
 *
 */
public class ClienteService
{

  private static List<Cliente> lista = new ArrayList<>();

  public void cadastrar(Cliente cliente)
  {
    lista.add(cliente);
  }

  public List<Cliente> getClientes()
  {
    return lista;
  }

  public void excluir(int indice)
  {
    lista.remove(indice);
  }

}
