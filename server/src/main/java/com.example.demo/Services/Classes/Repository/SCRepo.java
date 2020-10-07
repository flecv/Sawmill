package com.example.demo.Services.Classes.Repository;

import com.example.demo.Services.Classes.SalesControllerClass.SalesController;
import org.springframework.data.repository.CrudRepository;

public interface SCRepo extends CrudRepository<SalesController, String>
{
    SalesController getSalesControllerByName(String id);
}
