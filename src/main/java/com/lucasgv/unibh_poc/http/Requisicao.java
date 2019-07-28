package com.lucasgv.unibh_poc.http;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 09/02/2019
 * Time: 20:14
 * To change this template use File | Settings | File and Code Templates.
 */
import lombok.Lombok;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;


public class Requisicao {
    @Getter @Setter private String baseURL, endpoint;
    @Getter @Setter private TipoRequisicao tipo;
    @Getter @Setter private Map<String, String> headers = new HashMap<String, String>(),
            payload = new HashMap<String, String>();
    @Getter @Setter private boolean followRedirects, ignoreContentType;
    private final static Logger logger = LogManager.getLogger(Requisicao.class);

    public Requisicao(){}

    public Requisicao(String baseURL) {
        this(baseURL, null, null, null, null, true, true);
    }

    public Requisicao(String baseURL, TipoRequisicao tipo, String endpoint) {
        this(baseURL, tipo, endpoint, null, null, true, true);
    }

    public Requisicao(String baseURL, TipoRequisicao tipo, String endpoint, Map<String, String> headers,
                      Map<String, String> payload, boolean followRedirects, boolean ignoreContentType) {

        this.baseURL = baseURL;
        this.tipo = tipo;
        this.endpoint = endpoint;
        this.headers = headers;
        this.payload = payload;
        this.followRedirects = followRedirects;
        this.ignoreContentType = ignoreContentType;
        logger.info("Objeto de requisição criado, propriedades inicializadas.");
    }

    public void addHeader(String key, String value){
        this.headers.put(key, value);
    }

    public void addPayload(String key, String value){
        this.payload.put(key, value);
    }

    public Connection.Response enviar(){
        Connection.Response resposta = null;

        try {
            logger.info("Inicializando método de envio...");
            logger.info("Enviando o payload...");
            switch(tipo){
                case GET:
                    /*doc = Jsoup.connect(String.format("%s%s",this.getBaseURL(), this.getEndpoint()))
                            .headers(this.getHeaders())
                            .followRedirects(this.isFollowRedirects())
                            .ignoreContentType(this.isIgnoreContentType())
                            .get();*/
                             resposta = Jsoup.connect(String.format("%s%s",this.getBaseURL(), this.getEndpoint()))
                            .headers(this.getHeaders())
                            .followRedirects(this.isFollowRedirects())
                            .ignoreContentType(this.isIgnoreContentType())
                            .method(Connection.Method.GET)
                            .execute();
                    break;
                case POST:
                    /*doc = Jsoup.connect(String.format("%s%s", this.getBaseURL(), this.getEndpoint()))
                            .headers(this.getHeaders())
                            .data(this.getPayload())
                            .ignoreContentType(this.ignoreContentType)
                            .post();*/
                             resposta = Jsoup.connect(String.format("%s%s",this.getBaseURL(), this.getEndpoint()))
                            .headers(this.getHeaders())
                            .followRedirects(this.isFollowRedirects())
                            .data(this.getPayload())
                            .ignoreContentType(this.isIgnoreContentType())
                            .method(Connection.Method.POST)
                            .execute();
                    break;

                default:
                    logger.info("Requisição enviada!");
                    logger.info("Retornando resultado...");

            }
        } catch (Exception e){
            logger.error(new StringBuilder("Problema ao enviar requisição: ").append(e));
        }
        return resposta;
    }
}