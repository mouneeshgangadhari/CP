'''
You are given a string s, which also contains +/- characters.

assume + as backspace and - as delete operators.
If + is encountered, remove the closest non + charecter to its left.
If - is encountered, remove the closest non - charecter to its right.

Return the string after all pluses and minuses have been removed.

Note:
The input will be generated such that the operation is always possible.

Sample Test Cases:
case=1
input=Hydee+raa+b--aaadd+
output=Hyderabad

case=2
input=Gr+-eate
output=Gate
'''

def process_string(s: str) -> str:
    stack = []
    i = 0
    
    while i < len(s):
        if s[i] == '+':
            # Backspace operation: remove the closest non-+ character to its left
            while stack and stack[-1] == '+':
                stack.pop()  # Remove + from stack
            if stack:
                stack.pop()  # Remove the closest non-+ character
        elif s[i] == '-':
            # Delete operation: remove the closest non-- character to its right
            C=1
            j=i+1
            while j<len(s) and s[j] == '-':
                C+=1
                j+=1
            i += (2*C)-1
            # We skip adding this character to the stack since it is 'deleted'
        else:
            stack.append(s[i])
        i += 1
    
    # Convert the stack back to a string
    return ''.join(stack)

# Test cases
S = input()
print(process_string(S))


'''
case=1
input=Hydee+raa+b--aaadd+
output=Hyderabad

case=2
input=Gr+-eate
output=Gate

case=3
input =abc+de-fg
output =abdeg

case=4
input =abcdef+++
output =abc

case=5
input=a-b-c-d
output=a

case=6
input=simpletext
output=simpletext

case=7
input=---abcdef+
output=de

case=8
input=abc++--efg
output=ag
'''