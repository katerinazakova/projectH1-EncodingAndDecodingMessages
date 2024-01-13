# Chuck Norris Cipher Encoder
Create an application for the unary representation and decoding of any text.
## 1. stage:
Read input:  
Prompt the user with the message "Input string:". Read a single line of text from the console.

Process and Output Characters:
Output all characters in the string, each separated by a single space. This includes space characters, which should be represented as they are, without removal or substitution.
## 2. stage:
In this stage, you'll learn how to convert each character of a string into a binary form. Any ASCII character has a size of 7 bits; in binary, the form is 0 and 1. For example, the character A has a decimal value of 65. 
Your program should read a string from a console. The input contains a single line.
Print The result: line, followed by each character of input on a separate line, formatted as <char> = <binary value>.
Note that the binary representation must be 7-bit, even if the first digits are zeros. The Integer.toBinaryString() and String.format() methods can help you with that.

Your program should look:

Input string:
> One

The result:

O = 1001111

n = 1101110

e = 1100101
## 3. stage:
You need to transform the text into the sequence of 0 and 1 and use the Chuck Norris technique. The encoded output message consists of blocks of 0. A block is separated from another block by a space.
Two consecutive blocks are used to produce a series of the same value bits (only 1 or0 values):

First block: it is always 0 or 00. If it is 0, then the series contains 1, if not, it contains 0.

Second block: the number of 0 in this block is the number of bits in the series.

For example: The C symbol in binary is represented as 1000011, so with Chuck Norris technique this gives:

0 0 (the first series consists of only a single 1);
00 0000 (the second series consists of four 0);
0 00 (the third consists of two 1)
So C is coded as: 0 0 00 0000 0 00

Your program should look:

Input string:
> C

The result:

0 0 00 0000 0 00

## 4. stage:
In this stage, you will write a decoder for a cipher. You need to transform the encrypted message into its original format.

Your program receives a string of zeros and spaces and converts it to readable text. You must parse the string to the blocks of zeroes and decode the message the same way as in previous stages but in reversed order.

For example, your program receives 0 0 00 0000 0 000 00 0000 0 00. You can split blocks of zeros and group those blocks by two. Then you need to decode these blocks like in the previous stage:

0 0 is 1
00 0000 is 0000
0 000 is 111
00 0000 is 0000
0 00 is 11
Concatenation of the lines above gives us 10000111000011.

After that, you need to split the result into blocks of seven symbols (binary form) and convert these blocks to characters. In this case, splitting 10000111000011 by seven symbols gives us two characters — 1000011 1000011 , convert them into characters and the result will be CC (C is 1000011).

Your program should look:

Input encoded string:
> 0 0 00 0000 0 000 00 0000 0 00

The result:

CC
## 5. stage:
The program asks the user for the desired option (encode/decode/exit), performs it, and all that in a loop until the user wants to finish.

In this stage, your program should:

1. Ask users what they want to do, encode a string, decode a string or quit the program with
Please input operation (encode/decode/exit):

2. If user inputs encode as the desired operation, the program should print Input string: to the output, read a line and output two lines — Encoded string: followed by the encoded string;

3. If user inputs decode as the desired operation, the program should print Input encoded string: to the output, read a line and output two lines — Decoded string: followed by the actual decoded string;

4. If user inputs exit as the desired operation, the program should say Bye! and finish its execution.

Also, let's prevent some incorrect input.

If the user misspells the operation name, the program should print out There is no '<input>' operation

If the user provided an incorrect encoded message as input to decode, the program should print out appropriate feedback containing not valid substring

List of not valid encoded messages:

The encoded message includes characters other than 0 or spaces;

The first block of each sequence is not 0 or 00;

The number of blocks is odd;

The length of the decoded binary string is not a multiple of 7.

Project from Hyperskill: https://hyperskill.org/
