package br.com.pPaulo.dominio;

import br.com.pPaulo.cliente.Cliente;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class ClienteMapDao implements IClienteDao {

    private static Map<Long, Cliente>map;
    private Long cpf;

    public ClienteMapDao() {
        map = new TreeMap<>();
    }



    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (map.containsKey(cliente.getCpf())){
            return false;

        }
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void atualizarCadastro(Cliente cliente) {
        Cliente clienteCadastrado = map.get(cliente.getCpf());
        clienteCadastrado.setCpf(cliente.getCpf());
        clienteCadastrado.setCidade(cliente.getCidade());
        clienteCadastrado.setNome(cliente.getNome());
        clienteCadastrado.setTel(cliente.getTel());
        clienteCadastrado.setEndereco(cliente.getEndereco());
        clienteCadastrado.setNumero(cliente.getNumero());
    }
    @Override
    public void excluir() {
        Cliente clienteCadastrado = map.get(cpf);
        map.remove(clienteCadastrado.getCpf(), clienteCadastrado);

    }

    @Override
    public Cliente Consultar(Cliente cliente) {
        return map.get(cliente.getCpf());
    }

    @Override
    public Collection<Cliente> buscarCliente() {
        return this.map.values();
    }
}
