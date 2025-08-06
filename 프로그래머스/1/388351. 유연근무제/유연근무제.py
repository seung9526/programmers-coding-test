def solution(schedules, timelogs, startday):
    def get_valid_time(time):  
        hour = time // 100
        minute = time % 100 + 10
        if minute >= 60:
            hour += 1
            minute -= 60
        return hour * 100 + minute

    def is_weekday(day):  
        return 1 <= day <= 5

    result = 0
    for i in range(len(schedules)):
        valid_time = get_valid_time(schedules[i])
        logs = timelogs[i]

        is_late = False
        for j in range(7): 
            current_day = (startday + j - 1) % 7 + 1  
            if is_weekday(current_day):
                if logs[j] > valid_time:
                    is_late = True
                    break  

        if not is_late:
            result += 1

    return result
