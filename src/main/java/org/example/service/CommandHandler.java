package org.example.service;

import org.example.entity.Buyurtma;
import org.example.enums.BuyurtmaState;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class CommandHandler {

    public static InlineKeyboardMarkup productMurkup(int quantity, long prductId){
        InlineKeyboardMarkup build = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("-").callbackData("-;" + quantity +";"+ prductId).build()
                        , InlineKeyboardButton.builder().text(String.valueOf(quantity)).callbackData("num").build()
                        , InlineKeyboardButton.builder().text("+").callbackData("+;" + quantity +";"+ prductId).build()))
                .keyboardRow(List.of(InlineKeyboardButton.builder().text("Add to basket ✅").callbackData("basket;" +prductId+";"+quantity).build()))
                .build();
        return build;
    }

    public static InlineKeyboardMarkup buyurtmaInline(Buyurtma buyurtma){
        InlineKeyboardMarkup build = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder()
                                .text("      -      ")
                                .callbackData(buyurtma.getProductId()).build())).build();
        return build;
    }
    public static InlineKeyboardMarkup orderInline(String s) {
        InlineKeyboardMarkup build = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder()
                                .text(s)
                                .callbackData(s).build())).build();
        return build;
    }
    public static InlineKeyboardMarkup adminInline(){
        InlineKeyboardMarkup build=InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Yo'q").callbackData("yo'q").build(),
                        InlineKeyboardButton.builder().text("Ha").callbackData("ha").build()
                )).build();

        return build;
    }
    public static InlineKeyboardMarkup adminOrder(String productId){
        InlineKeyboardMarkup build=InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Confirm").callbackData("Confirm;" + productId).build(),
                        InlineKeyboardButton.builder().text("Canceled").callbackData("Canceled;" + productId).build()
                )).build();
        return build;
    }
}
