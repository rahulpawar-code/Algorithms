// https://levelup.gitconnected.com/producer-consumer-problem-using-mutex-in-c-764865c47483

#include <iostream>
#include <mutex>
#include <cstdlib>
#include <chrono>
#include <thread>

std::mutex g_mutex;
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

void producerFunc()
{
    while (true) {
        while (!g_ready) {
            std::this_thread::sleep_for(std::chrono::seconds(1));
        }
        std::unique_lock<std::mutex> ul(g_mutex);
        consumeData(g_data);
        g_ready = false;
    }
}

void consumerFunc()
{
    while (true) {
        std::unique_lock<std::mutex> ul(g_mutex);

        g_data = producerData();
        g_ready = true;

        ul.unlock();

        while (g_ready) {
            std::this_thread::sleep_for(std::chrono::seconds(1));
        }
    }
}

int main()
{
    std::thread consumerThread(consumerFunc);
    std::thread producerThread(producerFunc);

    consumerThread.join();
    producerThread.join();

    return 0;
}
