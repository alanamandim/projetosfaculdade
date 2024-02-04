
#include "uart.h"
#include "adc.h"
#include <stdio.h>
#include "defs.h"
#include "timer.h"
#include "alarm.h"
#include <stdio.h>

UART uart(UART::UART_9600);
char strbuf[32];

FIFO_LINEAR<unsigned int,40>fifo;

FunctionQueue fqueue;
Timer0 timer;
Alarm alarm(&fqueue);

ADC adc(ADC::ADC_CH0);

Event evt1, evt2;

//pega os valores do adc e poem na fifo
const char * MSG1 = "Oi, tudo bem?\n";
void printMsg1(void * arg)
{
    alarm.schedule(&evt1);
    char * msg = (char *) arg;
    uart.puts(msg);
}

//informa o valor da media
const char * MSG2 = "ping\n";
void printMsg2(void * arg)
{
    alarm.schedule(&evt2);
    char * msg = (char *) arg;
    uart.puts(msg);
}

void setup()
{
    uart.puts("setup\n");
    timer.registerObserver(&alarm);

    evt1.time = 1000000;
    evt1.func = printMsg1;
    evt1.args = (void*) MSG1;
    alarm.schedule(&evt1);

    evt2.time = 200000;
    evt2.func = printMsg2;
    evt2.args = (void*) MSG2;
    alarm.schedule(&evt2);
}

// void busy_wait_delay(int times)
// {
//     while (times--)
//     {
//         unsigned long x = 0x7ffff;
//         while(x--) __asm__ ("nop");
//     }
// }


float media()
{
    unsigned int val;
    unsigned long long media= 0;
    for(int i =0; i<40;i++){
        fifo.dequeue(&val);
        media +=val;
    }
    return media/40;
}

void loop()
{
    fqueue.run();
    //sprintf(strbuf," %d\n",media());
    // //imprima via uart, a cada medição, o valor atualizado da média
    // uart.puts(strbuf);
    // busy_wait_delay(1);
    

    
}
    

    
    
    

    
    // uart.puts("loop\n");

int main()
{
    setup();
    while (true)
    {
        loop();
    }
}