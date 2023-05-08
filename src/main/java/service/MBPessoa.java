package service;

import dao.PessoaDAO;
import entity.PessoaEntity;

import java.util.ArrayList;
import java.util.List;

public class MBPessoa {
    private PessoaEntity pessoa;
 	private List<PessoaEntity> pessoaList;

    public void limparPessoa() {
        System.out.println("Limpando People");
        pessoa.setNome("");
        pessoa.setEmail("");
        pessoa.setTelefone("");
        pessoa.setCpf("");
    }

    public List<PessoaEntity> getPessoaList() {
        limparPessoa();
        System.out.println("Listando People");
        pessoaList = new ArrayList<>();
        try {
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaList.addAll(pessoaDAO.listPessoas());
        } catch (Exception e) {
//            setMsg(e.getMessage());
            e.getMessage();
        }
        return pessoaList;
    }

}
