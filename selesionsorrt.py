list =[4,2,6,3,1]
for i in range(len(list)):
    min_list = i
    for j in range(i+1, len(list)):
        if list[j] < list[min_list]:
           min_list = j
    list [i], list[min_list] = list[min_list], list[i]
print (list)
