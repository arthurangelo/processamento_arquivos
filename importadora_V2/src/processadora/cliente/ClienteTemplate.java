package processadora.cliente;

import processadora.base.Dados;
import processadora.base.Template;
import processadora.services.EnviarDados;
import processadora.services.ObterDados;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ClienteTemplate extends Template {
    private List<Dados> dados = new ArrayList<>();

    public ClienteTemplate(ObterDados obterDados, EnviarDados enviarDados){
        this.enviarDados =enviarDados; ;
        this.obterDados = obterDados;
    }

    public List<Dados> processar(List<String> dados){
        this.dados.clear();
        for (String linha : dados) {
            Cliente cliente = new Cliente();
            cliente.setTipo(linha.charAt(1));
            cliente.setCpf(linha.substring(2, 13));
            cliente.setNome(linha.substring(13, 43).trim());
            cliente.setEndereco(linha.substring(43, 73).trim());
            cliente.setBairro(linha.substring(73, 103).trim());
            cliente.setCidade(linha.substring(103, 133).trim());
            cliente.setEstado(linha.substring(133, 135));
            String dataCadastro = linha.substring(135, 143);
            String horaCadastro = linha.substring(143, 149);
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy hhmmss");

            try {
                cliente.setDataHoraCadastro(sdf.parse(dataCadastro + " " + horaCadastro));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            this.dados.add(cliente);
        }
        return  this.dados;
    }

}
