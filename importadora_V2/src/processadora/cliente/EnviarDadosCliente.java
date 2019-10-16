package processadora.cliente;

import processadora.base.Dados;
import processadora.services.EnviarDados;

import java.util.List;

public class EnviarDadosCliente implements EnviarDados {
    @Override
    public void enviarDados(List<Dados> dados) {
        //metodo de salvar
        System.out.println("executando operacao de salvar cliente");
    }
}
