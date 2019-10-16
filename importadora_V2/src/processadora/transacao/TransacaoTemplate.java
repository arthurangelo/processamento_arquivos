package processadora.transacao;

import processadora.base.Template;
import processadora.services.EnviarDados;
import processadora.services.ObterDados;
import processadora.services.ProcessarDados;

public class TransacaoTemplate extends Template {

    public TransacaoTemplate(ObterDados obterDados, ProcessarDados processarDados, EnviarDados enviarDados){
        this.enviarDados =enviarDados;
        this.obterDados = obterDados;
        this.processarDados =processarDados ;
    }

}
