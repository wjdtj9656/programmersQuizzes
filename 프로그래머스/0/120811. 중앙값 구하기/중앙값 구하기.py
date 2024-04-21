def solution(array):
    answer = 0
    mid = len(array)//2
    array = sorted(array)
    return array[mid]