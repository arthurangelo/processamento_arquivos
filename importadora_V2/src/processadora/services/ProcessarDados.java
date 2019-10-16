package processadora.services;

import processadora.base.Dados;

import java.util.List;

public interface ProcessarDados {

    List<Dados> processar(List<String> dados);
}
