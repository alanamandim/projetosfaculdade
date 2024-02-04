#include "defs.h"
#include "uart.h"
#include "LinkedList.h"
#include <stdio.h>

UART uart(UART::UART_9600);

LinkedList<int,true,false,int>list;

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
}

char strbuf [16];

void loop()
{
    while (list.size() > 0)
    {
        sprintf(strbuf,"Dequeue: %d\n", list.remove_head());
        uart.puts(strbuf); // 3 1 2 0
        busy_wait_delay(5);
    }
}

int main()
{
    setup();
    while(true)
    {
        loop();
    }
}