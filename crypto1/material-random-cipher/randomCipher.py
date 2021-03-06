import string
import sys

plaintext = list(string.ascii_lowercase + string.ascii_uppercase)
cipher = ['t', 'w', 's', 'y', 'i', 'c', 'p', 'h', 'a', 'v', 'z', 'j', 'e', 'm', 'n', 'f', 'l', 'q', 'x', 'g', 'o', 'r', 'b', 'd', 'u', 'k', 'T', 'W', 'S', 'Y', 'I', 'C', 'P', 'H', 'A', 'V', 'Z', 'J', 'E', 'M', 'N', 'F', 'L', 'Q', 'X', 'G', 'O', 'R', 'B', 'D', 'U', 'K']

f = list(open(sys.argv[1], "r").read())

result = []

for i in f:
    if i in plaintext:
        result.append(cipher[plaintext.index(i)])
    else:
        result.append(i)

fout = open(sys.argv[2], "w")
fout.write("".join(result))
