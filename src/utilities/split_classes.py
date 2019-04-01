import sys
import os
'''
args:
    1: filename (drag and drop file in terminal/command line)
    2: initial number number for the class name for example 1,2,3
Splits nested classes to different files
'''

filename = sys.argv[1]
n = sys.argv[2]
m = 0
name = ''
file_imports = ''
package_name = ''

def class_name(code):
    return code.splitlines()[0].split()[1].replace('{', '')

def format_spaces(code, name, f_imports, v_num, c_num):
    tmp = ''
    tmp += 'package ' + package_name + ';\n\nimport WhatNest.*;\n\n'
    tmp += f_imports
    tmp += '@DisplayName("' + str(v_num) + '.' + '{0:02}'.format(c_num) + ' - ' + name + '.' + class_name(code) + '")\n'
    for line in code.splitlines():
        if line == '':
            continue
        tmp += line[4:] + '\n'
    return tmp
    

with open(filename) as f:
    content = f.readlines()
    package_name = os.path.basename(f.name)[:-5]
    # finds imports from file
    for line in content:
        if 'class' in line:
            break
        file_imports += line

    # finds name for tests
    for line in content:
        if 'class' in line:
            words = line.split()
            name = words[1]
            break

    code = ''
    record = False
    for line in content:
        if '@Nested' in line:
            if record:
                m += 1
                cname = class_name(code) + '.java'
                code = format_spaces(code, name, file_imports, n, m)
                with open(os.path.dirname(filename) + '\\' + cname, 'w') as fout:
                    fout.write(code)
            code = ''
            record = True
            continue
        if record:
            code += line
    
    m += 1
    cname = class_name(code) + '.java'
    code = format_spaces(code, name, file_imports, n, m)
    with open(os.path.dirname(filename) + '\\' + cname, 'w') as fout:
        fout.write(code)