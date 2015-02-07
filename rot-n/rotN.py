"""
So this is one of the oldest ciphers in existance, the rot-n or Ceaser Shift cipher.

This is what we call a "shift key substitution" cipher. It is called a substitution cipher
because the message's content is physically substituted by something else. It is called
a shift-key cipher because it shift the alphabet to achive substitution.

It is called a rot-N cipher because in the olden days they would physically have two disks
for encryption/decryption purposes, and they would rotate the cipher disk N units to achive
the desired result.

Example:
	rot 3:
		A --> D
		B --> E
		... ...
		W --> Z
		X --> A
		Y --> B
		Z --> C

Of course, in the modern age, we do rotation by ASCII numbers, so it is entirely possible
for a character to become unprintable or go into non-alphabetical chars. But for our
purposes, we'll stay in the realm of printable chars, or ASCII #32 to ASCII #126

For a full ascii table, you can go here:
http://www.asciitable.com/index/asciifull.gif
"""

import sys

N = int(sys.argv[1]) # The key is inputed via the terminal.

# We first open the file which we want to encrypt. This is fed to the program via the terminal.
# Since we are doing the shift-key-substitution on each character, we put the file into a char list.
fileCharList = list(open(sys.argv[2], "r").read())

outputList = [] # to be filled as the program runs.

for character in fileCharList:

	# We need to check to make sure the character is printable and not something like an escape sequence.
	# If it is an escape sequence we'll just keep it the way it is.
	if ord(character) < 32 or ord(character) > 126:
		outputList.append(character);

	# Else, we rotate. We know that the "base" of all characters is 32, so we take the current order, subtract
	# 32, add N (our rotation increment). Take that mod 94 (which is 126 - 32), and add that back to 32. This
	# is the easiest way to preserve the cycle like nature of rot-n ciphers.
	else:
		outputList.append(chr(32 + (ord(character) - 32 + N) % 94))

# Eventually we just join the output together and form a new string. This result can be pipped into another file.
print "".join(outputList);
