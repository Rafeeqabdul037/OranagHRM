package com.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Practice.PracticeArea;

	public class RadioButtonsTesting extends BaseClass
	{
		@Test
		public void radioButtonsGroup1Test() throws InterruptedException
		{
			
			// /html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td
			WebElement radioButtonsBlock1=driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));

			List<WebElement>radioButtonsGroup1=radioButtonsBlock1.findElements(By.name("group1"));
			
			System.out.println(radioButtonsGroup1.size());
			
			for(int i=0;i<radioButtonsGroup1.size();i++)
			{
				radioButtonsGroup1.get(i).click();
				Thread.sleep(1000);
				for(int j=0;j<radioButtonsGroup1.size();j++)
				{
					System.out.print(radioButtonsGroup1.get(j).getAttribute("value")+" "+radioButtonsGroup1.get(j).getAttribute("checked")+" ");
				}
				System.out.println();
			}
			
			
		}
		
		@Test
		public void radioButtonsGroup2Test() throws InterruptedException
		{
			WebElement radioButtonsBlock=driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));

			List<WebElement>radioButtonsGroup2=radioButtonsBlock.findElements(By.name("group2"));
			
			
			System.out.println(radioButtonsGroup2.size());
			
			for(int k=0;k<radioButtonsGroup2.size();k++)
			{
				radioButtonsGroup2.get(k).click();
				Thread.sleep(1000);
				for(int l=0;l<radioButtonsGroup2.size();l++)
				{
					System.out.print(radioButtonsGroup2.get(l).getAttribute("value")+" "+radioButtonsGroup2.get(l).getAttribute("checked")+" ");
				}
				System.out.println();
			}
		}

}
