import sys
import copy

from collections import deque

def solution(A):
    print(A)
    front = [0]*len(A)
    back = [0]*len(A)

    for i in range(1, len(A)-2):
        temp = front[i-1]+A[i]
        if temp>0:
            front[i] = temp

    for j in range(len(A)-2, 1, -1):
        temp = back[j+1]+A[j]
        if temp>0:
            back[j] = temp

    result = 0

    for k in range(0, len(A)-2):
        if front[k]+back[k+2]>result:
            result = front[k]+back[k+2]

    return result

if __name__ == "__main__":
    print(solution([3, 2, 6, -1, 4, 5, -1, 2]))
