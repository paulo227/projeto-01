package br.com.pPaulo.dominio;

import br.com.pPaulo.cliente.Cliente;

import java.util.Collection;

public interface IClienteDao {
    Boolean cadastrar(Cliente cliente);
    public void atualizarCadastro(Cliente cliente);

    void excluir();

    public Cliente Consultar(Cliente cliente);

    public Collection<Cliente> buscarCliente();

}
