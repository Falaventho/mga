import datetime


f = open('input.txt', 'r')
data = f.read()
f.close()

data = data.split("\n")
print(data)



for i in range(len(data)):
    data[i] = "'" + data[i] + "'"
        


print(data)
f = open('output.txt', 'w')
f.write(", ".join(data))


    # data[i] = data[i].split(' ')
    # data[i][1] = "'" + datetime.datetime.strptime(data[i][1], '%m/%d/%Y').strftime('%Y-%m-%d') + "'"
    # data[i][2] = "'" + datetime.datetime.strptime(data[i][2], '%m/%d/%Y').strftime('%Y-%m-%d') + "'"
    # data[i][3] = "'" + data[i][3] + "'"
    # data[i] = ", ".join(data[i])
    
    
    
    
    # data[i][1] = data[i][1] = "'" + data[i][1] + "'"
    # data[i][2] = data[i][2] = "'" + data[i][2] + "'"
    # data[i][3] = "'" + datetime.datetime.strptime(data[i][3], '%m/%d/%Y').strftime('%Y-%m-%d') + "'"
    # data[i][4] = data[i][4].strip()
    # data[i][4] = "'" + datetime.datetime.strptime(data[i][4], '%m/%d/%Y').strftime('%Y-%m-%d') + "'"
    # data[i] = ', '.join(data[i])
    
    
    
    # data[i][0] = "'" + datetime.datetime.strptime(data[i][0], '%m/%d/%Y').strftime('%Y-%m-%d') + "'"
    # data[i] = ', '.join(data[i])
    
    
    
    
    # data[i][0] = "'" + data[i][0] + "'"
    # data[i][1] = "'" + data[i][1] + "'"
    # data[i][3] = "'" + data[i][3] + "'"
    # data[i] = ", ".join(data[i])


# for i in range(len(data)):
#     data[i] = data[i].split(' ')
#     data[i][1] = "'" + data[i][1] + "'"
#     data[i][3] = "'" + data[i][3] + "'"
#     data[i][4] = "'" + data[i][4] + "'"
#     data[i] = ", ".join(data[i])

# for i in range(len(data)):
#     data[i] = data[i].split(' ')
#     data[i][1] = "'" + datetime.datetime.strptime(data[i][1], '%m/%d/%Y').strftime('%Y-%m-%d') + "'"
#     data[i][2] = "'" + datetime.datetime.strptime(data[i][2], '%m/%d/%Y').strftime('%Y-%m-%d') + "'"
#     data[i][3] = "'" + data[i][3] + "'"
#     data[i] = ", ".join(data[i])