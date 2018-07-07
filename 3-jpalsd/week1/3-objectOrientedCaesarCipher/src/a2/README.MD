# Assignment 2: Two Keys

In this assignment, you will put together the `CaesarCipherTwo` class that encrypts a message with two keys (the same way as the previous lesson:

- `key1` is used to encrypt every other letter, starting with the first, and
- `key2` is used to encrypt every other letter, starting with the second), and also decrypts the same message.

In addition you will create a second class, `TestCaesarCipherTwo` to test examples that use the `CaesarCipherTwo` class, including:

- writing a method that will automatically decrypt an encrypted file by determining the two keys that were used to encrypt it.

Specifically, you should do the following.

Create the `CaesarCipherTwo` class with the following parts:

- Include private fields for the `alphabet`, `shiftedAlphabet1`, and `shiftedAlphabet2`.
- Write a constructor `CaesarCipherTwo` that has two int parameters `key1` and `key2`. This method should initialize all the private fields.
- Write an `encrypt` method that has one String parameter named `input`. This method returns a String that is the input encrypted using the two shifted alphabets.
- Write a `decrypt` method that has one String parameter named input. This method returns a String that is the encrypted String decrypted using the `key1` and `key2` associated with this `CaesarCipherTwo` object. You might want to add more private fields to the class.

Create the `TestCaesarCipherTwo` class with the following parts:

- Include the methods `halfOfString`, `countLetters`, and `maxIndex` that you wrote in the previous lesson.
- Write the void method `simpleTests` that has no parameters. This method should read in a file as a String, create a `CaesarCipherTwo` object with keys 17 and 3, encrypt the String using the `CaesarCipherTwo` object, print the encrypted String, and decrypt the encrypted String using the `decrypt` method.
- Write the method `breakCaesarCipher` that has one String parameter named input. This method should figure out which keys were used to encrypt this message (in a similar manner as before), then create a `CaesarCipherTwo` object with that key and decrypt the message.
- In the `simpleTests` method, add a call to `breakCaesarCipher` on the encrypted String to decrypt it automatically by determining the keys, and then print the decrypted String.

Link to FAQ page for this course: http://www.dukelearntoprogram.com/course3/faq.php