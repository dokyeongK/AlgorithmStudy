def solution(n, words):
    answer = []
    words_dic = {}
    player, turn = 0, 0

    for i, word in enumerate(words):
        if (i+1) % n == 0 : player = n
        else: player = (i+1) % n

        if i%n == 0: turn += 1

        if i != 0 and words[i][0] != words[i-1][-1]:
            print(word)
            answer.append(player)
            answer.append(turn)
            break

        if word not in words_dic:
            words_dic[word] = player
        else:
            answer.append(player)
            answer.append(turn)
            break

    else:
        answer.append(0)
        answer.append(0)

    return answer

n = 3
words = ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]   # [3,3]

# n = 5
# words = ["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]  # [0,0]

# n = 2
# words = ["hello", "one", "even", "never", "now", "world", "draw"]   # [1,3]

print(solution(n,words))
