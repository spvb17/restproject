package com.example.backendfinalproject.exceptions;

public class IncorrectData
{
    private int status;
    private String info;

    public IncorrectData(){}
    public IncorrectData(int status, String info)
    {
        this.status = status;
        this.info = info;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }
}
