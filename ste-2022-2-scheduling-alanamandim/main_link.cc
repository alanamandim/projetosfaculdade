#include "defs.h"
#include "uart.h"
#include "LinkedList.h"

#include <stdio.h>

UART uart (UART:: UART_9600);

LinkedList<int,false,false>list;

void setup()
{
    for(int i=0; i<5; i++)
        list.insert(i);
     uart.puts("setup\n");
    
}

char strbuf[16];

void loop()
{
    while(list.size()>0)
    {
        sprintf(strbuf, "Dequeued: %d\n", list.remove_head());
        uart.puts(strbuf);
    }
}

int main()
{
    setup();
    while(true){
        loop();
    }
}