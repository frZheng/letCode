

if __name__ == '__main__':
    pre = "insert into Customers values"
    str_line = [1]
    str = """
| 1           | Winston   |
| 2           | Jonathan  |
| 3           | Annabelle |
| 4           | Marwan    |
| 5           | Khaled    |
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



