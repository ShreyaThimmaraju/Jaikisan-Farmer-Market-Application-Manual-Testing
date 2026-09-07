# Jaikisan – Farmer Market Application Manual Testing

## Project Overview

Jaikisan is a farmer-to-home marketplace application that allows users to browse fresh agricultural products, search for products, view product details, add products to the cart, and manage their account.

This project focuses on manually testing the main functional features of the application.

## Application URL

https://jaikisan.app/

## Testing Type

- Manual Testing
- Functional Testing
- UI Testing
- Validation Testing
- Negative Testing

## Modules Tested

- Home Page
- Product Search
- Product Categories
- Product Details
- Shopping Cart
- Login
- Registration
- Language Selection
- Navigation

## Testing Documents

### 01. Test Plan
Contains the testing objective, scope, approach, environment, and overall testing information.

### 02. Test Scenarios
Contains high-level scenarios used to verify the application's functionality.

### 03. Test Cases
Contains detailed test cases with test steps, expected results, actual results, and status.

### 04. Bug Reports
Contains the defects identified during testing.

### 05. Bug Screenshots
Contains screenshots captured as evidence for identified bugs and passed test cases.

## Defects Identified

During manual testing, the following issues were identified:

1. Fresh Tomatoes image is not displayed.
2. Vegetables category shows no products.
3. Alphonso Mangoes image is not displayed.
4. Cart quantity (+ / -) buttons are not working.
5. Cart delete button is not working.
6. Login link is not clickable in the tested location.
7. Language change requires page refresh.
8. Category links lead to 404 Page Not Found.
9. Organic category link leads to 404 Page Not Found.
10. Login/registration validation issues were observed during testing.

## Test Result

The application was manually tested across the selected modules.

- Test cases executed: As documented in the Test Cases Excel file
- Bugs identified: 9+ issues
- Testing status: Completed

## Tools Used

- Google Chrome
- Microsoft Excel
- Visual Studio Code
- Git
- GitHub

## Project Structure

```text
Jaikisan-Farmer-Market-Application
│
├── 01_Test_Plan
│   └── Jaikisan_Test_Plan.xlsx
│
├── 02_Test_Scenarios
│   └── Jaikisan_Test_Scenarios.xlsx
│
├── 03_Test_Cases
│   └── Jaikisan_Test_Cases.xlsx
│
├── 04_Bug_Reports
│   └── Jaikisan_Bug_Report.xlsx
│
├── 05_Bug_Screenshots
│   ├── BUG_001...
│   ├── BUG_002...
│   ├── BUG_003...
│   └── ...
│
└── README.md