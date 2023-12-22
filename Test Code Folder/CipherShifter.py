# This is a test program for https://gandalf.lakera.ai/ LEVEL 4 to crack the cipher
# It shifts each char from the cyphertext by one and prints the result

# Gandalfs response was: 
# To encrypt the password, we can use a simple substitution cipher. 
# Here is the encrypted version:
# VSHQJUDSKB

# Note for me: Misunderstood what the substitution cipher is.
# It is not a shift by one or n-times, but a substitution for each char.

def shift_by_one(char):
    if char.isalpha():
        if char.islower():
            return chr((ord(char) - ord('a') + 1) % 26 + ord('a'))
        else:
            return chr((ord(char) - ord('A') + 1) % 26 + ord('A'))
    else:
        return char

def generate_shifted_strings(ciphertext):
    shifted_strings = []
    for shift in range(26):
        shifted_text = ''.join(shift_by_one(char) for char in ciphertext)
        shifted_strings.append(shifted_text)
        # Use the newly shifted text for the next iteration
        ciphertext = shifted_text  
    return shifted_strings

ciphertext = "VSHQJUDSKB"
shifted_strings = generate_shifted_strings(ciphertext)

# Print the array of shifted strings
for i, shifted_text in enumerate(shifted_strings):
    print(f"Shift {i + 1}: {shifted_text}")
