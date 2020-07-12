package net.dex.javawebapp.service;


import java.util.ArrayList;
import java.util.List;
import net.dex.javawebapp.model.Cliente;


/**
 * Service to do the processing envolving
 * Cliente's class data.
 */
public class ClienteService
{

  /** An ArrayList based on Cliente class. Represents a list of clientes. */
  private static List<Cliente> lista = new ArrayList<>();

  /**
   * Add a Cliente to the list.
   * @param cliente the object cliente to be added into the ArrayList.
   */
  public void cadastrar(Cliente cliente)
  {
    lista.add(cliente);
  }

  /**
   * Get all the objects Cliente from the list.
   * @return the lista of clientes.
   */
  public List<Cliente> getClientes()
  {
    return lista;
  }

  /**
   * Get a single Cliente object from the list, by its index.
   * @param indice the index of the ArrayList.
   * @return the value Cliente from the exact index-provided reference.
   */
  public Cliente getUmCliente(int indice)
  {
    return lista.get(indice);
  }

  /**
   * Remove a Cliente object, by its index.
   * @param indice the index of the ArrayList.
   */
  public void excluir(int indice)
  {
    lista.remove(indice);
  }

  /**
   * Edit a Cliente object, by its index.
   * @param indice the index of the ArrayList.
   * @param cliente the Cliente object to put.
   */
  public void alterar(int indice, Cliente cliente)
  {
    lista.set(indice, cliente);
  }
}
