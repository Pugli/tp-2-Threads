# tp-2-Threads
Trabajo Practico n2 sobre hilos

La diferencia entre runnable y thread, es que thread, es un clase donde ya posee todos los metodos declarados. En cambio, runnable, es una interfaz para implementar los metodos threads. Existen ambas, ya que, si tu clase ya posee herencia y se busca aplicar thread, se debera usar la interfaz runnable, ya que en java no existe la herencia multiple

Los hilos poseen un ciclo de vida que consta de 5 estados

-New: Cuando se crea una instancia de un thread pero antes que se inicie (start())

-Runnable: Esta en este estado despues de su invocacion pero antes que el sistema lo eleccione para ser el hilo que tome el recurso 

-Running: Si el sistema le dio el recurso, se encuentra en este estado 

-Non-Runnable: Es el estado cuando el hilo todavia esta vivo, pero no es elegido por el sistema 

-Terminated: Un hilo terimina, cuando su metedo run() termina

Metodos 

-start(): Comienza la ejecucion del metedo run 

-sleep(): Detiene la ejecucion de un thread por un tiempo determinado 

-yield(): Cuando un hilo 1, toma el recurso y otro hilo 2 necesita con mayor urgencia ese recurso, entonces el hilo 2 toma el recurso y el hilo 1 vuelve al estado runnable 

-join(): Asegura que el metedo termine su ejecucion poniendo en wait() al hilo principal.
