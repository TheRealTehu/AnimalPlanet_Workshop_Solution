package org.example.animal;

public abstract class Animal {
    protected String name;
    protected int age;
    protected boolean hasOwner;

    protected Animal(String name, int age, boolean hasOwner) {
        this.name = name;
        this.age = age;
        this.hasOwner = hasOwner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    public abstract void makeNoise();
    public abstract <T> void eat(T... food); //VARARGS
}
