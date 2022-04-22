package com.company.streamPrec.entity;

public class Trader {
    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public boolean equals(Trader obj) {
        if(this.name.equals(obj.getName()) && this.city.equals(obj.getCity())){
            return true;
        }
        return false;
    }
}
