package src.main.java.service;

import src.main.java.shop.Sale;

import java.util.Date;
import java.util.List;


public interface BLI {
    List<Sale> sellsByPeriod(Date begin , Date end);

    List<Sale> sellsByDay(Date date);






}
