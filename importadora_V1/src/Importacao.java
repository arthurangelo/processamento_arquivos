import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Importacao {

    public static void main(String args[]) throws Exception {

        List<Cliente> listClientes = new ArrayList<>();
        List<String> lista = new ArrayList<>();

        File file = new File(System.getProperty("user.dir") + "/Cliente.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while (br.ready()) {
            lista.add(br.readLine());
        }

        for (String linha : lista) {
            Cliente cliente = new Cliente();
            cliente.setTipo(linha.charAt(1));
            cliente.setCpf(linha.substring(2,13));
            cliente.setNome(linha.substring(13,43).trim());
            cliente.setEndereco(linha.substring(43,73).trim());
            cliente.setBairro(linha.substring(73,103).trim());
            cliente.setCidade(linha.substring(103,133).trim());
            cliente.setEstado(linha.substring(133,135));
            String dataCadastro = linha.substring(135,143);
            String horaCadastro = linha.substring(143,149);
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy hhmmss");
            cliente.setDataHoraCadastro(sdf.parse(dataCadastro+" "+horaCadastro));

            listClientes.add(cliente);
        }
        DAO dao = new DAO();
        dao.saveAll(listClientes);

        lista.clear();
        List<Transacao> listTransacao = new ArrayList<>();
        file = new File(System.getProperty("user.dir") + "/Transacao.txt");
        fr = new FileReader(file);
        br = new BufferedReader(fr);

        while (br.ready()) {
            lista.add(br.readLine());
        }

        for (String linha : lista) {
            Transacao transacao = new Transacao();
            transacao.setCodigoEstabelecimento(Integer.parseInt(linha.substring(42,48)));
            String data = linha.substring(35,40);
            String hora = linha.substring(41,46);
            transacao.setDataTransacao(new SimpleDateFormat("ddMMyyyy hhmmss").parse(data + " " + hora ));
            transacao.setDetalhe(linha.charAt(0));
            transacao.setNumeroConta(new Integer(linha.substring(1,7)));
            transacao.setNumeroPlastico(new Integer(linha.substring(8,15)));
            transacao.setValorTransacao(new Double(linha.substring(16,27)));
        }
        dao.saveAllTransacoes(listTransacao);
    }
}
