package com.example.demo.Services.ServiceRealisation.SalesControllerService;

import com.example.demo.Services.Classes.Repository.SCRepo;
import com.example.demo.Services.Classes.SalesControllerClass.SalesController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SCService
{
    private final SCRepo repo;

    public SCService(SCRepo repo)
    {
        this.repo = repo;
    }

    public SalesController createSC(String name, int balance)
    {
        if (repo.getSalesControllerByName(name)!=null)
            return repo.getSalesControllerByName(name);
        else
        {
            SalesController salesController = new SalesController(name, balance);
            repo.save(salesController);
            return salesController;
        }
    }

    /*public void balance(SalesController salesController, int  amount)
    {
        System.out.println("In balance");
        int balance = salesController.getBalance() + 10 * amount;
        salesController.setBalance(balance);
        repo.save(salesController);
    }*/


    public void updateSCServiceInformation(SalesController salesController, int amount)
    {
        System.out.println("In updateSCServiceInformation");
        System.out.println("Sales Controller Balance " + salesController.getBalance());
        int balance = salesController.getBalance() + 10 * amount;
        System.out.println("after balance, before set balance");
        salesController.setBalance(balance);
        repo.save(salesController);
    }

    public String SCReport()
    {
        SalesController salesController = repo.getSalesControllerByName("cash");
        String report = salesController.toString();
        return report;
    }

}
