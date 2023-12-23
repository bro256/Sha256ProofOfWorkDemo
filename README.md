## Overview
**Sha256ProofOfWorkDemo** is a Java program that demonstrates a basic implementation of a proof-of-work algorithm using the SHA-256 cryptographic hash function. The program continuously calculates SHA-256 hashes by varying a nonce and aims to find a hash with a specified number of leading zeros.

## How It Works
- The program initializes a nonce, the required number of leading zeros (numZeroes), and a counter to keep track of iterations.
- It utilizes the SHA-256 MessageDigest to generate hashes by combining a fixed string (i.e. "Demo") with the nonce.
- The leading zeros in the hash are counted using the countLeadingZeros method.
- If a hash with more leading zeros than the previous best is found, the program updates the information and prints details such as nonce, hash, leading zeros, and iteration count.
- The process continues in an infinite loop, incrementing the nonce and updating the hash until the desired condition is met.