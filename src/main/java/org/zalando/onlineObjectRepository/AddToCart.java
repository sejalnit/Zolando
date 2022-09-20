package org.zalando.onlineObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddToCart
{

	@FindBy(xpath="//a[@href='my-wishlist.php']") private WebElement wishlistpro; 
}