package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IconstantPath;
//This test Verifies is user is able to add course

public class AddCourseTest extends BaseClass {
	@Test
	public void addCourseTest() {
		SoftAssert soft = new SoftAssert();
		
		
		home.clickCoursesTab();
		home.clickCoursesListLink();
		soft.assertTrue(courseList.getPageHeader().contains("Course List"));
		courseList.clickNewButton();
		soft.assertEquals(addcourse.getPageHeader(), "Add New Course");
		
		Map<String,String> map = excel.readFromExcel("Add Course");
		addcourse.setName(map.get("Name"));
		addcourse.selectCategory(web, map.get("Category"));
		addcourse.setPrice(map.get("Price"));
		addcourse.uploadphoto(map.get("Photo"));
		addcourse.setDescription(map.get("Description"), web);
		addcourse.clickSave();

		
		
		
		soft.assertEquals(courseList.getSuccessMessage(),"success");
		courseList.deleteCourse(web, map.get("Name"));
		soft.assertEquals(courseList.getSuccessMessage(),"success");
		
		
		if(courseList.getSuccessMessage().equals("success"))excel.updateTestStatus("Add Course", "Pass", IconstantPath.EXCEL_PATH);
		else
			excel.updateTestStatus("Add Course", "Fail", IconstantPath.EXCEL_PATH);
		
		soft.assertAll();
	}
	

}
