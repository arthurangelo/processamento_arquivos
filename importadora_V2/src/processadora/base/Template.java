package processadora.base;

import processadora.services.EnviarDados;
import processadora.services.ObterDados;
import processadora.services.ProcessarDados;

import java.io.*;
import java.util.List;

public abstract class Template {

    protected ObterDados obterDados;
    protected ProcessarDados processarDados;
    protected EnviarDados enviarDados;

    protected List<String> obterDados(String fonte) throws IOException {
        return obterDados.obterDados(fonte);
    }

    protected List<Dados> processar(List<String> dados){

        return processarDados.processar(dados);
    }

    protected void enviarDados(List<Dados> dados){
        enviarDados.enviarDados(dados);
    }

    public void run(String fonte) throws IOException {
        List<String> dados = obterDados(fonte);
        List<Dados> processados = processar(dados);
        enviarDados(processados);
    }







}
