volatile int scale =0;
int hold =0;
int a0;

enum State_t{
  wait =0,
  adquire_entradas = 1,
  processa_V = 2,
  processa_mV = 3,
  imprime_saida = 4
};

enum scale_v
{
  V = 0,
  mV = 1
};
State_t state = wait;

scale_v v_state = V;
  
void scale_isr(){
  static unsigned long ultima_interrupcao = 0;
  static unsigned long tempo_botao = 50;

  unsigned long agora = millis();
  if((agora-ultima_interrupcao)>= tempo_botao){
    scale = 1;
    ultima_interrupcao = agora;
  }
}

void setup(){
  //Inicializar HW
  pinMode(2, INPUT);
  pinMode(3,INPUT);
  Serial.begin(115200);
  state=wait;
  v_state=V;
  attachInterrupt(digitalPinToInterrupt(2), scale_isr, RISING);
  Serial.println("setup");
}

unsigned long saida;




void loop(){
  int botao;
  

  switch(state){
  

    case wait:
  //  Serial.println("Wait");
    delay(5000);
    state = adquire_entradas;
    break;
    
    case adquire_entradas:
    a0 = analogRead(A0);
    noInterrupts();
    botao = scale;
    //scale=0;
    interrupts();
    
    if(botao==1){
      if(v_state==V){
        v_state=mV;  
             
      }else{
          v_state=V;
          
      }
    attachInterrupt(digitalPinToInterrupt(2), scale_isr, LOW);      
    }
    if(v_state==V){
      state = processa_V;
    //  Serial.println("Processa V");
    }else{
      state = processa_mV;
    //  Serial.println("Processa mV");      
    
    }
  
   
    break;

    case processa_mV:
    saida =((long)a0)*(((long)5000000)/((long)1023)) ;
    hold = digitalRead(3);
    if(hold==0){ 
      state = imprime_saida;
    }else{
    //  Serial.println("Vai para wait");
      state = wait;
    }
    attachInterrupt(digitalPinToInterrupt(2), scale_isr, RISING);
    break;

    case processa_V:
    saida =(((long)a0)*(((long)5000000)/((long)1023))/1000) ;
    hold = digitalRead(3);
    if(hold==0){
    //  Serial.println("Imprime_saida");
      state = imprime_saida;
      
    }else{
    //  Serial.println("Vai para wait");
      state = wait;
    }
    attachInterrupt(digitalPinToInterrupt(2), scale_isr, RISING);
   
    break;

    case imprime_saida:
    state = wait;
    Serial.print(saida);
    if(v_state==V){
      Serial.println("V");
    }else{
      Serial.println("mV");
    }
    scale=0;
    break;
  
  }
}
