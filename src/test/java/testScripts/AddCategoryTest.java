package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IconstantPath;
//sweta is etc
public class AddCategoryTest extends BaseClass {
	@Test
	public void addCategoryTest() {
		SoftAssert soft = new SoftAssert();
		
		home.clickCoursesTab();
		home.clickCoursesListLink();
		soft.assertEquals(category.getPageHeader(), "Category");
		
		category.clickNewButton();
		soft.assertEquals(addCategory.getPageHeader(),"Add New Category");
		Map<String,String>map = excel.readFromExcel("Add category");
		addCategory.setName(map.get("Name"));
		addCategory.clickSave();
		
		
		soft.assertEquals(category.getSuccessMessage(), "Success");
		category.deleteCategory(web,map.get("Name"));
		soft.assertEquals(category.getSuccessMessage(), "Success");
		if(category.getSuccessMessage().equals("Success !"))excel.updateTestStatus("Add Category", "pass", IconstantPath.EXCEL_PATH);
		else
			excel.updateTestStatus("Add Category", "Fail", IconstantPath.EXCEL_PATH);
		
		
		soft.assertAll();
	}
	

}
