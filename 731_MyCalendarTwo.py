# You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a triple booking.

# A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).

# The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

# Implement the MyCalendarTwo class:

# MyCalendarTwo() Initializes the calendar object.
# boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.


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

