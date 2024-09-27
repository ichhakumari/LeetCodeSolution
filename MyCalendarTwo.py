from sortedcontainers import SortedDict

class MyCalendarTwo:
    def __init__(self):
        self.booking_counts = SortedDict()

    def book(self, start: int, end: int) -> bool:
        
        self.booking_counts[start] = self.booking_counts.get(start, 0) + 1
        self.booking_counts[end] = self.booking_counts.get(end, 0) - 1

        running_sum = 0

        for count in self.booking_counts.values():
            running_sum += count

            if running_sum > 2:
              
                self.booking_counts[start] -= 1
                self.booking_counts[end] += 1

                return False

        return True

