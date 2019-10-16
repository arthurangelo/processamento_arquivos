package leitura;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Leitura {

     List<String> ler(String path) throws IOException;
}
