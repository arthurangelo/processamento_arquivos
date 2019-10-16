package processadora.base;

import leitura.Leitura;
import processadora.services.ObterDados;

import java.io.*;
import java.util.List;

public class ObterDadosDefault implements ObterDados {
    private final Leitura leitura;

    public ObterDadosDefault(Leitura leitura){
        this.leitura = leitura;
    }
    
    @Override
    public List<String> obterDados(String path) throws IOException {
        return leitura.ler(path);
    }
}
