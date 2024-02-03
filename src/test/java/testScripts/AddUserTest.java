package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;

public class AddUserTest extends BaseClass {
	@Test
	public  void addUserTest() {
		SoftAssert soft = new SoftAssert();
		
		home.clickUsersTab();
		soft.assertTrue(users.getPageHeader().contains("Users"));
		users.clickNewButton();
		soft.assertEquals(adduser.getpageHeader(), "Add New User");
		
		Map<String,String>map = excel.readFromExcel("Add User");
		
		adduser.setEmail(map.get("Email"));
		adduser.setPassword(map.get("Password"));
		adduser.setFirstname(map.get("Firstname"));
		adduser.setLastname(map.get("lastname"));
		adduser.setAddress(map.get("Address"));
		adduser.setContactInfo(map.get("ContactInfo"));
		adduser.uploadphoto(map.get("Photo"));
		
		adduser.clicksave();
		
		soft.assertEquals(users.getSuccessMessage(), "Success!");
		soft.assertAll();
	}

}
