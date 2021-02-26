Feature: Assignment

  @DatePicker
  Scenario: Click the date in Calender
    Given Provide date="2021-03-15" input_in_yyyy/MM/DD_format
    When Validate userdate
    And Navigate to "http://jqueryui.com/datepicker"
    And Switch to iframe
    And Select user month
    And Select user date
    Then Close browser

  @WebTable
  Scenario: Print Table data
    Given Navigate to url "https://www.w3schools.com/html/html_tables.asp"
    When Retrieve Header values
    And Retrieve each row values
    Then Quit the browser

  @FizzBuzz
  Scenario Outline: Print natural numbers with fizz buzz
    Given Provide input <range> <fizzdivider> <buzzdivider>
    Then Print Numbers With Replacing Fizz_buzz
    Examples:
    |range|fizzdivider|buzzdivider|
    |35   |5          |7          |

 @SortedString
 Scenario Outline: Remove duplicates and sort string
   Given Provide inputstring <string> And Covert To LowerCase
   When Sort and Remove Duplicates
   Then Print SortedString
   Examples:
   |string|
   |FizzBuzzString|

   @CurrentWorkingDay
   Scenario: Check current day is working day or not
     Given Get current date
     When Get current day of week
     Then Validate current day

  @RandomWeekDate
  Scenario Outline: Generate random date which is working day within range
    Given Provide <weekRange> and convert to days
    When Generate random date
    And Validate random date
    Then Print randomdate
    Examples:
      | weekRange |
      |2          |





