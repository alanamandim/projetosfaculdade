#include "defs.h"
#include "uart.h"
#include "adc.h"
#include "timer.h"
#include "alarm.h"
#include "fifo_linear.h"
#include <stdio.h>

UART uart(UART::UART_9600);

FunctionQueue fqueue;
Timer0 timer;
Alarm alarm(&fqueue);

Event evt1, evt2;

void evt1_func(void * arg)
{
    uart.puts("Task 0 - start\n");
    timer.delay(2000000);
    alarm.schedule(&evt1);
    uart.puts("Task 0 - end\n");
}

void evt2_func(void * arg)
{
    uart.puts("Task 1 - start\n");
    timer.delay(2000000);
    alarm.schedule(&evt2);
    uart.puts("Task 1 - end\n");
}

void setup()
{
    uart.puts("setup\n");
    timer.registerObserver(&alarm);

    evt1.time = 4000000;
    evt1.func = evt1_func;
    evt1.args = (void*) 0;
    evt1.priority = 1;
    evt1.release_time = Timer0::micros();
    // alarm.schedule(&evt1);
    fqueue.insert(&evt1, evt1.priority);

    evt2.time = 6000000;
    evt2.func = evt2_func;
    evt2.args = (void*) 0;
    evt2.priority = 2;
    evt2.release_time = Timer0::micros();
    // alarm.schedule(&evt2);
    fqueue.insert(&evt2, evt2.priority);
}

void loop()
{
    fqueue.run();
}

int main()
{
    setup();

    while (true)
    {
        loop();
    }
}
