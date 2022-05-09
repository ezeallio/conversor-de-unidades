package Clases;

import Excepciones.NumeroInvalidoExcepcion;

public class ConversorCentimetro extends Conversor {

    @Override
    public Double ConvertirValor(int tipo) {
        Double resultado = 0.0;
        switch (tipo) {
            case 2 -> resultado = this.valor / 2.54 ; //Centimetro a Pulgadas
            case 3 -> resultado = this.valor / 100000; //Centimetro a Kilometros
            case 4 -> resultado = this.valor / 100; //Centimetro a Metros
        }
        return resultado;
    }
    public ConversorCentimetro(double valor) throws NumeroInvalidoExcepcion {
        super(valor);
    }
}
