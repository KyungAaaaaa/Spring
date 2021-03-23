package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	@Test
	public void testConnection() throws Exception {
		Class cls = Class.forName("oracle.jdbc.driver.OracleDriver");

		//연결,해제 여러번반복 테스트 = 에러
		
		/*
		 * long start = System.currentTimeMillis(); 
		 * for (int i = 0; i < 100; i++) {
		 */
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "book_ex", "book_ex");
			log.info(con);

			con.close();

			/*
			 * long end = System.currentTimeMillis();
			 * log.info("--------------------------------------------------------");
			 * log.info(end - start); }
			 */
	}
}
