package processadora.transacao;

import processadora.base.Dados;
import processadora.services.ProcessarDados;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProcessarDadosTransacao implements ProcessarDados {

    private List<Dados> dados = new ArrayList<>();

    @Override
    public List<Dados> processar(List<String> dados) {

        this.dados.clear();

        for (String linha : dados) {
            Transacao transacao = new Transacao();
            transacao.setCodigoEstabelecimento(Integer.parseInt(linha.substring(42,48)));
            String data = linha.substring(35,40);
            String hora = linha.substring(41,46);
            transacao.setDetalhe(linha.charAt(0));
            transacao.setNumeroConta(new Integer(linha.substring(1,7)));
            transacao.setNumeroPlastico(new Integer(linha.substring(8,15)));
            transacao.setValorTransacao(new Double(linha.substring(16,27)));

            try {
                transacao.setDataTransacao(new SimpleDateFormat("ddMMyyyy hhmmss").parse(data + " " + hora ));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            this.dados.add(transacao);
        }

        return  this.dados;
    }
}
