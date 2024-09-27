package org.example.util;

import java.util.Map;

public interface Utils {



    String SHOW_MENU = "🍴SHow menu";
    String MY_ORDERS = "📩My Orders";
    String SAVAT = "🛒SAVAT";
    String ALOQA = "☎Aloqa";
    String XABAR_YUBORISH = "✍Xabar yuborish";
    String SOZLAMALAR = "⚙ Sozlamalar";
    String BIZ_HAQIMIZDA = "📑Biz haqimizda";
    String[][] mainMenuUser = {
            {SHOW_MENU},
            {MY_ORDERS},
            {SAVAT,ALOQA},
            {XABAR_YUBORISH,SOZLAMALAR},
            {BIZ_HAQIMIZDA}
    };
    String BUYURTMA = "Buyurtma berish";
    String[][] savatMenu = {
            {BUYURTMA,"orqaga"},
    };
    String[][] order_menu = {
            {ALOQA,"orqaga"},
    };
    String[][] order_Admin_menu = {
            {"orqaga"},
    };


    String CREATE_MENU = "Create menu";
    String ADD_MEAL = "Add meal";
    String EDIT_MEAL = "Edit meal";
    String DELETE_MEAL = "Delete meal";
    String SHOW_HISTORY = "Show history";
    String CONFIRM_ORDER = "Confirm order";
    String[][] mainMenuAdmin = {
            {CREATE_MENU},
            {ADD_MEAL,EDIT_MEAL},
            {DELETE_MEAL,SHOW_HISTORY},
            {CONFIRM_ORDER}
    };


    String TILNI_OZGARTRISH="🌏Tilni o'zgartrish";
    String MALUMOTLARNI_TOZALASH="🗑Ma'lumotlari tozalash";
    String ORQAGA ="orqaga";

String [][] sozlamalarMenu={
        {TILNI_OZGARTRISH},
        {MALUMOTLARNI_TOZALASH},
        {ORQAGA}
};
    String [][] create_menu={
            {CREATE_MENU,ORQAGA}
    };


}
