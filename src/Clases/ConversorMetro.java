package Clases;

import Excepciones.NumeroInvalidoExcepcion;

public class ConversorMetro extends Conversor {

    @Override
    public Double ConvertirValor(int tipo) {
        Double resultado = 0.0;
        switch (tipo) {
            case 1 -> resultado = this.valor / 1000; //Metro a Kilometros 
            case 4 -> resultado = this.valor * 100; //Metro a Centimetros
        }
        return resultado;
    }
    public ConversorMetro(double valor) throws NumeroInvalidoExcepcion {
        super(valor);
    }
}
