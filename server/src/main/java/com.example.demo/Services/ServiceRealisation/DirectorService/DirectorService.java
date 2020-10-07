package com.example.demo.Services.ServiceRealisation.DirectorService;

import com.example.demo.Services.Classes.DirectorClass.Director;
import com.example.demo.Services.Classes.Repository.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DirectorService
{
    private final DirectorRepo repo;

    @Autowired
    public DirectorService(DirectorRepo repo)
    {
        this.repo = repo;
    }
    public Director createDirector(String name, int woodAmount, int balance)
    {
        if (repo.getDirectorByName(name)!=null)
            return repo.getDirectorByName(name);
        else
        {
            Director director = new Director(name, woodAmount, balance);
            System.out.println("woodAmount is " + woodAmount+" balance is " + balance);
            repo.save(director);
            return director;
        }
    }


    public void woodControl(Director director, int newSupply)
    {
        Random random = new Random();
        int sup = random.nextInt(newSupply)+((int)newSupply/2);
        System.out.println("We need new supply. Leader will deliver "+sup+" amount of wood to us");
        director.setWoodAmount(director.getWoodAmount() + sup);
    }


    public void updateDirectorInformation(Director director)
    {
        repo.save(director);
    }
    public String directorReport()
    {
        Director director = repo.getDirectorByName("Konrad");
        String report = director.toString();
        return report;
    }

}
