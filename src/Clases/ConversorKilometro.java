package Clases;

import Excepciones.NumeroInvalidoExcepcion;

public class ConversorKilometro extends Conversor {

    @Override
    public Double ConvertirValor(int tipo) {
        Double resultado = 0.0;
        switch (tipo) {
            case 1 -> resultado = this.valor * 1000; //KM a Metros
            case 3 -> resultado = this.valor * 100000; //KM a Centimetros
            case 5 -> resultado = this.valor * 39370; //KM a Pulgadas
     
        }
        return resultado;
    }
    public ConversorKilometro(double valor) throws NumeroInvalidoExcepcion{
        super(valor);
    }
}
