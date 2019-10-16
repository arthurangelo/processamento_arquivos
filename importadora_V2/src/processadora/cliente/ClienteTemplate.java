package processadora.cliente;

import processadora.base.Template;
import processadora.services.EnviarDados;
import processadora.services.ObterDados;
import processadora.services.ProcessarDados;

public class ClienteTemplate extends Template {
    public ClienteTemplate(ObterDados obterDados, ProcessarDados processarDados, EnviarDados enviarDados){
        this.enviarDados =enviarDados; ;
        this.obterDados = obterDados;
        this.processarDados =processarDados ;
    }

}
