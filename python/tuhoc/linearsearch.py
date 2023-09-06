def linearsearch(list, terrget):
    for i in range(0, len(list)):
        if list[i] == terrget:
            return i +1
    return -1

print(linearsearch([1,2,3,6], 6))