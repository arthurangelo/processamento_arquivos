package factory;

import leitura.LeituraTxt;
import processadora.base.ObterDadosDefault;
import processadora.base.Template;
import processadora.cliente.ClienteTemplate;
import processadora.cliente.EnviarDadosCliente;
import processadora.cliente.ProcessarDadosCliente;
import processadora.transacao.EnviarDadosTransacao;
import processadora.transacao.ProcessarDadosTransacao;
import processadora.transacao.TransacaoTemplate;

public enum FactoryTemplates {

    CLIENTE("Cliente.txt"
            ,System.getProperty("user.dir") + "/resources/Cliente.txt"
            ,new ClienteTemplate(new ObterDadosDefault(new LeituraTxt())
            ,new ProcessarDadosCliente(), new EnviarDadosCliente())),

    TRANSACAO("Transacao.txt"
            ,System.getProperty("user.dir") + "/resources/Transacao.txt"
            , new TransacaoTemplate(new ObterDadosDefault(new LeituraTxt())
            , new  ProcessarDadosTransacao(), new EnviarDadosTransacao()));

    private String arquivo;
    private String fonte;
    private final  Template template;

    FactoryTemplates(String arquivo,String fonte, Template template) {
        this.arquivo = arquivo;
        this.fonte = fonte;
        this.template = template;
    }

    public static FactoryTemplates getTemplateByArquivo(String arquivo) {
        for (FactoryTemplates factory : FactoryTemplates.values()) {
            if (factory.arquivo.contains(arquivo)) {
                return factory;
            }
        }

        return null;
    }

    public Template getTemplate(){
        return this.template;
    }

    public String getNomeArquivo() {
        return this.arquivo;
    }

    public String getFonte() {
        return this.fonte;
    }
}
