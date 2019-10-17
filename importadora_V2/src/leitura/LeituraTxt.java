package leitura;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeituraTxt implements Leitura{
    private List<String> linhas;
    @Override
    public  List<String> ler(String path) throws IOException {
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        linhas = new ArrayList<>();
        while (br.ready()) {
            linhas.add(br.readLine());
        }
        fr.close();
        br.close();
        return linhas;
    }
}
