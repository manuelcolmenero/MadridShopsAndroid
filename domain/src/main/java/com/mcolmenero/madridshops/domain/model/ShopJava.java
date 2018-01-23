package com.mcolmenero.madridshops.domain.model;


import android.support.annotation.NonNull;

public final class ShopJava {
    private int id;
    private String name;
    private String address;

    public ShopJava(String name) {
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    // Se indica que name no puede cambiar (final) y que no puede pasar Null
    public void setName(final @NonNull String name) {
        assert (name != null);
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    {
        ShopJava shop1 = new ShopJava("Tienda 1");
        shop1.setAddress("Address");
        shop1.getAddress();
    }
}
/*
class HijaDeShop extends ShopJava {
    public HijaDeShop(String name) {
        super(name);
    }

    @Override
    public void setAddress(String address) {
        //super.setAddress(address);
        // No se llama a super y se realiza otra acción distinta
    }
}
*/