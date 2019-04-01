import sys

filename = sys.argv[1]
new_file = ''

with open(filename) as f:
    content = f.readlines()
    
    for line in content:
        if '@DisplayName' in line:
            continue
        new_file += line

with open(filename + '.updated', 'w') as f:
    f.write(new_file)