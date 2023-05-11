import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

@pytest.fixture()
def browser():
    # Initialize ChromeDriver
    driver = webdriver.Chrome()
    # Maximize the browser window
    driver.maximize_window()
    # Load the W3Schools website
    driver.get("https://www.w3schools.com/")
    yield driver
    # Quit the browser
    driver.quit()

def test_w3schools_logo(browser):
    # Find the W3Schools logo element
    logo_element = browser.find_element(By.XPATH, "//a[@title='Home']")
    # Assert that the logo element is visible
    assert logo_element.is_displayed()

