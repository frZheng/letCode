

if __name__ == '__main__':
    table = "Numbers"
    pre = "insert into {} values".format(table)
    str_line = [1]
    str = """
|1    | A          | 2341   |
|2    | A          | 341    |
|3    | A          | 15     |
|4    | A          | 15314  |
|5    | A          | 451    |
|6    | A          | 513    |
|7    | B          | 15     |
|8    | B          | 13     |
|9    | B          | 1154   |
|10   | B          | 1345   |
|11   | B          | 1221   |
|12   | B          | 234    |
|13   | C          | 2345   |
|14   | C          | 2645   |
|15   | C          | 2645   |
|16   | C          | 2652   |
|17   | C          | 65     |
"""
    lines = str.split("\n")
    res_no_str = []
    for line in lines:
        if len(line) < 5:continue
        # print(line)
        line_split = line.split("|")
        one_value = []
        for str1 in line_split:
            start_index = 0
            end_index = 0
            for i in range(len(str1)):
                if str1[i]!=" ":
                    start_index = i
                    break
            for i in range(len(str1)-1,-1,-1):
                if str1[i] != " ":
                    end_index = i+1
                    break
            # print(start_index,end_index)
            if end_index != start_index:
                one_value.append(str1[start_index:end_index])
        one_res = ""
        for i in one_value:
            one_res += i
            one_res += ","
        one_res = one_res[:-1]
        # print(one_res)
        # exit()
        res_no_str.append(one_res)


    
    res = []
    for line in res_no_str:
        line_split = line.split(",")
        one_res = ""
        for i in range(len(line_split)):
            if i in str_line:
                one_res += "'"
                one_res += line_split[i]
                one_res += "'"
                one_res += ","
            else:
                one_res += line_split[i]
                one_res += ","
        one_res = one_res[:-1]
        res.append(one_res)
    for i in res:
        print(pre + " (" + i + ");")
    print("select * from {};".format(table))



