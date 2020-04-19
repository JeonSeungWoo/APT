package org.woo.apt;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DSTest {

	@Inject
	private DataSource ds;

	@Test
	public void postgresDBConnectionTest() throws Exception {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
		System.out.println(con);
		con.close();
	}

	@Test
	public void dsTest() throws Exception {
		Connection con = ds.getConnection();
		System.out.println(con);
		con.close();
	}

}
