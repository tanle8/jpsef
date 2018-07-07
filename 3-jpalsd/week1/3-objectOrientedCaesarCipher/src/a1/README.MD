# Assignment 1: One Key

In this assignment, you will:

- put together the `CaesarCipher` class from the lesson and
- add a decrypt method to decrypt with the same key.

In addition you will:

- create a _second_ class, `TestCaesarCipher` to test examples that use the `CaesarCipher` class, including:

    - writing a method that will automatically decrypt an encrypted file by determining the key and then decrypting with that key.

Specifically, you should do the following.

- Create the `CaesarCipher` class with the following parts:

    - Private fields for the `alphabet` and `shiftedAlphabet`
    - Write a constructor `CaesarCipher` that has one int parameter `key`. _This method should initialize all the private fields of the class_.
    - Write an `encrypt` method that:

        - has one String parameter named `input`.
        - This method returns a String that is the input encrypted using    `shiftedAlphabet`.
    - Write a `decrypt` method that:

        - has one String parameter named `input`.
        - This method returns a String that is the encrypted String decrypted using the key associated with this `CaesarCipher` object.
        - One way to do this is to create another private field `mainKey`, which is initialized to be the value of key.
        - Then you can create a `CaesarCipher` object within `decrypt`:

            ```java
            CaesarCipher cc = new CaesarCipher(26 - mainKey);
            ```
            and call

            ```java
            cc.encrypt(input)
            ```

Create the `TestCaesarCipher` class with the following parts:

- Include the methods `countLetters` and `maxIndex` that you wrote in the previous lesson.
- Write the void method `simpleTests` that:

    - has no parameters.
    - This method should:

        - read in a file as a String,
        - create a `CaesarCipher` object with key __18__,
        - encrypt the String read in using the `CaesarCipher` object,
        - __print__ the `encrypted` String, and
        - __decrypt__ the encrypted String using the `decrypt` method.

- Write the method `breakCaesarCipher` that:

    - has one String parameter named `input`.
    - This method should:

        - figure out which key was used to encrypt this message (in a similar manner as the previous lesson),
        - then create a `CaesarCipher` object with that key and decrypt the message.

- In the `simpleTests` method:

    - add a call to `breakCaesarCipher` on the encrypted String to decrypt it automatically by determining the key, and
    - print the decrypted String.

Link to FAQ page for this course: http://www.dukelearntoprogram.com/course3/faq.php