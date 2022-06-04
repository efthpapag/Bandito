from scipy import spatial
import math
import os
dir=os.path.dirname(os.path.realpath(__file__))

def findSimilar():
    allBandPos=[]
    allVectors=[]
    vector=[]
    with open(dir+'//list_of_bandPositions.txt',encoding='utf-8') as f:
            line = f.readline()
            vector.append(int(line.split("++", 5)[1].strip()))
            vector.append(int(line.split("++", 5)[2].strip()))
            vector.append(int(line.split("++", 5)[3].strip()))
            vector.append(int(line.split("++", 5)[4].strip()))
            vector.append(int(line.split("++", 5)[5].strip()))
            line=f.readline()
            while (len(line.split("++", 1))==2):
                bandPos=(line.split("++", 5)[0].strip())
                allBandPos.append(bandPos)
                age=int(line.split("++", 5)[1].strip())
                avgRating=int(line.split("++", 5)[2].strip())
                dist=int(line.split("++", 5)[3].strip())
                avgExperience=int(line.split("++", 5)[4].strip())
                numberOfpos=int(line.split("++", 5)[5].strip())
                allVectors.append([age,avgRating,dist,avgExperience,numberOfpos])
                line=f.readline()
    print(allBandPos)
    allSimilarities={}
    u=0
    for i in allVectors:
        similarity=spatial.distance.cosine(vector,i)
        allSimilarities[allBandPos[u]] = math.log(similarity)
        u+=1
    sortedSimilarities={k: v for k, v in sorted(allSimilarities.items(), key=lambda item: item[1])}
    #print(sortdict)
    print(sortedSimilarities)
    print("---------------------------")
    return  list(sortedSimilarities.keys())

names=findSimilar()
print(names)
with open(dir+'//sortedBandPositions.txt', 'w',encoding='utf-8') as f:
    for i in names:
        f.write(i+'\n')

