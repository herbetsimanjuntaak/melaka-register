@regress @melaka @register
Feature: Register

  Background: Access Register Page
    Given user access page "https://dashboard.melaka.app/register"


  Scenario: Register successfully
    When user input name "Leslie Feest"
    And user input phone number "81168031143"
    And user input business name "International Consulting Executive"
    And user selects "Toko Retail"
    And user input email "Darla@melaka.com"
    And user input password "v3avm0kt13"
    And user input confirm password "v3avm0kt13"
    And user click on checkbox register
    And user click on button register
    Then system display Selamat datang di Melaka

  Scenario Outline: Register failed with "<Field Name>"
    When user input name "<Name>"
    And user has completed the other fields and click button register
    Then system display error message "<Error Message>"
    Examples:
      | Field Name    | Name | Error Message                 |
      | Name Empty    |      | Wajib diisi.                  |
      | Name < 5 Char | ToDo | Wajib diisi, min. 5 karakter. |


  Scenario Outline: Register failed with "<Field Name>"
    When user input name "<Name>"
    And user has completed the other fields and click button register
    Then system display error name field message "<Error Message>"
    Examples:
      | Field Name                   | Name                      | Error Message                 |
      | Name with special characters | !@#Name                   | Wajib diisi, min. 5 karakter. |
      | Name with number             | 123456                    | Wajib diisi, min. 5 karakter. |
      | Name > 50 Char               | dasfsadfsadfsdafsadfsasdf | Wajib diisi, min. 5 karakter. |


  Scenario Outline: Register failed with "<Field Phone Number>"
    And user has completed the other fields
    When user input phone number "<Phone Number>"
    And user click on checkbox register and button register
    Then system display error message "<Error Message>"
    Examples:
      | Field Phone Number     | Phone Number   | Error Message                                                                      |
      | Empty Phone Number     |                | Wajib diisi. Nomor telepon tidak boleh kurang dari 10 atau lebih dari 12 karakter. |
      | Phone Number < 10 Char | 81396700       | Wajib diisi. Nomor telepon tidak boleh kurang dari 10 atau lebih dari 12 karakter. |
      | Phone Number > 12 Char | 82638126521456 | Wajib diisi. Nomor telepon tidak boleh kurang dari 10 atau lebih dari 12 karakter. |
      | Phone Number with Char | Not a number   | Wajib diisi. Nomor telepon tidak boleh kurang dari 10 atau lebih dari 12 karakter. |
      | Invalid Phone Number   | 081245444642   | \"+1245444642\" is not valid \"tel\"                                               |


  Scenario Outline: Register failed with "<Field Business Name>"
    And user are completed all fields except business name
    When user input business name "<Business Name>"
    And user click on checkbox register and button register
    Then system display error message "<Error Message>"
    Examples:
      | Field Business Name              | Business Name | Error Message                                                                |
      | Empty Business Name              |               | Wajib diisi.                                                                 |
      | Business with special characters | @419t00!sdf   | Tidak dapat menggunakan karakter spesial selain titik (.) koma (,) strip (-) |
      | Business only special characters | .,-           | Wajib diisi, nama bisnis tidak boleh kurang dari 5 karakter.                 |

  Scenario Outline: Register failed with "<Field Email ada 2 yang salah>"
    And user are completed all fields except email
    When user input email "<Email>"
    And user click on checkbox register and button register
    Then system display error message "<Error Message>"
    Examples:
      | Field Email      | Email            | Error Message                                            |
      | Empty Email      |                  | Wajib diisi.                                             |
      | Invalid Email    | test.@test.com   | Harap isi dengan format yang benar.                      |
      | Email Registered | herbets@Test.com | Maaf, identitas sudah digunakan. Silakan coba yang lain. |
      | Invalid Email    | test.com         | Harap isi dengan format yang benar.                      |
      | Email with @     | test@            | Harap isi dengan format yang benar.                      |


  Scenario Outline: Register failed with "<Field Password>"
    And user are completed all fields except password
    When user input password "<Password>"
    And user input confirm password "<Password>"
    Then system display error message "<Error Message>"
    Examples:
      | Field Password | Password                      | Error Message                                          |
      | Empty Password |                               | Wajib diisi.                                           |
      | Password < 8   | 1234567                       | Min. 8 karakter, harus kombinasi dari huruf dan angka. |
      | Password > 20  | hurufsemuanyaasdfasdfasdfasdf | Min. 8 karakter, harus kombinasi dari huruf dan angka. |


  Scenario: Register failed with password not match
    When user input password "Password123!"
    And user input confirm password "Password1234!"
    Then system display error message "Belum sesuai dengan kata sandi."

