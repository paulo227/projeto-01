package br.com.pPaulo;

import br.com.pPaulo.dominio.ClienteMapDao;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static javax.swing.JOptionPane.*;

public class App {

    private static String iClienteDao;
    private static String cadastrar;
    private static Long cadastrarCpf;
    private static String opcao;
    private static String excluir;

    public static void main(String[] args) {
        iClienteDao = new ClienteMapDao().toString();


        opcao = showInputDialog(null, "1 para cadastrar, 2 para consultar, 3 para excluir, 4 para alterar, 5 para sair ", "Cadastro", INFORMATION_MESSAGE);

        while (isOpcaoValida(opcao)) {
            cadastrar();
            consultar();
            alterar();
            excluir();
            sair();
            opcao = showInputDialog(null, "1 para cadastrar, 2 para consultar, 3 para excluir, 4 para alterar, 5 para sair ", "Cadastro", INFORMATION_MESSAGE);

        }


        while (Boolean.TRUE.equals(isSair())) {
            if ("".equals(opcao)) {
                System.exit(0);

            }

        }

    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void cadastrar() {
        if ("1".equals(opcao)) {
            cadastrarCpf = Long.valueOf(showInputDialog(null, "Cadastrar seu CPF: ", "CPF", INFORMATION_MESSAGE));
            iClienteDao = showInputDialog(null, "Informe seus dados separados por virgula: NOME, TELEFONE, CIDADE, ENDEREÇO, NÚMERO ", "Cadastro", INFORMATION_MESSAGE);
            String[] split = iClienteDao.split(", ");
            showMessageDialog(null, "Cadastrado com sucesso!", "Sucesso", INFORMATION_MESSAGE);
        }
    }

    private static void sair() {
        if ("5".equals(opcao)) {
            showMessageDialog(null, "Até logo!!!", "Sair", INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    private static Object consultar() {
        if ("2".equals(opcao)) {
            Long cpf = Long.valueOf(showInputDialog(null, "Digite o seu CPF: ", "CPF", INFORMATION_MESSAGE));
            if (cadastrarCpf.equals(cpf)) {
                showMessageDialog(null, iClienteDao, "Cadastro", INFORMATION_MESSAGE);
                opcao = showInputDialog(null, "1 para cadastrar, 2 para consultar, 3 para excluir, 4 para alterar, 5 para sair ", "Cadastro", INFORMATION_MESSAGE);

            } else {
                showMessageDialog(null, "CPF inválido :(", "Cadastro", INFORMATION_MESSAGE);

            }
        }

        if ("2".equals(opcao)) {
            Long cpf = Long.valueOf(showInputDialog(null, "Digite o seu CPF: ", "CPF", INFORMATION_MESSAGE));
            if (cadastrarCpf == null) {
                JOptionPane.showMessageDialog(null, "CPF inexistente..");

            }
        }
        return false;
    }

    private static void excluir() {
        if ("3".equals(opcao)) {
            Long cpf = Long.valueOf(showInputDialog(null, "Digite o seu CPF: ", "CPF", INFORMATION_MESSAGE));
            if (cpf.equals(cadastrarCpf)) {

                List<String> excluir = new ArrayList<>();
                excluir = Collections.singletonList(String.valueOf(showConfirmDialog(null, "Excluir cadastro?", "Excluir", YES_NO_CANCEL_OPTION)));
                int yesOption = YES_OPTION;
                if (excluir.equals(yesOption)) {

                }
                JOptionPane.showMessageDialog(null, "Cadastro excluido", "Excluir", INFORMATION_MESSAGE);


            }
        }

    }

    private static void alterar() {
        if ("4".equals(opcao)) {
            Long cpf = Long.valueOf(JOptionPane.showInputDialog(null, "Digite seu CPF: ", "Alterar", INFORMATION_MESSAGE));
            if (cpf.equals(cadastrarCpf)) {
                iClienteDao = showInputDialog(null, "Informe seus dados separados por virgula: NOME, TELEFONE, CIDADE, ENDEREÇO, NÚMERO ", "Cadastro", INFORMATION_MESSAGE);
                if (iClienteDao != null) {
                    JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso", "Alteração", INFORMATION_MESSAGE);
                }
            }else JOptionPane.showMessageDialog(null, "Alteração não realizada");

    }

    }
    private static Boolean isSair(){
        if ("".equals(App.opcao)){
            showMessageDialog(null, "Obrigado!!!", "Sair", INFORMATION_MESSAGE);

        }
        return null;
    }
}
