// https://levelup.gitconnected.com/producer-consumer-problem-using-condition-variable-in-c-6c4d96efcbbc

#include <iostream>
#include <mutex>
#include <cstdlib>
#include <chrono>
#include <thread>
#include <condition_variable>

std::mutex g_mutex;
std::condition_variable g_cv;

bool g_ready = false;
int g_data = 0;

int producerData()
{
    int random = std::rand() % 1000;
    std::cout << "[PRODUER] : produced data : " << random << "\n";
    return random;
}

void consumeData(int data)
{
    std::cout << "[CONSUMER] : consumed data : " << data << "\n";
}

void consumerFunc(int times)
{
    while (times > 0) {
        std::unique_lock<std::mutex> ul(g_mutex);
        g_cv.wait(ul, []() { return g_ready; });
        consumeData(g_data);
        g_ready = false;

        ul.unlock();
        g_cv.notify_one();
        times--;
    }
}

void producerFunc(int times)
{
    while (times > 0) {
        std::unique_lock<std::mutex> ul(g_mutex);

        g_data = producerData();
        g_ready = true;

        ul.unlock();

        g_cv.notify_one();

        ul.lock();

        g_cv.wait(ul, []() { return g_ready == false; });
        times--;
    }
}

int main()
{
    int times = 100;
    std::thread consumerThread(consumerFunc, times);
    std::thread producerThread(producerFunc, times);

    consumerThread.join();
    producerThread.join();

    return 0;
}
