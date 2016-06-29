package service;

import shop.Sells;

import java.util.Date;
import java.util.List;


public interface BLI {
    List<Sells> sellsByPeriod(Date begin , Date end);

    List<Sells> sellsByDay(Date date);






}
