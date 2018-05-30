class MinHeap:
    def __init__(obj):
        obj.heapList = [0]
        obj.currentSize = 0

    def minChild(obj, i):
        if (i * 2 + 1) > obj.currentSize:
            return i * 2
        else:
            if obj.heapList[i * 2] < obj.heapList[i * 2 + 1]:
                return i * 2
            else:
                return i * 2 + 1

    def percolateUp(obj, i):
        while i // 2 > 0:
            if obj.heapList[i] < obj.heapList[i // 2]:
                temp = obj.heapList[i // 2]
                obj.heapList[i // 2] = obj.heapList[i]
                obj.heapList[i] = temp
            i = i // 2


    def percolateDown(obj, i):
        while (i * 2) <= obj.currentSize:
            mc = obj.minChild(i)
            if obj.heapList[i] > obj.heapList[mc]:
                temp = obj.heapList[i]
                obj.heapList[i] = obj.heapList[mc]
                obj.heapList[mc] = temp
            i = mc

    def insert(obj, k):
        obj.heapList.append(k)
        obj.currentSize += 1
        obj.percolateUp(obj.currentSize)

    def removeMin(obj):
        returnValue = obj.heapList[1]
        obj.heapList[1] = obj.heapList[obj.currentSize]
        obj.currentSize -= 1
        obj.heapList.pop()
        obj.percolateDown(1)
        return returnValue

    def createHeap(obj, newList):
        i = len(newList) // 2
        obj.currentSize = len(newList)
        obj.heapList = [0] + newList[:]
        while i > 0:
            obj.percolateDown(i)
            i -= 1

import random as rand
x = []
for j in range(0, 5):
    x.append(rand.randint(1, 50))
mh = MinHeap()
mh.createHeap(x)
print('The list is:')
print(mh.removeMin())
print(mh.removeMin())
print(mh.removeMin())
print(mh.removeMin())
print(mh.removeMin())
