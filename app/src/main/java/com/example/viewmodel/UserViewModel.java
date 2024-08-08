package com.example.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.Calendar;

public class UserViewModel extends ViewModel
{
    private final MutableLiveData<String> name = new MutableLiveData<>();
    private final MutableLiveData<String> apellido = new MutableLiveData<>();
    private final MutableLiveData<String> genero = new MutableLiveData<>();
    private final MutableLiveData<Integer> birthYear = new MutableLiveData<>();
    private final MutableLiveData<String> message = new MutableLiveData<>();

    public MutableLiveData<String> getName()
    {
        return name;
    }

    public MutableLiveData<String> getApellido()
    {
        return apellido;
    }


    public MutableLiveData<Integer> getBirthYear()
    {
        return birthYear;
    }

    public MutableLiveData<String> getMessage()
    {
        return message;
    }

    public void setName(String userName)
    {
        name.setValue(userName);
        updateMessage();
    }

    public void setApellido(String userApellido)
    {
        apellido.setValue(userApellido);
        updateMessage();
    }

    public void setGenero(String userGenero)
    {
        genero.setValue(userGenero);
        updateMessage();
    }

    public void setBirthYear(Integer userBirthYear)
    {
        birthYear.setValue(userBirthYear);
        updateMessage();
    }

    public void updateMessage()
    {
        if (name.getValue() != null && birthYear.getValue() != null )
        {
            int age = calculateAge(birthYear.getValue());
            String userMessage = name.getValue() +" "+ apellido.getValue() + " Usted tiene "+ age + " años" + "\n" + " Eres " + genero.getValue();
            message.setValue(userMessage);

        }

    }
    private  int  calculateAge(int birthYear)
    {
        Calendar today= Calendar.getInstance();
        int currentYear= today.get(Calendar.YEAR);
        return currentYear - birthYear;
    }


}