for i in range(1,10):
    for j in range(1,11):
        num = i*j
        if j != 10:
            print(i,'x',j,'=',num,end=",")
        else :
            print(i,'x',j,'=',num,".")
