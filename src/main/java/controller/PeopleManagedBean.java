package controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import model.People;

import dao.PessoaDAO;

@ManagedBean
@SessionScoped
public class PeopleManagedBean implements java.io.Serializable {
	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public List<PeopleManagedBean> getPeopleList() {
		limparPessoa();
		System.out.println("Listando People");
		peopleList = new ArrayList<PeopleManagedBean>();
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			for (People people : pessoaDAO.listPessoas()) {
				PeopleManagedBean mbPessoa = new PeopleManagedBean();
				mbPessoa.setPeople(people);
				peopleList.add(mbPessoa);
			}
		} catch (Exception e) {
			setMsg(e.getMessage());
			e.getMessage();
		}
		return peopleList;
	}

	public void setPeopleList(List<PeopleManagedBean> peopleList) {
		this.peopleList = peopleList;
	}

	private static final long serialVersionUID = 1L;
	private String selectedCPF;
	private People people;
	private List<PeopleManagedBean> peopleList;
//	private static final Logger log = Logger.getLogger(PeopleManagedBean.class);

	public void setSelectedCPF(String selectedCPF) {
		this.selectedCPF = selectedCPF;
	}

	private String getSelectedCPF() {
		return selectedCPF;
	}

	public void limparPessoa() {
		System.out.println("Limpando People");
		people.setNome("");
		people.setEmail("");
		people.setTelefone("");
		people.setCpf("");
	}

//	public String editPessoa() {
//		log.info("Editando People " + getSelectedCPF());
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		People people = pessoaDAO.getPeople(getSelectedCPF());
//
//		if (people != null) {
//			this.people.setCpf(people.getCpf());
//		} else {
//			setMsg("People nao encontrada!");
//			log.error("People nao encontrada!");
//		}
//		return "update";
//	}

//	public String createPessoa() {
//		String str = "index";
//
//		try {
//			PessoaDAO pessoaDAO = new PessoaDAO();
//			pessoaDAO.createPessoa(getPeople());
//			limparPessoa();
//			setMsg("People cadastrada!");
//		} catch (Exception e) {
//			setMsg(e.getMessage());
//			str = "insert";
//			log.error(e);
//		}
//
//		return str;
//	}

//	public String deletePessoa() {
//		log.info("Excluindo People " + getSelectedCPF());
//
//		String str = "index";
//
//		try {
//			PessoaDAO pessoaDAO = new PessoaDAO();
//			pessoaDAO.deletePessoa(getSelectedCPF());
//			limparPessoa();
//			setMsg("Excluído com sucesso!");
//
//		} catch (Exception e) {
//			setMsg(e.getMessage());
//			log.error(e);
//		}
//
//		return str;
//	}

//	public String updatePessoa() {
//		String str = "index";
//		try {
//			PessoaDAO pessoaDAO = new PessoaDAO();
//			pessoaDAO.updatePessoa(getPeople());
//			limparPessoa();
//			setMsg("Atualizado com sucesso!");
//		} catch (Exception e) {
//			setMsg(e.getMessage());
//			str = "deleteUpdate";
//			log.error(e);
//		}
//		return str;
//	}

//	public List<PeopleManagedBean> getListaPessoas() {
//		limparPessoa();
//		log.info("Listando People");
//		peopleList = new ArrayList<PeopleManagedBean>();
//		try {
//			PessoaDAO pessoaDAO = new PessoaDAO();
//			for (People people : pessoaDAO.listPessoas()) {
//				PeopleManagedBean mbPessoa = new PeopleManagedBean();
//				mbPessoa.setPeople(people);
//				peopleList.add(mbPessoa);
//			}
//		} catch (Exception e) {
//			setMsg(e.getMessage());
//			log.error(e);
//		}
//		return peopleList;
//	}

	private void setMsg(String message) {
		// TODO Auto-generated method stub
	}

}
