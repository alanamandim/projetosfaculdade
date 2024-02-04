// Arquivo: main.cc
// Autor: Arliones Hoeller, IFSC-SJE

#include "gpio_pin.h"
#include "uart.h"
#include "adc.h"
#include "fifo.h"
#include <stdio.h>


UART uart(UART::UART_9600);
ADC adc(ADC::ADC_CH0);
char strbuf[64];

void setup()
{

     __asm__ ("sei"); //liga interrupçao global

    uart.puts("setup\n");
}

void busy_wait_delay(int times)
{
    while (times--)
    {
        unsigned long x = 0x7ffff;
        while(x--) __asm__ ("nop");
    }
}


int media()
{
    int val = 0;
    for(int i=0; i<16;i++)
    val = val+adc.get(i);
    val = val/16;

}

void loop()
{
    
    sprintf(strbuf,"Media do ADC : %d\n",media());
    //imprima via uart, a cada medição, o valor atualizado da média
    uart.puts(strbuf);
    busy_wait_delay(1);
    

    
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
