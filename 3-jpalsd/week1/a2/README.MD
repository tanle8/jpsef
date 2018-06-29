# Assignment 2: Caesar Cipher

You will start with the Caesar Cipher algorithm you learned about in the videos, and you will make some enhancements to it, so that it works with all letters (both `uppercase` and `lowercase`) and to make it a little bit harder to decrypt. Write these methods in a `CaesarCipher` class you can use in the next lesson.

Specifically, you should do the following:

- Create a new class called `CaesarCipher`.
- Write the method `encrypt` that:
    - has two parameters, a String named `input` and an int named `key`.
    - This method returns a String that has been encrypted using the __Caesar Cipher algorithm__ explained in the videos.
    - Assume that all the alphabetic characters are uppercase letters.
    - For example:
        - the call `encrypt("FIRST LEGION ATTACK EAST FLANK!", 23)` should return the string "`CFOPQ IBDFLK XQQXZH BXPQ CIXKH!`"

- Write the void method `testCaesar` that:
    - has no parameters.
    - This method should read a file and encrypt the complete file using the `Caesar Cipher algorithm`, printing the encrypted message. You may want to include the lines:

        ```java
            FileResource fr = new FileResource();
            String message = fr.asString();
            String encrypted = encrypt(message, key);
            System.out.println("key is " + key + "\n" + encrypted);
        ```

- Modify the `encrypt` method to be able to handle both uppercase and lowercase letters.
    - For example,
        - `encrypt("First Legion", 23)` should return "`Cfopq Ibdflk`", and
        - `encrypt("First Legion", 17)` should return "`Wzijk Cvxzfe`".
    - Be sure to test the `encrypt` method.

- Write the method `encryptTwoKeys` that:

    - has three parameters, a String named `input`, and two integers named `key1` and `key2`.
    - This method returns a String that has been encrypted using the following algorithm
    - Parameter:

        - `key1` is used to encrypt every _other_ character with the __Caesar Cipher algorithm__, starting with the first character, and
        - `key2` is used to encrypt every _other_ character, starting with the second character.
    - For example:

        - the call `encryptTwoKeys("First Legion", 23, 17)` should return "`Czojq Ivdzle`". Note:

            - the 'F' is encrypted with key 23,
            - the first 'i' with 17,
            - the 'r' with 23, and
            - the 's' with 17, etc.
    - Be sure to test this method.

Link to FAQ page for this course: http://www.dukelearntoprogram.com/course3/faq.php
