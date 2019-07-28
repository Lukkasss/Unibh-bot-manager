package com.lucasgv.unibh_poc.main;

import com.lucasgv.unibh_poc.telegram.Telegram;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 19/02/2019
 * Time: 23:43
 * To change this template use File | Settings | File and Code Templates.
 */
public class Main {
    public static void main(String[] args) {

        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new Telegram());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }
}
