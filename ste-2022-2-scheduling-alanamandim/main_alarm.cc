#include "defs.h"
#include "uart.h"
#include "adc.h"
#include "timer.h"
#include "alarm.h"
#include "fifo_linear.h"
#include <stdio.h>

UART uart(UART::UART_9600);
ADC adc (ADC::ADC_CH0);
FIFO_LINEAR<unsigned int,40>adc_fifo;

char strbuf[32];

FunctionQueue fqueue;
Timer0 timer;
Alarm alarm(&fqueue);

Event evt1, evt2;

void valorADC(void * arg)
{
    alarm.schedule(&evt1);
    adc_fifo.enqueue(adc.get());
}

float media()
{
    unsigned int val;
    unsigned long long media= 0;
    for(int i =0; i<40;i++){
        adc_fifo.dequeue(&val);
        media +=val;
    }
    return media/40;
}

void printMsg1(void * arg)
{
    alarm.schedule(&evt2);
    sprintf(strbuf, "Media : %f\n", media());
    uart.puts(strbuf);
}


void setup()
{
    uart.puts("setup\n");
    timer.registerObserver(&alarm);

    evt1.time = 25000;
    evt1.func = valorADC;
    evt1.args = (void*) 0;
    evt1.priority = 1;
    //evt1.realease_time = Timer0::micros();
    alarm.schedule(&evt1);

    evt2.time = 1000000;
    evt2.func = printMsg1;
    evt2.args = (void*) 0;
    evt2.priority = 2;
    alarm.schedule(&evt2);
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