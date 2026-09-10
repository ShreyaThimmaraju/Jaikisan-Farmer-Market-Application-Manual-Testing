# Jaikisan - Farmer Market Application



## Project Overview



Jaikisan is a Farmer-to-Consumer marketplace application that allows customers to browse agricultural products, search for products, view product details, add products to the cart, and proceed toward checkout.



This project covers both Manual Testing and Selenium Automation Testing.



---



## Manual Testing



### Testing Activities



- Test Plan

- Test Scenarios

- Test Cases

- Bug Reports

- Bug Screenshots



---



## Automation Testing



### Tools & Technologies



- Java 17

- Selenium WebDriver

- TestNG

- Maven

- Page Object Model (POM)

- WebDriverWait

- ExtentReports

- Git & GitHub



### Automated Test Cases



| Test Case | Description |

|---|---|

| TC01 | Home Page Verification |

| TC02 | Search Product |

| TC03 | Invalid Product Search |

| TC04 | Vegetables Category |

| TC05 | Fruits Category |

| TC06 | Product Details |

| TC07 | Add Product to Cart |

| TC08 | Cart Details |

| TC09 | Increase Cart Quantity |

| TC10 | Delete Product from Cart |

| TC11 | Proceed to Checkout |

| TC12 | Login Page |

| TC13 | Register Page |

| TC14 | Registration Form Fields |

| TC15 | Empty Registration Validation |

| TC16 | Invalid Phone Number Validation |



### Test Execution Result



- Total Tests: 16

- Passed: 14

- Failed: 2

- Errors: 0

- Skipped: 0



### Known Defects Detected



#### BUG_004 - Cart Quantity Not Increasing



The cart quantity remains `1` after clicking the `+` button.



Detected by:



`TC09 - Increase Cart Quantity`



#### BUG_005 - Delete Product Not Working



The product remains in the cart after clicking the Delete button.



Detected by:



`TC10 - Delete Product`



These failures are intentional because the automation tests successfully identify defects in the application.



---



## Automation Framework Structure



```text

jaikisan-automation

    pom.xml

    testng.xml

    src

        test

            java

                com.jaikisan.automation

                    BaseTest.java

                    ExtentReportManager.java

                    TestListener.java

                    TC01_HomePageTest.java

                    TC02_SearchProductTest.java

                    TC03_InvalidProductSearchTest.java

                    TC04_VegetablesCategoryTest.java

                    TC05_FruitsCategoryTest.java

                    TC06_ProductDetailsTest.java

                    TC07_AddToCartTest.java

                    TC08_CartDetailsTest.java

                    TC09_IncreaseCartQuantityTest.java

                    TC10_DeleteProductTest.java

                    TC11_CheckoutNavigationTest.java

                    TC12_LoginPageTest.java

                    TC13_RegisterPageTest.java

                    TC14_RegistrationFormFieldsTest.java

                    TC15_EmptyRegistrationValidationTest.java

                    TC16_InvalidPhoneNumberTest.java

                    pages

                        BasePage.java

                        HomePage.java

                        ProductPage.java

                        CartPage.java

                        LoginPage.java

                        RegisterPage.java


---

## Jenkins CI/CD

Jenkins CI/CD automation configured successfully.

GitHub → Jenkins → Maven → Selenium/TestNG → ExtentReports
