from scipy import spatial
import math
import os
dir=os.path.dirname(os.path.realpath(__file__))

def findSimilar():
    allBands=[]
    allVectors=[]
    vector=[]
    with open(dir+'//list_of_bandsFH.txt',encoding='utf-8') as f:
            line = f.readline()
            vector.append(int(line.split("++", 3)[1].strip()))
            vector.append(int(line.split("++", 3)[2].strip()))
            vector.append(int(line.split("++", 4)[3].strip()))
            line=f.readline()
            while (len(line.split("++", 1))==2):
                band=(line.split("++", 3)[0].strip())
                allBands.append(band)
                avgRating=int(line.split("++", 3)[1].strip())
                dist=int(line.split("++", 3)[2].strip())
                numberOfPositions=int(line.split("++", 3)[3].strip())
                allVectors.append([avgRating,dist,numberOfPositions])
                line=f.readline()
    print(allBands)
    allSimilarities={}
    u=0
    for i in allVectors:
        similarity=spatial.distance.cosine(vector,i)
        allSimilarities[allBands[u]] = math.log(similarity)
        u+=1
    sortedSimilarities={k: v for k, v in sorted(allSimilarities.items(), key=lambda item: item[1])}
    #print(sortdict)
    print(sortedSimilarities)
    print("---------------------------")
    return  list(sortedSimilarities.keys())

names=findSimilar()
print(names)
with open(dir+'//sortedBandsFH.txt', 'w',encoding='utf-8') as f:
    for i in names:
        f.write(i+'\n')

