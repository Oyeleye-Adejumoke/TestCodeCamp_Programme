package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {
            private WebDriver driver;
            private By totalItemCount=By.xpath("//*[@id=\"mainContent\"]/div/div[2]");
            private By addItem=By.xpath("//button[@name='increment']");
            private By checkOutButton= By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[3]/div/div[6]/div/a");

            public AddToCartPage(WebDriver driver)
            {
                this.driver=driver;

            }
            //Check the number of item in the cart
            public void itemCount (int count) throws InterruptedException {
                int itemNumber= Integer.parseInt(driver.findElement(totalItemCount).getText());
                do
                    {
                    //if the amount is equal to the amount entered stop adding
                     if (itemNumber==count) break;
                     driver.findElement(addItem).click();
                     //store the count of items
                     itemNumber=Integer.parseInt(driver.findElement(totalItemCount).getText());
                    //if the item is not equal to the required amount,keep adding
                }while (itemNumber !=count);
                Thread.sleep(5000);

            }

                //select delivery address
                public void selectaddress ()
                {
                    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div/div/section[1]/div[2]/div/div[1]/div/div[1]/form/div/div/a"));

                }

                //Click on Check out button
                public CheckOutPage clickCheckOut() throws InterruptedException {
                    driver.findElement(checkOutButton).click();
                  Thread.sleep(3000);
                  return new CheckOutPage(driver);
                }


            }
