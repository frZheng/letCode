
def find_all(source, target):

    result = []
    # 当find中没有第二个参数起步下标时，默认计算第一个要查找的字符的下标
    n = source.find(target)
    result.append(n)
    i = 1  # 设置一个计数值

    # 当find查找到要统计下标的字符时，返回字符所在下标，直到统计没有这个字符时，返回的下标为-1。
    while n != -1:

        # 计数累加
        i = i + 1

        # 从上一次统计到的下标+1的位置开始，继续统计“的”的下标
        n = source.find(target, n + 1)  #
        if n != -1:
            result.append(n)
    return result


# res = "binary-tree-level-order-traversal".find(":")
source = ""
with open("fin.txt","r") as fin:
    source = fin.readlines()[0]

if source[-1] == "/":
    source=source[:-1]
source_copy = source
print("\n", " "*10, "//web", source, "\n")
source = source.split("/")[-1]

print(source)
# source = "binary-tree-level-order-traversal"
res = find_all(source,"-")
import numpy as np
# res = np.array(res)
new_res = []
print(res)
for i in res:
    new_res.append(i+1)
res = new_res
print(res)


des = ""
for i in range(len(source)):
    char = source[i]
    if i in res:
        char = char.upper()
    des += char
des = des.replace("-", "")
print(" "*10,des)
with open("fileName.txt","w") as fout:
    fout.write(des)
    
with open("sql/{}.sql".format(des),"w") as fout:
    fout.write("-- web: ")    
    fout.write(source_copy + "\n")
    
    with open("creat_sql.sql","r") as fin:
        lines = fin.readlines()
        for line in lines:
            if line[-1] == "\n":
                line = line[:-1]
            fout.write(line + ";\n")
    
