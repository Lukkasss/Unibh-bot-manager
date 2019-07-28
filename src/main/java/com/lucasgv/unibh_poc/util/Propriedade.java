package com.lucasgv.unibh_poc.util;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.swing.text.Utilities;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import static java.nio.charset.StandardCharsets.*;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 10/02/2019
 * Time: 00:30
 * To change this template use File | Settings | File and Code Templates.
 */
public class Propriedade {
    private final static Logger logger = LogManager.getLogger(Propriedade.class);
    @Getter @Setter private String login, senha, baseURL, arquivoProperties;
    private InputStream input;

    public Propriedade(String arquivoProperties) {
        this.arquivoProperties = arquivoProperties;
        this.load();
    }

    public void load() {
        Properties prop = new Properties();
        try {
            input = getClass().getClassLoader().getResourceAsStream(arquivoProperties);
            if(input != null){
                prop.load(input);
                this.setBaseURL(prop.getProperty("baseURL"));
                this.setLogin(prop.getProperty("Login"));
                this.setSenha(prop.getProperty("Senha"));
                logger.info("Arquivo de configurações carregado!");
            } else{
                logger.error(new FileNotFoundException("Arquivo não encontrado."));
            }

        } catch(Exception e) {
            logger.error(new StringBuilder("Problema ao carregar: ").append(e));
        }
    }
}
