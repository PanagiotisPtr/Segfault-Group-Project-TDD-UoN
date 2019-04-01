import sys

'''
args:
    1: filename (drag and drop file in terminal/command line)
    2: initial number number for the class name for example 1,2,3
Adds @DisplayName tags for each testcase
Creates file with extension .updated and the same name as input
'''

filename = sys.argv[1]
k = sys.argv[2]
n = 0
m = 0
desc = ''
new_file = ''

def get_desc(line):
    n = 0
    for c in line:
        if c != ' ' and c != '*' and c != '/':
            break
        n += 1
    return line[n:].rstrip()

def num_spaces(line):
    spaces = ''
    for c in line:
        if c == '@':
            break
        spaces += ' '
    return spaces

def get_id(k, n, m):
    return str(k) + '.' + str(n) + '.' + str(m)

with open(filename) as f:
    content = f.readlines()
    for i in range(len(content)-1):
        line = content[i]
        if 'Written by' in content[i + 1]:
            desc = get_desc(line)
        if '@Nested' in line:
            n += 1
            m = 0
        if '@Test' in line:
            m += 1
            if get_id(k,n,m) not in desc:
                line = line + num_spaces(line) + '@DisplayName("' + desc + ' - ' + get_id(k,n,m) + '")\n'
            else:
                line = line + num_spaces(line) + '@DisplayName("' + desc + '")\n'
        new_file += line
    new_file += content[-1]

with open(filename + '.updated', "w") as f:
    f.write(new_file)
