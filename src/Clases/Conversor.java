package Clases;

import Excepciones.NumeroInvalidoExcepcion;

public abstract class Conversor {
    protected Double valor;
    
    public Conversor(Double valor) throws NumeroInvalidoExcepcion{
        if (valor < 0) {
            throw new NumeroInvalidoExcepcion();
        }
        this.valor = valor;
    }
    public abstract Double ConvertirValor(int tipo);
        
}

