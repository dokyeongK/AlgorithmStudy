def solution(A):
    A.sort()

    flag = 1
    for i, v in enumerate(A):
        if v != i + 1:
            flag = 0

    return flag


if __name__ == "__main__":
    A = [4, 2, 3, 1]
    print(solution(A))
    A = [4, 1, 3]
    print(solution(A))
