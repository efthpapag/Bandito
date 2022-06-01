from scipy import spatial
import math
import os
dir=os.path.dirname(os.path.realpath(__file__))

def findSimilar(vector):
    allUsers=[]
    allVectors=[]
    vector=[]
    with open(dir+'//list_of_musicians.txt',encoding='utf-8') as f:
            line = f.readline()
            vector.append(int(line.split("++", 4)[1].strip()))
            vector.append(int(line.split("++", 4)[2].strip()))
            vector.append(int(line.split("++", 4)[3].strip()))
            vector.append(int(line.split("++", 4)[4].strip()))
            line=f.readline()
            while (len(line.split("++", 1))==2):
                username=(line.split("++", 4)[0].strip())
                allUsers.append(username)
                age=int(line.split("++", 4)[1].strip())
                dist=int(line.split("++", 4)[2].strip())
                years_in_band=int(line.split("++", 4)[3].strip())
                years_of_experience=int(line.split("++", 4)[4].strip())
                allVectors.append([age,dist,years_in_band,years_of_experience])
                line=f.readline()
    print(allUsers)
    allSimilarities={}
    u=0
    for i in allVectors:
        similarity=spatial.distance.cosine(vector,i)
        allSimilarities[allUsers[u]] = math.log(similarity)
        u+=1
    sortedSimilarities={k: v for k, v in sorted(allSimilarities.items(), key=lambda item: item[1])}
    #print(sortdict)
    print(sortedSimilarities)
    print("---------------------------")
    return  list(sortedSimilarities.keys())

names=findSimilar([25,1500,0,10])
print(names)
with open(dir+'//sorted.txt', 'w',encoding='utf-8') as f:
    for i in names:
        f.write(i+'\n')

