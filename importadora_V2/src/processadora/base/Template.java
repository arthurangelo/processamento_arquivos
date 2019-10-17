package processadora.base;

import processadora.services.EnviarDados;
import processadora.services.ObterDados;

import java.io.*;
import java.util.List;

public abstract class Template {

    protected ObterDados obterDados;
    protected EnviarDados enviarDados;

    protected List<String> obterDados(String fonte) throws IOException {
        return obterDados.obterDados(fonte);
    }

    protected void enviarDados(List<Dados> dados) {
        enviarDados.enviarDados(dados);
    }

    public void run(String fonte) throws IOException {
        List<String> dados = obterDados(fonte);
        List<Dados> processados = processar(dados);
        enviarDados(processados);
    }

    protected abstract List<Dados> processar(List<String> dados);


}
