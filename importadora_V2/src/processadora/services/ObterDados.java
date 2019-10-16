package processadora.services;

import java.io.IOException;
import java.util.List;

public interface ObterDados {
    List<String> obterDados(String path) throws IOException;
}
