package com.lucasgv.unibh_poc.telegram;

import com.lucasgv.unibh_poc.anima.ulife.json.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucasgv.unibh_poc.anima.ulife.Ulife;
import com.lucasgv.unibh_poc.anima.ulife.json.Result;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.abilitybots.api.bot.AbilityBot;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 05/03/2019
 * Time: 15:45
 * To change this template use File | Settings | File and Code Templates.
 */
public class Telegram extends AbilityBot {
    private static String BOT_TOKEN = "728059597:AAFU1mBXfXDJZ1_x7PjrYUd0eSEsNE4ivkA";
    private static String BOT_USERNAME = "Unibh_Bot";
    Ulife u = new Ulife();

    public Telegram() {
        super(BOT_TOKEN, BOT_USERNAME);
    }

    @Override
    public int creatorId() {
        return 78784524;
    }

    public Ability getDisciplinas() {
        return Ability
                .builder()
                .name("disciplinas")
                .info("Lista todas as disciplinas cursadas nesse semestre.")
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> {
                    silent.send("Atualmente, as disciplinas registradas no módulo são:\n", ctx.chatId());
                    String materias = "";
                    try {
                        ObjectMapper mapper = new ObjectMapper();
                        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                        JsonNode node = mapper.readTree(u.getDisciplinas());
                        List<Result> myObjects = Arrays.asList(mapper.readValue(node.get("Result").toString(), Result[].class));
                        System.out.println(myObjects);
                        entitymanager crudOperations = new entitymanager();
                        for(Result r : myObjects) {
                            materias += r.getDisciplineName() + " - ClassID: " + r.getClassId() + "\n";
                            crudOperations.insertEntity(r);
                        }
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    silent.send(materias, ctx.chatId());
                })
                .build();
    }


}
