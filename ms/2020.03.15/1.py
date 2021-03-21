def solution(A):
    front = []
    back = []

    front.append(0)
    for i in range(1, len(A)):
        if front[i - 1] + A[i] < 0:
            front.append(0)
        else:
            front.append(front[i - 1] + A[i])

    back.append(0)
    for i in range(1, len(A)):
        if back[i - 1] + A[len(A) - 1 - i] < 0:
            back.append(0)
        else:
            back.append(back[i - 1] + A[len(A) - 1 - i])

    result = 0
    for i in range(1, len(A) - 1):
        result = max(result, front[i - 1] + back[len(A) - 2 - i])

    return result


if __name__ == "__main__":
    A = [3, 2, 6, -1, 4, 5, -1, 2]
    print(solution(A))
