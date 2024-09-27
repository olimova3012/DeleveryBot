package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.BuyurtmaState;

import java.util.Random;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Buyurtma {
    private String productId = UUID.randomUUID().toString();
    private Long ownerChatId;
    private String  name;
    private String phone;
    private String menuType;
    private String mealName;
    private int count;
    private double price;
    private BuyurtmaState state;


    public void clear(){
        count=0;
        price=0d;
        state=BuyurtmaState.CHALA;
    }

    @Override
    public String toString() {
        return "Buyurtma{" +
                "\nname='" + name + '\'' +
                ",\nphone='" + phone + '\'' +
                ",\nmenuType='" + menuType + '\'' +
                ",\nmealName='" + mealName + '\'' +
                ",\ncount=" + count +
                ",\nprice=" + price +
                ",\nstate=" + state +
                '}';
    }
}
