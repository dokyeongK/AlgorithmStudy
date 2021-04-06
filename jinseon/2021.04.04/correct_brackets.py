def solution(s):
    answer = True
    stack = []
    for char in s:
        if char=='(':
            stack.append(1)
        elif len(stack) == 0:
            return False
        else:
            stack.pop()
    if len(stack) == 0 : return True
    else : return False