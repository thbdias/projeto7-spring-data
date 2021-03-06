package projeto7.spring.data;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto7.spring.data.dao.InterfaceSpringDataUser;
import projeto7.spring.data.dao.InterfaceTelefone;
import projeto7.spring.data.model.Telefone;
import projeto7.spring.data.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {
	
	@Autowired
	InterfaceSpringDataUser interfaceSpringDataUser;
	@Autowired
	InterfaceTelefone interfaceTelefone;

	@Test
	public void testeInsert() {
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("email@email.com");
		usuarioSpringData.setIdade("15");
		usuarioSpringData.setLogin("admin");
		usuarioSpringData.setSenha("123");
		usuarioSpringData.setNome("pedro");
		
		interfaceSpringDataUser.save(usuarioSpringData);
		System.out.println("usuarios cadastrados: " + interfaceSpringDataUser.count());
	}	
	
	@Test
	public void testeConsulta() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getIdade());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getSenha());
		System.out.println(usuarioSpringData.get().getId());
		
		for (Telefone telefone : usuarioSpringData.get().getTelefones()) {
			System.out.println("-------");
			System.out.println(telefone.getTipo());
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getId());			
		}
	}
	
	
	@Test
	public void testeConsultaTodos() {
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("---------------------------");
		}
	}
	
	@Test
	public void testeUpdate() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(5L);
		
		UsuarioSpringData data = usuarioSpringData.get();
		data.setNome("marta");
		data.setIdade("20");
		interfaceSpringDataUser.save(data);
	}
	
	@Test
	public void testeDelete() {
		interfaceSpringDataUser.deleteById(6L);		
		//ou		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(4L);
		interfaceSpringDataUser.delete(usuarioSpringData.get());
	}
	
	@Test
	public void testeConsultaPersonalizada() {
		List<UsuarioSpringData> lista = interfaceSpringDataUser.buscarPorNome("maria");
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("---------------------------");
		}
	}
	
	@Test
	public void testeConsultaPersonalizadaNomeParam() {
		UsuarioSpringData usuarioSpringData = interfaceSpringDataUser.buscaPorNomeParam("maria");
	
		System.out.println(usuarioSpringData.getEmail());
		System.out.println(usuarioSpringData.getIdade());
		System.out.println(usuarioSpringData.getLogin());
		System.out.println(usuarioSpringData.getNome());
		System.out.println(usuarioSpringData.getSenha());
		System.out.println(usuarioSpringData.getId());
	}
	
	@Test
	public void testeDeletePorNome() {
		interfaceSpringDataUser.deletePorNome("maria2");
	}
	
	@Test
	public void testeUpdatePorNome() {
		interfaceSpringDataUser.updateEmailPorNome("update@update.com", "maria");
	}
	
	@Test
	public void testeInsertTelefone() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		
		Telefone telefone = new Telefone();
		telefone.setTipo("celular");
		telefone.setNumero("1111111111");
		telefone.setUsuarioSpringData(usuarioSpringData.get());
		
		interfaceTelefone.save(telefone);
	}
}
