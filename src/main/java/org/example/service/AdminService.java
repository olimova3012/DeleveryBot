package org.example.service;

import org.example.db.Db;
import org.example.entity.Meal;
import org.example.entity.MenuType;

import java.util.ArrayList;

public class AdminService {

    private static final Db db = Db.getInstance();
    private final ReplyMarkupService replyMarkupService = new ReplyMarkupService();
    private final InlineMarkupService inlineMarkupService = new InlineMarkupService();


    public void addMenu(MenuType menuType) {
        db.getAllMeals().put(menuType,new ArrayList<>());
    }

    private static AdminService adminService;

    public static AdminService getInstance() {
        if (adminService == null) {
            adminService = new AdminService();
        }
        return adminService;
    }

}
