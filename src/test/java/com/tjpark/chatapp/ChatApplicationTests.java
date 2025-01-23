package com.tjpark.chatapp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootTest
class ChatApplicationTests {
	private String URL = "jdbc:postgresql://localhost:5432/postgres";
	private String USERNAME = "chat";
	private String PASSWORD = "chat3241";

	@Test
	void contextLoads() {
	}


	@Test
	@DisplayName("DB 연결테스트")
	public void ConnectionßTest() throws Exception{
		Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD); //db 연결
		Assertions.assertThat(con).isNotNull();
	}






}
