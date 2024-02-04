#include "uart.h"
#include "FQueue.h"
// #include "timer.h"
// #include "gpio_pin_h"

UART uart(UART::UART_9600);
Event evt;

// Timer0 timer0;
// GPIO_Pin pin(GPIO_Pin::GPIO_PORTB, GPIO_Pin::GPIO_Pin_5, GPIO_Pin::GPIO_OUTPUT);
void printMsg(void * arg)
{
    char * msg = (char *) arg;
    uart.puts(msg);
    fqueue.enqueue(evt);
}

const char * MSG = "Oi, tudo bem?";

void setup()
{
    __asm__("sei");
    uart.puts("setup\n");
    
    evt.time = 0;
    evt.func = printMsg;
    evt.args = (void*) MSG;
    fqueue.enqueue(evt);
}


int main()
{
    setup();
    while(1)
    {
        fqueue.run();

    }
}