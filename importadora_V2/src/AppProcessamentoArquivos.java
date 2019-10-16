import processadora.base.Template;
import factory.FactoryTemplates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppProcessamentoArquivos {
    public static void main(String[] args) throws IOException {

        List<String> arquivosProcessar = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("proc-")) {
                String arquivo = args[i].replace("proc-","");
                arquivosProcessar.add(arquivo);
            }
        }

        for(String arquivo : arquivosProcessar){
            FactoryTemplates factory = FactoryTemplates.getTemplateByArquivo(arquivo);

            Template template = factory.getTemplate();
            template.run(factory.getFonte());

        }

    }
}
