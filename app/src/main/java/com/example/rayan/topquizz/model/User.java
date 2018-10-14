package com.example.rayan.topquizz.model;

public class User {

    private String mFristName ;

    /**
     * recupére et met à jour le prénom
     * @return
     */
    public String getFristName() {
        return mFristName;
    }

    public void setFristName(String fristName) {
        mFristName = fristName;
    }

    /**
     * permet de renvoyer une valeur sous forme de String
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "mFristName='" + mFristName + '\'' +
                '}';
    }
}

