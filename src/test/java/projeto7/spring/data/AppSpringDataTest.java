package projeto7.spring.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto7.spring.data.dao.InterfaceSpringDataUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {
	
	@Autowired
	InterfaceSpringDataUser interfaceSpringDataUser;

	@Test
	public void testeInsert() {
		System.out.println("iniciou spring com suceso");
	}
	
}
