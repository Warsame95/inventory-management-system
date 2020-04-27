package databaseTest;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Connection;

import database.dbConnect;

public class dbConnectTest {
	
	@Test
	public void testMockdbConnect() {
		
		Statement stmt = mock(Statement.class);
		dbConnect mockConnection = mock(dbConnect.class);
		
		when(mockConnection.createStatement()).thenReturn(stmt);	
		verify(mockConnection.createStatement(), times(1));
		
		
	}

}
