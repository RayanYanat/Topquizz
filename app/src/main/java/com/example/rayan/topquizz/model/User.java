package com.example.rayan.topquizz.model;

public class User {

    private String mFirstName ;

    /**
     * recupére et met à jour le prénom
     * @return
     */
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    /**
     * permet de renvoyer une valeur sous forme de String
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "mFristName='" + mFirstName + '\'' +
                '}';
    }
}

