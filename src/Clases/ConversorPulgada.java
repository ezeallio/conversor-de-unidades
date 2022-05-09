package Clases;

import Excepciones.NumeroInvalidoExcepcion;

public class ConversorPulgada extends Conversor {

    @Override
    public Double ConvertirValor(int tipo) {
        Double resultado = 0.0;
        switch (tipo) {
            case 2 -> resultado = this.valor * 2.54 ; //Pulgada a Centimetros
            case 5 -> resultado = this.valor / 39370 ; //Pulgada a Kilometros
        }
        return resultado;
    }
    public ConversorPulgada(double valor) throws NumeroInvalidoExcepcion {
        super(valor);
    }
}
