#include "defs.h"
#include "uart.h"
#include "LinkedList.h"
#include <stdio.h>

UART uart (UART:: UART_9600);
LinkedList<int,true,false,int>list;
char strbuf[32];

void busy_wait_delay(int times)
{
    while (times--)
    {
        unsigned long x = 0x7ffff;
        while(x--) __asm__ ("nop");
    }
}


void setup()
{
    list.insert(0,5);
    list.insert(1,3);
    list.insert(2,4);
    list.insert(3,1);
    
    uart.puts("setup\n");
    sprintf(strbuf, "List size: %d\n", list.size());
    uart.puts(strbuf);

    busy_wait_delay(2);
}



void loop()
{
    while(list.size()>0)
    {
        sprintf(strbuf, "Dequeued: %d\n", list.remove_head());
        uart.puts(strbuf);
        busy_wait_delay(1);
    }
    // for (int i = 0; i < 4; i++)
    // {
    //     sprintf(strbuf, "%d\n", list.get(i));
    //     uart.puts(strbuf);
    // }

}

int main()
{
    setup();
    while(true){
        loop();
    }
}