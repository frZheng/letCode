
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


des1 = ""
for i in range(len(source)):
    char = source[i]
    if i in res:
        char = char.upper()
    des1 += char
des1 = des1.replace("-", "")


# 去掉字符串前面的数字
des = ""
is_start = True
for i in range(len(des1)):
    char = des1[i]
    # print(char,char.isdecimal())
    if is_start and char.isdecimal():
        continue
    else:
        is_start = False
    des += char
    
print(" "*10,des)
with open("fileName.txt","w") as fout:
    fout.write(des)
