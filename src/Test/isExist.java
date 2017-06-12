package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import DAO.ContactDAO;

public class isExist {
	ContactDAO contact;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		contact=new ContactDAO();
	}

	@After
	public void tearDown() throws Exception {
		contact=null;
	}

	@Test
	public void testIsExist() {
		Boolean resultat=contact.isExist("Zaydan");
		assertEquals("Zaydan exist as my contact?",true, resultat);
	}
	

}
