# permutation -> 길이만큼 숫자가 있는지 판단하면 됨. (중복 X)
def solution(A):
    A.sort()
    step1_A = list(set(A)) # 중복 제거

    if len(A) != len(step1_A):
        return 0

    count = 1
    for i in step1_A:
        if count == i:
            count+=1
        else:
            return 0
            break
    return 1

if __name__ == '__main__':
    A = [4,1,3,2]
    solution(A)