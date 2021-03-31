// CPU Task scheduling
// Leetcode https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/826/

#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>

void printSchedule(std::vector<std::string> const& tasks)
{
    for (auto t : tasks) {
        std::cout << t << " -> ";
    }
    std::cout << "\n";
}

void printTaskArray(std::vector<std::string> const& tasks)
{
    for (auto t : tasks) {
        std::cout << t << " , ";
    }
    std::cout << "\n";
}

std::vector<std::string> generateSchedule(std::vector<std::string> const& tasks, const int taskCooldown)
{
    int n = tasks.size();
    int maxTime = n + (n - 1) * taskCooldown;
    std::vector<std::string> schedule(maxTime, "idle");
    int lastIdleIndex = 0;

    std::unordered_map<std::string, int> map;

    for (int i = 0; i < n; ++i) {
        if (map.find(tasks[i]) != map.end()) {
            // task was added before so now add in gap
            int index = map[tasks[i]] + taskCooldown + 1;
            schedule[index] = tasks[i];
            map[tasks[i]] = index;
        } else {
            // find empty index
            while (schedule[lastIdleIndex].compare("idle") != 0) {
                lastIdleIndex++;
            }

            // Add to empty index
            schedule[lastIdleIndex] = tasks[i];
            map[tasks[i]] = lastIdleIndex;
        }
    }

    return schedule;
}

int findMinTime(std::vector<std::string> const& schedule)
{
    int n = schedule.size() - 1;
    while (schedule[n].compare("idle") == 0) {
        n--;
    }
    return n + 1;
}


void test(std::vector<std::string> const& tasks, const int taskCooldown)
{
    std::vector<std::string> schedule = generateSchedule(tasks, taskCooldown);
    std::cout << "Tasks : ";
    printTaskArray(tasks);
    std::cout << "Cooldown time : " << taskCooldown << "\n";
    std::cout << "Schedule : ";
    printSchedule(schedule);
    std::cout << "Min time required : " << findMinTime(schedule) << "\n";
}

int main()
{
    std::vector<std::string> tasks1 {"A","A","A","A","A","A","B","C","D","E","F","G"};
    int cooldown = 2;
    test(tasks1, cooldown);
    std::cout << "\n================================================\n";

    std::vector<std::string> tasks2 {"A","A","A","B","B","B"};
    cooldown = 2;
    test(tasks2, cooldown);
    std::cout << "\n================================================\n";

    std::vector<std::string> tasks3 {"A","A","A","B","B","B"};
    cooldown = 0;
    test(tasks3, cooldown);
    std::cout << "\n================================================\n";

    return 0;
}