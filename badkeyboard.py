'''
The emplyee typed his name but as key board is dammaged when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

Let's examine the typed characters of the keyboard. 
Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
Return false if name was wrongly spelled.

 
Example 1:
Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.

Example 2:
Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it was not in the typed output.
 

Constraints:

1 <= name.length, typed.length <= 1000
name and typed consist of only lowercase English letters.

Input Format:
First line is actual name
Second line is name typed

Ouput Format:
Display boolean value True or False
'''
def is_long_pressed(name, typed):
    i, j = 0, 0

    while j < len(typed):
        if i < len(name) and name[i] == typed[j]:
            i += 1
            j += 1
        elif j > 0 and typed[j] == typed[j - 1]:
            j += 1
        else:
            return False

    return i == len(name)


name = input().strip()
typed = input().strip()


result = is_long_pressed(name, typed)
print(result)
