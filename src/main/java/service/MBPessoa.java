package service;

import dao.PessoaDAO;
import entity.PessoaEntity;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

//@ManagedBean
@ViewScoped
public class MBPessoa {
    private PessoaEntity pessoa;
 	private List<PessoaEntity> pessoaList = new ArrayList<>();

    @PostConstruct
    public void init(){
        updatePessoaList();
    }

    public void limparPessoa() {
        System.out.println("Limpando People");
        pessoa.setNome("");
        pessoa.setEmail("");
        pessoa.setTelefone("");
        pessoa.setCpf("");
    }

    public List<PessoaEntity> updatePessoaList() {
//        limparPessoa();
//        System.out.println("Listando People");
        try {
            PessoaDAO pessoaDAO = new PessoaDAO();
//            pessoaList.addAll(pessoaDAO.listPessoas());
            this.pessoaList = (pessoaDAO.listPessoas());
        } catch (Exception e) {
//            setMsg(e.getMessage());
            e.getMessage();
        }
        return pessoaList;
    }

    public List<PessoaEntity> getPessoaList(){
        return pessoaList;
    }

}
