package projeto7.spring.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto7.spring.data.dao.InterfaceSpringDataUser;
import projeto7.spring.data.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {
	
	@Autowired
	InterfaceSpringDataUser interfaceSpringDataUser;

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
	
	
}
